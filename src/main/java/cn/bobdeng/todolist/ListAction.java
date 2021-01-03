package cn.bobdeng.todolist;

import cn.bobdeng.todolist.domain.CountByStatus;
import org.springframework.stereotype.Service;

@Service
public class ListAction implements Action {
    private final TodoListFacade todoListFacade;

    public ListAction(TodoListFacade todoListFacade) {
        this.todoListFacade = todoListFacade;
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 2) {
            todoListFacade.printAll();
            CountByStatus count = todoListFacade.countByStatus();
            todoListFacade.printTail(count.toStringOfAll());
            return;
        }
        todoListFacade.printAllDoing();
        CountByStatus count = todoListFacade.countByStatus();
        todoListFacade.printTail(count.toStringOfDoing());
    }


}
