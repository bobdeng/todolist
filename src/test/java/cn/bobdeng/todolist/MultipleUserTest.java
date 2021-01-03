package cn.bobdeng.todolist;

import cn.bobdeng.todolist.domain.todo.TodoListRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static cn.bobdeng.testtools.SnapshotMatcher.snapshotMatch;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "ac")
@SpringBootTest()
public class MultipleUserTest {
    @Autowired
    CommandController commandController;
    @Autowired
    DummyConsolePrinter dummyConsolePrinter;
    @Autowired
    TodoListRepository todoListRepository;
    @Autowired
    Session session;
    @Before
    public void setup() {
        session.loginWith("user1");
        todoListRepository.clear();
        session.loginWith("user2");
        todoListRepository.clear();
        dummyConsolePrinter.clear();
    }
    @Test
    public void Given空的列表_When以用户1增加选项_Then切换到用户2读不到() {
        session.loginWith("user1");
        commandController.run("add", "待办事项1");
        assertThat(dummyConsolePrinter.getLines(), snapshotMatch(this, "new_item_user1"));
        dummyConsolePrinter.clear();
        session.loginWith("user2");
        commandController.run("list", "--all");
        assertThat(dummyConsolePrinter.getLines(), snapshotMatch(this, "list_items_user2"));
    }
}
