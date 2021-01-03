package cn.bobdeng.todolist.command.actions;

import cn.bobdeng.todolist.command.TodoListFacade;
import cn.bobdeng.todolist.domain.todo.CountByStatus;
import org.springframework.stereotype.Service;

@Service
public class ListAction implements Action, ActionNeedLogin {
    private final TodoListFacade todoListFacade;

    public ListAction(TodoListFacade todoListFacade) {
        this.todoListFacade = todoListFacade;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 2) {
            listAll();
            return;
        }
        listOnlyDoing();
    }

    @Override
    public String actionName() {
        return "list";
    }

    private void listOnlyDoing() {
        todoListFacade.printAllDoing();
        CountByStatus count = todoListFacade.countByStatus();
        todoListFacade.printTail(count.toStringOfDoing());
    }

    private void listAll() {
        todoListFacade.printAll();
        CountByStatus count = todoListFacade.countByStatus();
        todoListFacade.printTail(count.toStringOfAll());
    }


}
