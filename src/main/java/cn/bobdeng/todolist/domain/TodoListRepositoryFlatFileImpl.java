package cn.bobdeng.todolist.domain;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoListRepositoryFlatFileImpl implements TodoListRepository {
    @Override
    public TodoItem save(TodoItem todoItem) {
        try {
            File file = getFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(outputStream);
            printStream.println(new Gson().toJson(todoItem));
            return todoItem;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todoItem;
    }

    private File getFile() throws IOException {
        File file = new File("items.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    @Override
    public List<TodoItem> all() {
        try {
            File file = getFile();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            return reader.lines()
                    .map(json -> new Gson().fromJson(json, TodoItem.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
