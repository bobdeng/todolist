package cn.bobdeng.todolist.domain;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {
    private final TodoListRepository todoListRepository;

    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public TodoItem newItem(String todoItem) {
        return todoListRepository.insert(new TodoItem(1, todoItem));
    }

    public List<TodoItem> all() {
        return todoListRepository.all();
    }

    public void complete(int id) {
        todoListRepository.all().stream()
                .filter(todoItem -> todoItem.getId() == id)
                .findFirst()
                .map(TodoItem::complete)
                .ifPresent(todoListRepository::update);
    }
}
