package cn.bobdeng.todolist;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("ac")
public class DummyConsoleReader implements ConsoleReader {
    private List<String> buffer;

    public void setBuffer(List<String> buffer) {
        this.buffer = new ArrayList<>(buffer);
    }

    @Override
    public String readLine() {
        return buffer.remove(0);
    }
}
