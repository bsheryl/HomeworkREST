package helpers;

import data.DataUser;

import org.testng.annotations.DataProvider;

/**
 * Класс для предоставления тестируемых параметров
 */
public class DataProviderClass {

    /**
     * Метод предоставляет данные пользователей для тестирования успешной авторизации
     * @return email и password пользователей
     */
    @DataProvider(name="authorizationUsersSuccess")
    public static Object[][] provideAuthorizationUsersSuccess() {
        Object[][] users = new Object[1][1];

        users[0][0] = new DataUser("eve.holt@reqres.in", "cityslicka");
        return users;
    }

    /**
     * Метод предоставляет данные пользователей для тестирования попытки авторизации без пароля
     * @return email пользователя
     */
    @DataProvider(name="authorizationUsersWithoutPassword")
    public static Object[][] provideAuthorizationUsersWithoutPassword() {
        Object[][] users = new Object[1][1];

        users[0][0] = new DataUser("peter@klaven");
        return users;
    }

    /**
     * Метод предоставляет количество количество тегов для проверки
     * @return количество тегов
     */
    @DataProvider(name="countTags")
    public static Object[][] provideCountTags() {
        Object[][] users = new Object[1][1];

        users[0][0] = 14;
        return users;
    }
}
