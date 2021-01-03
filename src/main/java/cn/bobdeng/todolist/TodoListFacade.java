package cn.bobdeng.todolist;

import cn.bobdeng.todolist.domain.TodoItem;
import cn.bobdeng.todolist.domain.TodoListService;
import org.springframework.stereotype.Service;

@Service
public class TodoListFacade {
    private final TodoListService todoListService;
    private final ConsolePrinter consolePrinter;

    public TodoListFacade(TodoListService todoListService, ConsolePrinter consolePrinter) {
        this.todoListService = todoListService;
        this.consolePrinter = consolePrinter;
    }

    void printAll() {
        todoListService.all().stream()
                .map(TodoItem::toString)
                .forEach(consolePrinter::printLn);
        consolePrinter.printLn("");

    }

    public void complete(int itemId) {
        todoListService.complete(itemId);
    }

    public void prompt(String message) {
        consolePrinter.printLn(message);
    }

    public TodoItem newItem(String newItem) {
        return todoListService.newItem(newItem);
    }
}
