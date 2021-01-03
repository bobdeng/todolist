package cn.bobdeng.todolist.beanconfig;

import cn.bobdeng.todolist.domain.todo.TodoListRepository;
import cn.bobdeng.todolist.domain.todo.TodoListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoListConfig {
    @Bean
    TodoListService todoListService(TodoListRepository todoListRepository){
        return new TodoListService(todoListRepository);
    }
}
