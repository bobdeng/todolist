package cn.bobdeng.todolist.domain.user;

import cn.bobdeng.dummydao.DummyDao;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserServiceTest {
    UserService userService;
    DummyDao<User, String> dummyDao;

    @BeforeEach
    public void setup() {
        dummyDao = new DummyDao<>(User.class, "loginName", new AssignedId());
        userService = new UserService(new UserRepositoryImpl(dummyDao));

    }

    @Test
    void Given用户名密码正确_When登录_Then登录成功() {
        dummyDao.insert(new User("user1", "123456"));
        assertTrue(userService.isLoginRight("user1", "123456"));
    }

    @Test
    void Given用户为空_When登录_Then登录失败() {
        assertFalse(userService.isLoginRight("user1", "123456"));
    }

    @Test
    void Given有用户_When错误密码登录_Then登录失败() {
        dummyDao.insert(new User("user1", "123456"));
        assertFalse(userService.isLoginRight("user1", "123455"));
    }
}
