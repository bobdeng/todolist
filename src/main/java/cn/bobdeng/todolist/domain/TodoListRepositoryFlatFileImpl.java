package cn.bobdeng.todolist.domain;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TodoListRepositoryFlatFileImpl implements TodoListRepository {
    @Override
    public TodoItem save(TodoItem todoItem) {
        try {
            List<TodoItem> allItems = all();
            int newId = allItems.stream()
                    .mapToInt(TodoItem::getId)
                    .max().orElse(0) + 1;
            File file = getFile();
            FileOutputStream outputStream = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(outputStream);
            TodoItem newTodoItem = new TodoItem(newId, todoItem.getItem());
            Stream.concat(allItems.stream(), Stream.of(newTodoItem))
                    .map(item -> new Gson().toJson(item))
                    .forEach(printStream::println);
            return newTodoItem;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todoItem;
    }

    private File getFile() throws IOException {
        File file = new File("items.txt");
        if (!file.exists()) {
            boolean newFileSuccess = file.createNewFile();
            assert newFileSuccess;
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

    @Override
    public void clear() {
        try {
            boolean delete = getFile().delete();
            assert delete;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
