package cn.bobdeng.todolist;

import cn.bobdeng.todolist.domain.TodoItem;
import cn.bobdeng.todolist.domain.TodoListRepositoryFlatFileImpl;
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

    @Before
    public void setup() {
        dummyConsolePrinter.clear();
        todoListRepositoryFlatFile.clear();
    }

    @Test
    public void Given列表为空_When添加新列表_Then列表有一条() throws Exception {
        commandController.run(new String[]{"add", "item1"});
        assertThat(todoListRepositoryFlatFile.all(), snapshotMatch(this, "new_item_result"));
        assertThat(dummyConsolePrinter.getLines(), snapshotMatch(this, "print_out"));
    }

    @Test
    public void Given有一条记录_When新增一条_Then有两条() {
        todoListRepositoryFlatFile.insert(new TodoItem(1, "item1"));
        commandController.run(new String[]{"add", "item2"});
        assertThat(todoListRepositoryFlatFile.all(), snapshotMatch(this, "new_item2_result"));
        assertThat(dummyConsolePrinter.getLines(), snapshotMatch(this, "print2_out"));
    }

    @Test
    public void Given有一条记录_When设置为完成_Then代办设置为完成() {
        todoListRepositoryFlatFile.insert(new TodoItem(1, "item1"));
        commandController.run(new String[]{"done", "1"});
        assertThat(todoListRepositoryFlatFile.all(), snapshotMatch(this, "done_result"));
        assertThat(dummyConsolePrinter.getLines(), snapshotMatch(this, "done_print_out"));
    }
}
