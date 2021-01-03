package cn.bobdeng.todolist;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@Profile("release")
public class ConsoleReaderImpl implements ConsoleReader {
    @Override
    public String readLine() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}
