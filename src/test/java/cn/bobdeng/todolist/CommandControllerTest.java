package cn.bobdeng.todolist;

import cn.bobdeng.todolist.domain.TodoListRepositoryFlatFileImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void setup() {
        dummyConsolePrinter.clear();
    }

    @Test
    public void Given列表为空_When添加新列表_Then列表有一条() throws Exception {
        commandController.run(new String[]{"add item1"});
        assertThat(todoListRepositoryFlatFile.all(), snapshotMatch(this, "new_item_result"));
    }
}
