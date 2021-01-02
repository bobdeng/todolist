package cn.bobdeng.todolist;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommandController implements CommandLineRunner {
    private final ActionFactory actionFactory;

    public CommandController(ActionFactory actionFactory) {
        this.actionFactory = actionFactory;
    }

    @Override
    public void run(String... args) {
        if (args.length < 2) {
            return;
        }
        actionFactory.getAction(args[1]).execute(args);
    }
}
