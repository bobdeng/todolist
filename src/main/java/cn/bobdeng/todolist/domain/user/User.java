package cn.bobdeng.todolist.domain.user;

public class User {
    private String loginName;
    private String password;

    public User(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

    public boolean isLoginName(String loginName) {
        return this.loginName.equals(loginName);
    }

    public boolean isPasswordRight(String password) {
        return this.password.equals(password);
    }
}
