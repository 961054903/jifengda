package com.caogen.jfd.dao.driver;

import com.caogen.jfd.dao.user.BaseDao;
import com.caogen.jfd.entity.driver.price;

public interface PriceDao extends BaseDao<price> {
    price get1();
}
