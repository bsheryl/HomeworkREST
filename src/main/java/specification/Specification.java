package specification;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

/**
 * Класс для создания спецификаций
 */
public class Specification {

    /**
     * Метод создает специкацию запроса
     * @return спецификация запроса
     */
    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/")
                .setContentType("application/json")
                .build();
    }

    /**
     * Метод создает спецификацию ответа
     * @return спецификация ответа
     */
    public static ResponseSpecification responseSpec() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    /**
     * Метод устанавливает спецификацию для всех запросов
     * @param requestSpec спецификация запроса
     */
    public static void installSpec(RequestSpecification requestSpec) {
        RestAssured.requestSpecification = requestSpec;
    }

    /**
     * Метод устанавливает спецификацию для всех ответов
     * @param responseSpec спецификация ответа
     */
    public static void installSpec(ResponseSpecification responseSpec) {
        RestAssured.responseSpecification = responseSpec;
    }

    /**
     * Метод устанавливает спецификацию для всех запросов и ответов
     * @param requestSpec спецификация запроса
     * @param responseSpec спецификация ответа
     */
    public static void installSpec(RequestSpecification requestSpec, ResponseSpecification responseSpec) {
        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }

    /**
     * Метод для удаления спецификации зопросов и ответов
     */
    public static void deleteSpec() {
        RestAssured.requestSpecification = null;
        RestAssured.responseSpecification = null;
    }
}
