package com.shine.view.cg;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shine.core.utils.page.Page;
import com.shine.core.exception.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shine.view.service.cg.PeopleService;
import com.shine.entity.cg.People;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@RequestMapping("/resources/code/people")
public class PeopleController {
    private static Logger logger = Logger.getLogger(PeopleController.class);

    @Autowired
    private PeopleService peopleService;

    @RequestMapping(method=RequestMethod.POST)
    public ResponseResult addPeople(People people){ 
        peopleService.addPeople(people);
        return ResponseResult.createSuccess(people);
    }

    @RequestMapping(value="search",method=RequestMethod.GET)
    public ResponseResult searchPeoples(){ 
        Page<People> peoples = peopleService.searchPeoples();
        return ResponseResult.createSuccess(peoples);
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseResult findPeopleById(Integer id){ 
        People people=peopleService.findPeopleById(id);
        return ResponseResult.createSuccess(people);
    }

    @RequestMapping(method=RequestMethod.PUT)
    public ResponseResult updatePeople(People people){ 
        peopleService.updatePeople(people);
        return ResponseResult.createSuccess(people);
    }
}