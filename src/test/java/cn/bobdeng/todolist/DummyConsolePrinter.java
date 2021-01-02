package cn.bobdeng.todolist;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("ac")
public class DummyConsolePrinter implements ConsolePrinter {
    private List<String> lines = new ArrayList<>();

    @Override
    public void printLn(String line) {
        lines.add(line);
    }

    public void clear() {
        lines.clear();
    }
}
