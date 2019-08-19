package com.caogen.jfd.dao.driver;

import java.util.List;

import com.caogen.jfd.entity.Complete;

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

    List<Complete> get8(Integer user_id);
}
