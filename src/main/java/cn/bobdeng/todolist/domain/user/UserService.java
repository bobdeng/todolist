package cn.bobdeng.todolist.domain.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public boolean isLoginRight(String loginName, String password) {
        return userRepository.all().stream()
                .filter(user -> user.isLoginName(loginName))
                .anyMatch(user -> user.isPasswordRight(password));
    }
}
