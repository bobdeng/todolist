package cn.bobdeng.todolist.command;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("release")
public class ConsolePrinterSystemImpl implements ConsolePrinter {
    @Override
    public void printLn(String line) {
        System.out.println(line);
    }

    @Override
    public void print(String todo) {
        System.out.print(todo);
    }
}
