package cn.bobdeng.todolist.command.commands;

public interface Command {
    void execute(String[] args);
    String actionName();
}
