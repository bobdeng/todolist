package cn.bobdeng.todolist;

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
}
