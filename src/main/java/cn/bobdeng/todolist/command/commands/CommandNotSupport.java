package cn.bobdeng.todolist.command.commands;

import cn.bobdeng.todolist.command.ConsolePrinter;
import org.springframework.stereotype.Service;

@Service
public class CommandNotSupport implements Command {
    private final ConsolePrinter consolePrinter;

    public CommandNotSupport(ConsolePrinter consolePrinter) {
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
