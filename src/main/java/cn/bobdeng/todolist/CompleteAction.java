package cn.bobdeng.todolist;

import cn.bobdeng.todolist.domain.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class CompleteAction implements Action {
    private final TodoListFacade todoListFacade;
    public CompleteAction(TodoListFacade todoListFacade) {
        this.todoListFacade = todoListFacade;
    }

    @Override
    public void execute(String[] args) {
        todoListFacade.complete(Integer.parseInt(args[1]));
        todoListFacade.printAll();
        todoListFacade.prompt("Item " + Integer.parseInt(args[1]) + " done");
    }
}
