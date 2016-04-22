package com.shine.view.service.cg.impl;

import com.shine.entity.cg.Address;
import com.shine.view.service.cg.AddressService;
import com.shine.core.utils.page.Page;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import com.shine.dao.cg.AddressDao;


@Service
public class AddressServiceImpl  implements AddressService{
    private static Logger logger = Logger.getLogger(AddressServiceImpl.class);

    private AddressDao addressDao;

    public Address findAddressById(Integer id){ 
        Address address=addressDao.findAddressById(id);
        return address;
    }

    public Page<Address> searchAddresss(){ 
        Page<Address> addresss = addressDao.searchAddresss();
        return addresss;
    }

    public void addAddress(Address address){ 
        addressDao.addAddress(address);
    }

    public void updateAddress(Address address){ 
        addressDao.updateAddress(address);
    }
}