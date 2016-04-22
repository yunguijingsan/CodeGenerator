package com.shine.view.service.cg;

import com.shine.entity.cg.Address;
import com.shine.core.utils.page.Page;
import com.shine.view.service.BaseService;

public interface AddressService {

    public Address findAddressById(Integer id);

    public Page<Address> searchAddresss();

    public void addAddress(Address address);

    public void updateAddress(Address address);
}