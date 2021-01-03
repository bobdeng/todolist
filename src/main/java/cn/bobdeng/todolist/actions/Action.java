package cn.bobdeng.todolist.actions;

public interface Action {
    void execute(String[] args);
    String actionName();
}
