package cn.bobdeng.todolist.domain;

import cn.bobdeng.dummydao.DummyDao;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TodoListRepositoryImpl implements TodoListRepository {
    final DummyDao<TodoItem,Integer> dummyDao;
    private List<TodoItem> items = new ArrayList<>();

    public TodoListRepositoryImpl(DummyDao<TodoItem, Integer> dummyDao) {
        this.dummyDao = dummyDao;
    }

    @Override
    public TodoItem insert(TodoItem todoItem) {
        return dummyDao.save(todoItem);
    }

    @Override
    public List<TodoItem> all() {
        return dummyDao.all();
    }

    @Override
    public void clear() {
    }

    @Override
    public void update(TodoItem todoItem) {
        dummyDao.save(todoItem);
    }
}
