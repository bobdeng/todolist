package cn.bobdeng.todolist;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("release")
public class ConsolePrinterImpl implements ConsolePrinter {
    @Override
    public void printLn(String line) {
        System.out.println(line);
    }
}
