package cn.bobdeng.todolist.command.commands;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommandFactory {
    private final Map<String, Command> actions;
    private final CommandNotSupport actionNotSupport;

    public CommandFactory(ApplicationContext applicationContext, CommandNotSupport actionNotSupport) {
        actions = applicationContext.getBeansOfType(Command.class)
                .values()
                .stream()
                .collect(Collectors.toMap(Command::actionName, action -> action));
        this.actionNotSupport = actionNotSupport;
    }

    public Command getAction(String actionName) {
        Command action = actions.get(actionName);
        if (action != null) {
            return action;
        }
        return actionNotSupport;
    }
}
