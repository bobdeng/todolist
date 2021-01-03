package cn.bobdeng.todolist.domain;

import cn.bobdeng.dummydao.AutoIntegerIdGenerator;
import cn.bobdeng.dummydao.DummyDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static cn.bobdeng.testtools.SnapshotMatcher.snapshotMatch;
import static org.hamcrest.MatcherAssert.assertThat;

class TodoListServiceTest {
    private TodoListService todoListService;
    private TodoListRepositoryImpl todoListRepository;
    private DummyDao<TodoItem, Integer> dummyDao;

    @BeforeEach
    public void setup() {
        dummyDao = new DummyDao<>(TodoItem.class, "id", new AutoIntegerIdGenerator());
        todoListRepository = new TodoListRepositoryImpl(dummyDao);
        todoListService = new TodoListService(todoListRepository);
    }

    @Test
    void Given列表为空_When新增代办_Then有一个待办事项保存() {
        todoListService.newItem("item1");
        assertThat(dummyDao.all(), snapshotMatch(this, "new_item_result"));
    }

    @Test
    public void Given有一个代办_When设置代办为完成_Then代办状态变为完成() {
        todoListRepository.insert(new TodoItem(1, "item1"));
        todoListService.complete(1);
        assertThat(dummyDao.all(), snapshotMatch(this, "complete_result"));
    }
}
