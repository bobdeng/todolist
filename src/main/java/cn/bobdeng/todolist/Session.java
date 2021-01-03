package cn.bobdeng.todolist;

import org.springframework.stereotype.Service;

@Service
public class Session {
    private String user;

    public void loginWith(String user) {
        this.user = user;
    }

    public void logout() {
        this.user = null;
    }

    public String currentUser() {
        return user;
    }

    public boolean loggedIn() {
        return user != null;
    }
}
