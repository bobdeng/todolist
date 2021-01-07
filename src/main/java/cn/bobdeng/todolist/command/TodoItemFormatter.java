package cn.bobdeng.todolist.command;

import cn.bobdeng.todolist.domain.todo.ItemStatus;
import cn.bobdeng.todolist.domain.todo.TodoItem;

public class TodoItemFormatter {
    private TodoItem item;

    public TodoItemFormatter(TodoItem item) {
        this.item = item;
    }

    public String format() {
        if (item.isDoing()) {
            return String.format("%d. %s", item.getIndex(), item.getItem());
        }
        return String.format("%d. [Done] %s", item.getIndex(), item.getItem());
    }
}
