package cn.bobdeng.todolist;

import cn.bobdeng.todolist.domain.TodoItem;
import cn.bobdeng.todolist.domain.TodoListService;
import org.springframework.stereotype.Service;

@Service
public class AddAction implements Action {
    private final TodoListService todoListService;
    private final ConsolePrinter consolePrinter;

    public AddAction(TodoListService todoListService, ConsolePrinter consolePrinter) {
        this.todoListService = todoListService;
        this.consolePrinter = consolePrinter;
    }

    @Override
    public void execute(String[] args) {
        TodoItem newItem = todoListService.newItem(args[1]);
        consolePrinter.printLn("item " + newItem.getId() + " added");
    }
}
