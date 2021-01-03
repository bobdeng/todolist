package cn.bobdeng.todolist.actions;

import cn.bobdeng.todolist.TodoListFacade;
import cn.bobdeng.todolist.domain.todo.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class AddAction implements Action, ActionNeedLogin {
    private final TodoListFacade todoListFacade;

    public AddAction(TodoListFacade todoListFacade) {
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
