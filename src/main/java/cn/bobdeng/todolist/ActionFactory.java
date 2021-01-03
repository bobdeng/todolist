package cn.bobdeng.todolist;

import org.springframework.stereotype.Service;

@Service
public class ActionFactory {
    private final AddAction addAction;
    private final CompleteAction completeAction;

    public ActionFactory(AddAction addAction, CompleteAction completeAction) {
        this.addAction = addAction;
        this.completeAction = completeAction;
    }

    public Action getAction(String actionName) {
        if (actionName.equals("add")) {
            return addAction;
        }
        if (actionName.equals("done")) {
            return completeAction;
        }
        throw new RuntimeException("not support");
    }
}
