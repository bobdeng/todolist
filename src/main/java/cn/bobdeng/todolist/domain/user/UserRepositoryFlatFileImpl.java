package cn.bobdeng.todolist.domain.user;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserRepositoryFlatFileImpl implements UserRepository {
    @Override
    public void insert(User newUser) {
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(getFile()));
            Stream.concat(all().stream(), Stream.of(newUser))
                    .map(user -> new Gson().toJson(user))
                    .forEach(printStream::println);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private File getFile() throws IOException {
        File file = new File(".todo_config");
        if (!file.exists()) {
            boolean newFileSuccess = file.createNewFile();
            assert newFileSuccess;
        }
        return file;
    }

    @Override
    public List<User> all() {
        try {
            return new BufferedReader(new InputStreamReader(new FileInputStream(getFile())))
                    .lines()
                    .map(json -> new Gson().fromJson(json, User.class))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
