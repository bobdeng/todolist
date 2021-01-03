package cn.bobdeng.todolist;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommandController implements CommandLineRunner {
    private final ActionFactory actionFactory;
    private final ConsolePrinter consolePrinter;

    public CommandController(ActionFactory actionFactory, ConsolePrinter consolePrinter) {
        this.actionFactory = actionFactory;
        this.consolePrinter = consolePrinter;
    }

    @Override
    public void run(String... args) {
        if (args.length < 1) {
            return;
        }
        actionFactory.getAction(args[0]).execute(args);
        consolePrinter.print("todo ");
    }
}
