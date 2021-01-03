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
        executeAction(args);
        consolePrinter.print("todo ");
    }

    private void executeAction(String[] args) {
        Action action = actionFactory.getAction(args[0]);
        if (action instanceof NeedLogin && !session.loggedIn()) {
            consolePrinter.printLn("Please login first!");
            return;
        }
        action.execute(args);
    }
}
