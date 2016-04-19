package com.shine.view.service.cg;

import com.shine.core.utils.page.Page;
import com.shine.view.service.BaseService;
import com.shine.entity.cg.People;

public interface PeopleService {

    public void addPeople(People people);

    public People findPeopleById(Integer id);

    public void updatePeople(People people);

    public Page<People> searchPeoples();
}