package com.shine.view.service.cg;

import com.shine.core.utils.page.Page;
import com.shine.view.service.BaseService;
import com.shine.entity.cg.Address;
//TODO import com.shine.model.condition.addressCondition;

public interface AddressService extends BaseService{

    public void addAddress(Address address);

    public Address findAddressById(Integer id);

    public void updateAddress(Address address);

    public Page<Address> searchAddresss(/*TODO AddressCondition addressCondition */);
}