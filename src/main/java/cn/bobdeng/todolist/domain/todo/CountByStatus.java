package cn.bobdeng.todolist.domain.todo;

import lombok.Getter;

@Getter
public class CountByStatus {
    private int total;
    private int totalDone;

    public CountByStatus(int total, int totalDone) {
        this.total = total;
        this.totalDone = totalDone;
    }

    public int getDone() {
        return totalDone;
    }

    public int getTotalDoing() {
        return total - totalDone;
    }

    public String toStringOfAll() {
        return "Total " + this.getTotal() + " " + getItems(this.getTotal()) + ", " + this.getDone() + " " + getItems(this.getDone()) + " done";
    }

    private String getItems(int total) {
        if (total <= 1) {
            return "item";
        }
        return "items";
    }

    public String toStringOfDoing() {
        return "Total " + this.getTotalDoing() + " " + getItems(this.getTotalDoing());
    }
}
