package data;

/**
 * Класс для работы с результатами авторизации пользователя
 */
public class Logined {

    private String token;
    private String error;

    public String getToken() {
        return token;
    }

    public String getError() {
        return error;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setError(String error) {
        this.error = error;
    }
}
