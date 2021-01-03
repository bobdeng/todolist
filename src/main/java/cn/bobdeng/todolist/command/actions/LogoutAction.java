package cn.bobdeng.todolist.command.actions;

import cn.bobdeng.todolist.command.ConsolePrinter;
import cn.bobdeng.todolist.Session;
import org.springframework.stereotype.Service;

@Service
public class LogoutAction implements Action, ActionNeedLogin {
    private final ConsolePrinter consolePrinter;
    private final Session session;

    public LogoutAction(ConsolePrinter consolePrinter, Session session) {
        this.consolePrinter = consolePrinter;
        this.session = session;
    }

    @Override
    public void execute(String[] args) {
        session.logout();
        consolePrinter.printLn("Logout success!");
    }

    @Override
    public String actionName() {
        return "logout";
    }
}
