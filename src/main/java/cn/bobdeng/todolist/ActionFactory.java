package cn.bobdeng.todolist;

import org.springframework.stereotype.Service;

@Service
public class ActionFactory {
    private final AddAction addAction;

    public ActionFactory(AddAction addAction) {
        this.addAction = addAction;
    }

    public Action getAction(String actionName) {
        if (actionName.equals("add")) {
            return addAction;
        }
        throw new RuntimeException("not support");
    }
}
