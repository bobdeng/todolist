package cn.bobdeng.todolist.command.actions;

import cn.bobdeng.todolist.command.ConsolePrinter;
import org.springframework.stereotype.Service;

@Service
public class ActionNotSupport implements Action {
    private final ConsolePrinter consolePrinter;

    public ActionNotSupport(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    @Override
    public void execute(String[] args) {
        consolePrinter.printLn("Wrong command!");
    }

    @Override
    public String actionName() {
        return "";
    }
}