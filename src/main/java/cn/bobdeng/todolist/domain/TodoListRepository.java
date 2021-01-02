package cn.bobdeng.todolist.domain;

import java.util.List;

public interface TodoListRepository {
    void save(TodoItem todoItem);

    List<TodoItem> all();
}
