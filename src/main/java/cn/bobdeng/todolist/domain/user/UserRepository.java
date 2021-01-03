package cn.bobdeng.todolist.domain.user;

import java.util.List;

public interface UserRepository {
    void insert(User user);

    List<User> all();
}
