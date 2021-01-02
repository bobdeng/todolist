package cn.bobdeng.todolist.domain;

import java.util.List;

public interface TodoListRepository {
    TodoItem save(TodoItem todoItem);

    List<TodoItem> all();
}
