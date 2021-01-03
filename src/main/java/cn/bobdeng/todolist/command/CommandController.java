package cn.bobdeng.todolist.command;

import cn.bobdeng.todolist.Session;
import cn.bobdeng.todolist.command.actions.Action;
import cn.bobdeng.todolist.command.actions.ActionFactory;
import cn.bobdeng.todolist.command.actions.ActionNeedLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommandController implements CommandLineRunner {
    private final ActionFactory actionFactory;
    private final ConsolePrinter consolePrinter;
    private final Session session;

    public CommandController(ActionFactory actionFactory, ConsolePrinter consolePrinter, Session session) {
        this.actionFactory = actionFactory;
        this.consolePrinter = consolePrinter;
        this.session = session;
    }

    @Override
    public void run(String... args) {
        if (args.length < 1) {
            return;
        }
        try {
            executeAction(args);
        } catch (Exception e) {
            consolePrinter.printLn("error: " + e.getMessage());
        }
        System.out.println();
        consolePrinter.print("todo ");
    }

    private void executeAction(String[] args) {
        Action action = actionFactory.getAction(args[0]);
        if (action instanceof ActionNeedLogin && !session.loggedIn()) {
            consolePrinter.printLn("Please login first!");
            return;
        }
        action.execute(args);
    }
}
