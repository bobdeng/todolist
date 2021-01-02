package cn.bobdeng.todolist;

import cn.bobdeng.todolist.domain.TodoListService;
import org.springframework.stereotype.Service;

@Service
public class AddAction implements Action {
    private final TodoListService todoListService;

    public AddAction(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @Override
    public void execute(String[] args) {
        todoListService.newItem("item1");
    }
}
