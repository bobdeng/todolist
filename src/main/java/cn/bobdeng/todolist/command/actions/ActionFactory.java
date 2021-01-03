package cn.bobdeng.todolist.command.actions;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ActionFactory {
    private final Map<String, Action> actions;
    private final ActionNotSupport actionNotSupport;

    public ActionFactory(ApplicationContext applicationContext, ActionNotSupport actionNotSupport) {
        actions = applicationContext.getBeansOfType(Action.class)
                .values()
                .stream()
                .collect(Collectors.toMap(Action::actionName, action -> action));
        this.actionNotSupport = actionNotSupport;
    }

    public Action getAction(String actionName) {
        Action action = actions.get(actionName);
        if (action != null) {
            return action;
        }
        return actionNotSupport;
    }
}
