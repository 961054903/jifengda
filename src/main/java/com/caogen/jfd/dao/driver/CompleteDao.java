package com.caogen.jfd.dao.driver;

import com.caogen.jfd.dao.user.BaseDao;
import com.caogen.jfd.entity.driver.Complete;


import java.util.List;

public interface CompleteDao extends BaseDao<Complete> {
    /**
     * 今天订单
     * @param
     * @return
     */
    List<Complete> find1(Complete complete);

    /**
     * 本月订单
     * @param
     * @return
     */
    List<Complete> find2(Complete complete);

    List<Complete> find3(Complete complete);

    List<Complete> find4();

    List<Complete>find5(Complete complete);
}
