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

    @Override
    public String toString() {
        return String.format("%d. %s", this.id, this.item);
    }
}
