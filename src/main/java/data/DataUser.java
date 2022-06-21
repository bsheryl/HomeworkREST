package data;

/**
 * Класс для работы с данными пользователей
 */
public class DataUser {

    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
    private String name;
    private Integer year;
    private String color;
    private String pantone_value;
    private String password;

    public DataUser() {
        super();
    }

    public DataUser(Integer id, String email, String first_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    public DataUser(Integer id, String name, Integer year, String color, String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantone_value = pantone_value;
    }

    public DataUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public DataUser(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getPantone_value() {
        return pantone_value;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String first_name) {
        this.first_name = first_name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPantone_value(String pantone_value) {
        this.pantone_value = pantone_value;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
