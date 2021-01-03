package cn.bobdeng.todolist.domain.user;

import cn.bobdeng.dummydao.IdGenerator;

import java.util.List;

public class AssignedId implements IdGenerator {
    @Override
    public Object next(List list) {
        return null;
    }

    @Override
    public boolean hasId(Object o) {
        return o!=null;
    }
}
