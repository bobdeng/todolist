package cn.bobdeng.todolist.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TodoListRepositoryImpl implements TodoListRepository {
    private List<TodoItem> items = new ArrayList<>();

    @Override
    public void save(TodoItem todoItem) {
        items.add(todoItem);
    }

    @Override
    public List<TodoItem> all() {
        return new ArrayList<>(items);
    }
}
