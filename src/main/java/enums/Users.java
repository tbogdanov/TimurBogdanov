package enums;

public enum Users {

    PITER_CHAILOVSKII("PITER CHAILOVSKII", "epam", "1234");

    private String name;
    private String login;
    private String password;

    Users(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
