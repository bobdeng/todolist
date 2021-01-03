package cn.bobdeng.todolist.beanconfig;

import cn.bobdeng.todolist.domain.todo.TodoListRepository;
import cn.bobdeng.todolist.domain.todo.TodoListService;
import cn.bobdeng.todolist.domain.user.UserRepository;
import cn.bobdeng.todolist.domain.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoListConfig {
    @Bean
    TodoListService todoListService(TodoListRepository todoListRepository){
        return new TodoListService(todoListRepository);
    }
    @Bean
    UserService userService(UserRepository userRepository){
        return new UserService(userRepository);
    }
}
