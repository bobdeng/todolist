package cn.bobdeng.todolist;

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
        todoListFacade.printTail("Item " + Integer.parseInt(args[1]) + " done");
    }
}
