package cn.bobdeng.todolist;

import cn.bobdeng.todolist.command.ConsolePrinter;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class DummyConsolePrinter implements ConsolePrinter {
    private List<String> lines = new ArrayList<>();

    @Override
    public void printLn(String line) {
        lines.add(line+"\n");
    }

    @Override
    public void print(String line) {
        lines.add(line);
    }

    public void clear() {
        lines.clear();
    }
}
