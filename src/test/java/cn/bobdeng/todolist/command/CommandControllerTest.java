package cn.bobdeng.todolist.command;

import cn.bobdeng.todolist.DummyConsolePrinter;
import cn.bobdeng.todolist.Session;
import cn.bobdeng.todolist.command.CommandController;
import cn.bobdeng.todolist.domain.todo.ItemStatus;
import cn.bobdeng.todolist.domain.todo.TodoItem;
import cn.bobdeng.todolist.domain.todo.TodoListRepositoryFlatFileImpl;
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
public class CommandControllerTest {
    @Autowired
    CommandController commandController;
    @Autowired
    DummyConsolePrinter dummyConsolePrinter;
    @Autowired
    TodoListRepositoryFlatFileImpl todoListRepositoryFlatFile;
    @Autowired
    Session session;
    @Before
    public void setup() {
        dummyConsolePrinter.clear();
        session.loginWith("user1");
        todoListRepositoryFlatFile.clear();
    }

    @Test
    public void Given列表为空_When添加新列表_Then列表有一条() {
        commandController.run("add", "item1");
        assertThat(todoListRepositoryFlatFile.all(), snapshotMatch(this, "new_item_result"));
        assertThat(dummyConsolePrinter.getLines(), snapshotMatch(this, "print_out"));
    }

    @Test
    public void Given有一条记录_When新增一条_Then有两条() {
        todoListRepositoryFlatFile.insert(new TodoItem(1, "item1"));
        commandController.run("add", "item2");
        assertThat(todoListRepositoryFlatFile.all(), snapshotMatch(this, "new_item2_result"));
        assertThat(dummyConsolePrinter.getLines(), snapshotMatch(this, "print2_out"));
    }

    @Test
    public void Given有一条记录_When设置为完成_Then代办设置为完成() {
        todoListRepositoryFlatFile.insert(new TodoItem(1, "item1"));
        commandController.run("done", "1");
        assertThat(todoListRepositoryFlatFile.all(), snapshotMatch(this, "done_result"));
        assertThat(dummyConsolePrinter.getLines(), snapshotMatch(this, "done_print_out"));
    }

    @Test
    public void Given有一条正在进行的代办_When列出指令_Then列出所有代办() {
        todoListRepositoryFlatFile.insert(new TodoItem(1, "item1"));
        commandController.run("list");
        assertThat(dummyConsolePrinter.getLines(), snapshotMatch(this, "list"));
    }

    @Test
    public void Given有两条其中一条已完成_When列出_Then仅列出未完成() {
        todoListRepositoryFlatFile.insert(new TodoItem(1, "item1"));
        todoListRepositoryFlatFile.insert(new TodoItem(2, "item2", ItemStatus.DONE));
        commandController.run("list");
        assertThat(dummyConsolePrinter.getLines(), snapshotMatch(this, "list_doing"));
    }

    @Test
    public void Given有两条其中一条已完成_When列出所有_Then列出所有() {
        todoListRepositoryFlatFile.insert(new TodoItem(1, "item1"));
        todoListRepositoryFlatFile.insert(new TodoItem(2, "item2", ItemStatus.DONE));
        commandController.run("list", "--all");
        assertThat(dummyConsolePrinter.getLines(), snapshotMatch(this, "list_all"));
    }

    @Test
    public void Given没有登录_When执行List_Then返回请登录() {
        session.logout();
        commandController.run("list", "--all");
        assertThat(dummyConsolePrinter.getLines(), snapshotMatch(this, "not_login"));
    }

    @Test
    public void When执行不支持的命令_Then返回命令错误() {
        commandController.run("not_support");
        assertThat(dummyConsolePrinter.getLines(), snapshotMatch(this, "not_support"));
    }
}
