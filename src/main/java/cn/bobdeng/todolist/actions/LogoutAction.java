package cn.bobdeng.todolist.actions;

import cn.bobdeng.todolist.ConsolePrinter;
import cn.bobdeng.todolist.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class LogoutAction implements Action {
    private final ConsolePrinter consolePrinter;

    public LogoutAction(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    @Override
    public void execute(String[] args) {
        CurrentUser.user = null;
        consolePrinter.printLn("Logout success!");
    }

    @Override
    public String actionName() {
        return "logout";
    }
}
