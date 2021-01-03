package cn.bobdeng.todolist;

import cn.bobdeng.todolist.command.CommandController;
import cn.bobdeng.todolist.domain.user.User;
import cn.bobdeng.todolist.domain.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static cn.bobdeng.testtools.SnapshotMatcher.snapshotMatch;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "ac")
@SpringBootTest()
public class LoginTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DummyConsoleReader dummyConsoleReader;
    @Autowired
    DummyConsolePrinter consolePrinter;
    @Autowired
    CommandController commandController;
    @Autowired
    Session session;

    @Before
    public void setup() {
        dummyConsoleReader.setBuffer(Arrays.asList("123456"));
        session.logout();
        consolePrinter.clear();
    }

    @Test
    public void Given用户密码正确_When登录_Then登录成功() {
        userRepository.insert(new User("user1", "123456"));
        commandController.run("login", "-u", "user1");
        assertThat(session.currentUser(), is("user1"));
        assertThat(consolePrinter.getLines(), snapshotMatch(this, "login_success"));
    }

    @Test
    public void Given用户密码错误_When登录_Then登录失败() {
        userRepository.insert(new User("user1", "123455"));
        commandController.run("login", "-u", "user1");
        assertThat(session.currentUser(), nullValue());
        assertThat(consolePrinter.getLines(), snapshotMatch(this, "login_fail"));
    }

    @Test
    public void Given已经登录_When登出_Then当前用户为空() {
        session.loginWith("user1");
        commandController.run("logout");
        assertThat(session.currentUser(), nullValue());
        assertThat(consolePrinter.getLines(), snapshotMatch(this, "logout"));
    }
}
