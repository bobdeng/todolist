package cn.bobdeng.todolist.command.actions;

import org.springframework.stereotype.Service;

@Service
public class ExitAction implements Action {

    @Override
    public void execute(String[] args) {
        System.exit(0);
    }

    @Override
    public String actionName() {
        return "exit";
    }
}
