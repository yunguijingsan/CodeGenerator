package com.shine.view.service.cg.impl;

import com.shine.core.utils.page.Page;
import com.shine.dao.cg.PeopleDao;
import com.shine.view.service.BaseService;
import com.shine.entity.cg.People;
import com.shine.view.service.cg.PeopleService;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;


@Service
public class PeopleServiceImpl  implements BaseService,PeopleService{
    private static Logger logger = Logger.getLogger(PeopleServiceImpl.class);

    private PeopleDao peopleDao;

    public People findPeopleById(Integer id){ 
        People people=peopleDao.findPeopleById(id);
        return people;
    }

    public Page<People> searchPeoples(){ 
        Page<People> peoples = peopleDao.searchPeoples();
        return peoples;
    }

    public void updatePeople(People people){ 
        peopleDao.updatePeople(people);
    }

    public void addPeople(People people){ 
        peopleDao.addPeople(people);
    }
}