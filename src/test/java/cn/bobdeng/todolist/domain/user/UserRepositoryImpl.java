package cn.bobdeng.todolist.domain.user;

import cn.bobdeng.dummydao.DummyDao;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final DummyDao<User,String> dummyDao;

    public UserRepositoryImpl(DummyDao<User, String> dummyDao) {
        this.dummyDao = dummyDao;
    }

    @Override
    public List<User> all() {
        return dummyDao.all();
    }
}
