package cn.bobdeng.todolist;

import cn.bobdeng.todolist.domain.CountByStatus;
import cn.bobdeng.todolist.domain.TodoItem;
import cn.bobdeng.todolist.domain.TodoListService;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class TodoListFacade {
    private final TodoListService todoListService;
    private final ConsolePrinter consolePrinter;

    public TodoListFacade(TodoListService todoListService, ConsolePrinter consolePrinter) {
        this.todoListService = todoListService;
        this.consolePrinter = consolePrinter;
    }

    void printAll() {
        print(todoItem -> true);
    }

    public void complete(int itemId) {
        todoListService.complete(itemId);
    }

    public void printTail(String message) {
        consolePrinter.printLn(message);
    }

    public TodoItem newItem(String newItem) {
        return todoListService.newItem(newItem);
    }

    public CountByStatus countByStatus() {
        return todoListService.count();
    }

    public void printAllDoing() {
        print(TodoItem::isDoing);
    }

    void print(Predicate<TodoItem> predicate) {
        todoListService.all().stream()
                .filter(predicate)
                .map(TodoItem::toString)
                .forEach(consolePrinter::printLn);
        consolePrinter.printLn("");
    }
}
