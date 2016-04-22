package com.shine.dao.cg;

import com.shine.dao.BaseDao;
import com.shine.entity.cg.Address;
import com.shine.core.utils.page.Page;

public interface AddressDao {

    public void updateAddress(Address address);

    public void addAddress(Address address);

    public Address findAddressById(Integer id);

    public Page<Address> searchAddresss();
}