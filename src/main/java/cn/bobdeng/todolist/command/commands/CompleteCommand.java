package cn.bobdeng.todolist.command.commands;

import cn.bobdeng.todolist.command.TodoListFacade;
import org.springframework.stereotype.Service;

@Service
public class CompleteCommand implements Command, CommandNeedLogin {
    private final TodoListFacade todoListFacade;
    public CompleteCommand(TodoListFacade todoListFacade) {
        this.todoListFacade = todoListFacade;
    }

    @Override
    public void execute(String[] args) {
        todoListFacade.complete(Integer.parseInt(args[1]));
        todoListFacade.printAll();
        todoListFacade.printTail("Item " + Integer.parseInt(args[1]) + " done");
    }

    @Override
    public String actionName() {
        return "done";
    }
}
