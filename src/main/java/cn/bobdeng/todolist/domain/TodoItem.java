package cn.bobdeng.todolist.domain;

import lombok.Data;

@Data
public class TodoItem {
    private int id;
    private String item;
    private ItemStatus status;

    public TodoItem(int id, String item) {
        this.id = id;
        this.item = item;
        this.status = ItemStatus.DOING;
    }

    public TodoItem(int id, String item, ItemStatus status) {
        this.id = id;
        this.item = item;
        this.status = status;
    }

    @Override
    public String toString() {
        if (status == ItemStatus.DONE) {
            return String.format("%d. [Done] %s", this.id, this.item);
        }
        return String.format("%d. %s", this.id, this.item);
    }

    public TodoItem complete() {
        return new TodoItem(id, item, ItemStatus.DONE);
    }

    public boolean isComplete() {
        return this.status == ItemStatus.DONE;
    }

    public boolean isDoing() {
        return this.status == ItemStatus.DOING;
    }
}
