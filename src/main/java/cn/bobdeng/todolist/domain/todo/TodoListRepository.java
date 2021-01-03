package cn.bobdeng.todolist.domain.todo;

import java.util.List;

public interface TodoListRepository {
    TodoItem insert(TodoItem todoItem);

    List<TodoItem> all();

    void clear();

    void update(TodoItem todoItem);
}
