package cn.bobdeng.todolist.command.commands;

import cn.bobdeng.todolist.command.TodoListFacade;
import cn.bobdeng.todolist.domain.todo.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class AddCommand implements Command, CommandNeedLogin {
    private final TodoListFacade todoListFacade;

    public AddCommand(TodoListFacade todoListFacade) {
        this.todoListFacade = todoListFacade;
    }

    @Override
    public void execute(String[] args) {
        TodoItem newItem = todoListFacade.newItem(args[1]);
        todoListFacade.printAll();
        todoListFacade.printTail("Item " + newItem.getIndex() + " added");
    }

    @Override
    public String actionName() {
        return "add";
    }
}
