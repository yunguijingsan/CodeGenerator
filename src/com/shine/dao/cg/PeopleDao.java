package com.shine.dao.cg;

import com.shine.dao.BaseDao;
import com.shine.core.utils.page.Page;
import com.shine.entity.cg.People;

public interface PeopleDao {

    public void addPeople(People people);

    public People findPeopleById(Integer id);

    public void updatePeople(People people);

    public Page<People> searchPeoples();
}