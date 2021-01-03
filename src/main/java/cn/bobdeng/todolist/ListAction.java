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
            todoListFacade.printTail("Total " + count.getTotal() + " " + getItems(count.getTotal()) + ", " + count.getDone() + " " + getItems(count.getDone()) + " done");
            return;
        }
        todoListFacade.printAllDoing();
        CountByStatus count = todoListFacade.countByStatus();
        todoListFacade.printTail("Total " + count.getTotalDoing() + " " + getItems(count.getTotalDoing()));
    }

    private String getItems(int total) {
        if (total <= 1) {
            return "item";
        }
        return "items";
    }
}
