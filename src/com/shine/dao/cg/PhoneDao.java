package com.shine.dao.cg;

import com.shine.dao.BaseDao;
import com.shine.core.utils.page.Page;
import com.shine.entity.cg.Phone;

public interface PhoneDao {

    public Phone findPhoneById(Integer id);

    public void updatePhone(Phone phone);

    public void addPhone(Phone phone);

    public Page<Phone> searchPhones();
}