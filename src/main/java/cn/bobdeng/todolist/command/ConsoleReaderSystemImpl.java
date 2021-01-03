package cn.bobdeng.todolist.command;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("release")
public class ConsoleReaderSystemImpl implements ConsoleReader {

    @Override
    public String readPassword() {
        return String.valueOf(System.console().readPassword());
    }
}
