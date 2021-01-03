package cn.bobdeng.todolist.domain;

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
        return total-totalDone;
    }
}
