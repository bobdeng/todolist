package cn.bobdeng.todolist.domain.todo;

import lombok.Data;

@Data
public class TodoItem {
    private int index;
    private String item;
    private ItemStatus status;

    public TodoItem(int index, String item) {
        this.index = index;
        this.item = item;
        this.status = ItemStatus.DOING;
    }

    public TodoItem(int index, String item, ItemStatus status) {
        this.index = index;
        this.item = item;
        this.status = status;
    }

    public TodoItem complete() {
        return new TodoItem(index, item, ItemStatus.DONE);
    }

    public boolean isComplete() {
        return this.status == ItemStatus.DONE;
    }

    public boolean isDoing() {
        return this.status == ItemStatus.DOING;
    }

    public boolean isIndex(int index) {
        return this.index == index;
    }
}
