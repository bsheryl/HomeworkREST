package in.reqres;

import data.DataUser;
import data.Logined;
import data.Resourse;
import helpers.DataProviderClass;
import io.restassured.path.xml.XmlPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static specification.Specification.*;

/**
 * Класс для тестирования REST API
 */
public class RestTests {

    /**
     * Метод получает имена всех аватаров и тестирует их на уникальность
     */
    @Test
    public void testFileNameAvatar() {
        installSpec(requestSpec(), responseSpec());

        Resourse resourse = given()
                .when()
                .get("/api/users?page=2")
                .then()
                .log().all()
                .extract().body().as(Resourse.class);
        List<DataUser> users = resourse.getData();

        List<String> nonunique = new ArrayList<>();
        for (int i = 0; i < users.size() - 1; ++i) {
            for (int j = i + 1; j < users.size(); ++j) {
                if (users.get(i).getAvatar().equals(users.get(j).getAvatar())) {
                    nonunique.add(users.get(i).getAvatar());
                }
            }
        }
        Assert.assertTrue(nonunique.size() == 0, "Неуникальные имена файлов аватаров: " + nonunique);

        deleteSpec();
    }

    /**
     * Метод тестирует успешную авторизацию пользователя в системе
     * @param user пользователь для авторизации
     */
    @Test(dataProvider="authorizationUsersSuccess", dataProviderClass = DataProviderClass.class)
    public void testAuthorizationUsersSuccess(DataUser user) {
        installSpec(requestSpec(), responseSpec());

        Logined logined = given()
                .body(user)
                .when()
                .post("/api/login")
                .then()
                .log().all()
                .extract().body().as(Logined.class);
        Assert.assertNotNull(logined.getToken(), "Пользователь " + user.getEmail() + " не авторизовался");

        deleteSpec();
    }

    /**
     * Метод тестирует авторизацию с ошибкой из-за невведенного пароля
     * @param user пользователь для авторизации
     */
    @Test(dataProvider="authorizationUsersWithoutPassword", dataProviderClass = DataProviderClass.class)
    public void testAuthorizationUserWithoutPassword(DataUser user) {

        Logined logined = given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .statusCode(400)
                .extract().body().as(Logined.class);
        Assert.assertEquals(logined.getError(), "Missing password",
                "Попытка авторизации без пароля завершается ошибкой " + logined.getError() + ", а должна завершаться с ошибкой 'Missing password'");

    }

    /**
     * Метод тестирует возвращаемые данные на отсортированность по году
     */
    @Test
    public void testGetDataSorted() {
        installSpec(requestSpec(), responseSpec());

        Resourse resourse = given()
                .when()
                .get("/api/unknown")
                .then()
                .log().all()
                .extract().as(Resourse.class);
        List<Integer> years = new ArrayList<>();
        resourse.getData().forEach(x->years.add(x.getYear()));
        List<Integer> unsorted = new ArrayList<>();
        for (int i = 0; i < years.size() - 1; ++i) {
            if (years.get(i).compareTo(years.get(i + 1)) > 0) {
                unsorted.add(years.get(i));
                unsorted.add(years.get(i + 1));
            }
        }
        Assert.assertTrue(unsorted.size() == 0, "Неотсортированные года: " + unsorted);

        deleteSpec();
    }

    /**
     * Метод тестирует сервис на количество тегов
     */
    @Test(dataProvider="countTags", dataProviderClass = DataProviderClass.class)
    public void checkCountTags(Integer size) {
        XmlPath xmlPath = given()
                .contentType("application/xml")
                .when()
                .get("https://gateway.autodns.com/")
                .then()
                .log().all()
                .statusCode(200)
                .extract().xmlPath();
        Assert.assertEquals(xmlPath.getList("response.**.findAll()").size(), size, "Количество тегов равно " + xmlPath.getList("response.**.findAll()").size() + ", а должно быть равно " + size);
    }
}
