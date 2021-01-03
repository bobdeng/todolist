package cn.bobdeng.todolist.domain.user;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public boolean isLoginRight(String loginName, String password) {
        return userRepository.all().stream()
                .filter(user -> user.isLoginName(loginName))
                .anyMatch(user -> user.isPasswordRight(password));
    }
}
