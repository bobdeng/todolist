package cn.bobdeng.todolist.actions;

import cn.bobdeng.todolist.ConsolePrinter;
import cn.bobdeng.todolist.ConsoleReader;
import cn.bobdeng.todolist.CurrentUser;
import cn.bobdeng.todolist.domain.user.UserService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class LoginAction implements Action {
    private final UserService userService;
    private final ConsoleReader consoleReader;
    private final ConsolePrinter consolePrinter;

    public LoginAction(UserService userService, ConsoleReader consoleReader, ConsolePrinter consolePrinter) {
        this.userService = userService;
        this.consoleReader = consoleReader;
        this.consolePrinter = consolePrinter;
    }

    @Override
    public void execute(String[] args) {
        consolePrinter.print("password:");
        try {
            String password = consoleReader.readLine();
            String user = args[2];
            if (userService.isLoginRight(user, password)) {
                CurrentUser.user = user;
                consolePrinter.printLn("Login success!");
                return;
            }
            consolePrinter.printLn("Login failed!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String actionName() {
        return "login";
    }
}
