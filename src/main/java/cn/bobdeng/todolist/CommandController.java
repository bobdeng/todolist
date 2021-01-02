package cn.bobdeng.todolist;

import cn.bobdeng.todolist.domain.TodoListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommandController implements CommandLineRunner {
    private final ConsolePrinter consolePrinter;
    private final TodoListService todoListService;
    public CommandController(ConsolePrinter consolePrinter, TodoListService todoListService) {
        this.consolePrinter = consolePrinter;
        this.todoListService = todoListService;
    }

    @Override
    public void run(String... args) throws Exception {
        todoListService.newItem("item1");
    }
}
