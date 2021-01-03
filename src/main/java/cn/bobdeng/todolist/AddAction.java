package cn.bobdeng.todolist;

import cn.bobdeng.todolist.domain.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class AddAction implements Action {
    private final TodoListFacade todoListFacade;

    public AddAction(TodoListFacade todoListFacade) {
        this.todoListFacade = todoListFacade;
    }

    @Override
    public void execute(String[] args) {
        TodoItem newItem = todoListFacade.newItem(args[1]);
        todoListFacade.printAll();
        todoListFacade.printTail("Item " + newItem.getId() + " added");
    }
}
