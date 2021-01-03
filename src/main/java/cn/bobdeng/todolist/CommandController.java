package cn.bobdeng.todolist;

import cn.bobdeng.todolist.actions.Action;
import cn.bobdeng.todolist.actions.ActionFactory;
import cn.bobdeng.todolist.actions.NeedLogin;
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
        executeAction(args);
        consolePrinter.print("todo ");
    }

    private void executeAction(String[] args) {
        Action action = actionFactory.getAction(args[0]);
        if (action instanceof NeedLogin && CurrentUser.user == null) {
            consolePrinter.printLn("Please login first!");
            return;
        }
        action.execute(args);
    }
}
