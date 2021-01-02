package cn.bobdeng.todolist.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static cn.bobdeng.testtools.SnapshotMatcher.snapshotMatch;
import static org.hamcrest.MatcherAssert.assertThat;

class TodoListServiceTest {
    private TodoListService todoListService;
    private TodoListRepositoryImpl todoListRepository;

    @BeforeEach
    public void setup() {
        todoListRepository = new TodoListRepositoryImpl();
        todoListService = new TodoListService(todoListRepository);
    }

    @Test
    void Given列表为空_When新增代办_Then有一个待办事项保存() {
        todoListService.newItem("item1");
        assertThat(todoListRepository.getItems(), snapshotMatch(this, "new_item_result"));
    }
}
