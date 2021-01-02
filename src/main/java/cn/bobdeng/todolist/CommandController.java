package cn.bobdeng.todolist;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommandController implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        if(args.length>0) {
            log.info(args[0]);
        }

    }
}
