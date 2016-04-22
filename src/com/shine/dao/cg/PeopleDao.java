package com.shine.dao.cg;

import com.shine.dao.BaseDao;
import com.shine.core.utils.page.Page;
import com.shine.entity.cg.People;

public interface PeopleDao {

    public Page<People> searchPeoples();

    public void updatePeople(People people);

    public void addPeople(People people);

    public People findPeopleById(Integer id);
}