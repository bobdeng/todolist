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
        int newIndex = todoListRepository.all().stream().mapToInt(TodoItem::getIndex)
                .max().orElse(0) + 1;
        return todoListRepository.insert(new TodoItem(newIndex, todoItem));
    }

    public List<TodoItem> all() {
        return todoListRepository.all();
    }

    public void complete(int id) {
        todoListRepository.all().stream()
                .filter(todoItem -> todoItem.getIndex() == id)
                .findFirst()
                .map(TodoItem::complete)
                .ifPresent(todoListRepository::update);
    }

    public CountByStatus count() {
        int total = todoListRepository.all().size();
        int totalDone = (int) todoListRepository.all().stream()
                .filter(TodoItem::isComplete)
                .count();
        return new CountByStatus(total, totalDone);
    }
}
