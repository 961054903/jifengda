package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.Order;
import com.caogen.jfd.service.BaseService;

public interface OrderService extends BaseService<Order> {
    Order getorder(String phone);
}
