package cn.bobdeng.todolist.domain.todo;

import java.util.List;

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

    public void complete(int index) {
        todoListRepository.all().stream()
                .filter(todoItem -> todoItem.isIndex(index))
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
