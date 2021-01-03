package cn.bobdeng.todolist.actions;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ActionFactory {
    private final Map<String, Action> actions;

    public ActionFactory(ApplicationContext applicationContext) {
        actions = applicationContext.getBeansOfType(Action.class)
                .values()
                .stream().collect(Collectors.toMap(Action::actionName, action -> action));
    }

    public Action getAction(String actionName) {
        Action action = actions.get(actionName);
        if (action != null) {
            return action;
        }
        throw new RuntimeException("not support");
    }
}
