package cn.bobdeng.todolist.command.commands;

import org.springframework.stereotype.Service;

@Service
public class ExitCommand implements Command {

    @Override
    public void execute(String[] args) {
        System.exit(0);
    }

    @Override
    public String actionName() {
        return "exit";
    }
}
