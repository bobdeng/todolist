package cn.bobdeng.todolist.domain;

import cn.bobdeng.todolist.CurrentUser;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TodoListRepositoryFlatFileImpl implements TodoListRepository {
    @Override
    public TodoItem insert(TodoItem todoItem) {
        try {
            Stream<TodoItem> allItemsStream = Stream.concat(all().stream(), Stream.of(todoItem));
            saveAll(allItemsStream);
            return todoItem;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void saveAll(Stream<TodoItem> allItemsStream) throws IOException {
        File file = getFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        PrintStream printStream = new PrintStream(outputStream);
        allItemsStream
                .map(item -> new Gson().toJson(item))
                .forEach(printStream::println);
    }

    private File getFile() throws IOException {
        File file = new File("items-" + CurrentUser.user + ".txt");
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
            throw new RuntimeException(e);
        }

    }

    @Override
    public void clear() {
        try {
            boolean delete = getFile().delete();
            assert delete;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(TodoItem todoItem) {
        Stream<TodoItem> todoItemStream = all().stream()
                .map(item -> {
                    if (item.getIndex() == todoItem.getIndex()) {
                        return item.complete();
                    }
                    return item;
                });
        try {
            saveAll(todoItemStream);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
