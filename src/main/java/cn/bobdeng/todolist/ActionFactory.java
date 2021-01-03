package cn.bobdeng.todolist;

import org.springframework.stereotype.Service;

@Service
public class ActionFactory {
    private final AddAction addAction;
    private final CompleteAction completeAction;
    private final ListAction listAction;
    private final LoginAction loginAction;
    public ActionFactory(AddAction addAction, CompleteAction completeAction, ListAction listAction, LoginAction loginAction) {
        this.addAction = addAction;
        this.completeAction = completeAction;
        this.listAction = listAction;
        this.loginAction = loginAction;
    }

    public Action getAction(String actionName) {
        if (actionName.equals("add")) {
            return addAction;
        }
        if (actionName.equals("done")) {
            return completeAction;
        }
        if(actionName.equals("list")){
            return listAction;
        }
        if(actionName.equals("login")){
            return loginAction;
        }
        throw new RuntimeException("not support");
    }
}
