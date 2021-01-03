package cn.bobdeng.todolist.command.actions;

public interface Action {
    void execute(String[] args);
    String actionName();
}
