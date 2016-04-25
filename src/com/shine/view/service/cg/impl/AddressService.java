package com.shine.view.service.cg.impl;

import com.shine.core.exception.ServiceException;
import com.shine.core.utils.common.CommonUtils;
import org.springframework.stereotype.Service;
import com.shine.core.utils.page.Page;
import org.apache.log4j.Logger;
import com.shine.dao.cg.AddressDao;
import com.shine.entity.cg.Address;
//TODO import com.shine.model.condition.addressCondition;
import com.shine.view.service.cg.BaseService;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AddressServiceImpl  implements BaseService{
    private static Logger logger = Logger.getLogger(AddressServiceImpl.class);

    @Autowired
    private AddressDao  addressDao;

    public void add(Address  address){ 
        validate( address);
         addressDao.add(address);
    }

    public Address  findById(Integer id){ 
        validateId(id);
         address= addressDao.findById(id);
        return address;
    }

    public void update( Address address){ 
        validateId(1);//TODO
        validate(address);
        try {
             addressDao.update( address);
        } catch (Exception e) {
            CommonUtils.printStackTraceInfo(logger, e);
            throw ServiceException.create("ADDRESS.UPDATE.FAIL");
        }
    }

    public Page<Address> searchAddresss(/*TODO AddressCondition addressCondition */){ 
        Page<Address>  addresss =  addressDao.searchs(addressCondition);
        return  addresss;
    }

    private void validate(Address  address) {
        if ( address == null) {
            throw ServiceException.create("ADDRESS.IS.NULL");
        }
    }

    private void validateId(Integer id) {
        if (id == null) {
            throw ServiceException.create("ADDRESS.ID.IS.NULL");
        }
    }

    public void apply() {
         addressDao.apply();
    }
}