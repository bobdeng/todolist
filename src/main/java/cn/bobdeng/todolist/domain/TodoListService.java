package cn.bobdeng.todolist.domain;

import org.springframework.stereotype.Service;

@Service
public class TodoListService {
    private TodoListRepository todoListRepository;

    public TodoListService(TodoListRepository todoListRepository) {

        this.todoListRepository = todoListRepository;
    }

    public TodoItem newItem(String todoItem) {
        return todoListRepository.save(new TodoItem(1, todoItem));
    }
}
