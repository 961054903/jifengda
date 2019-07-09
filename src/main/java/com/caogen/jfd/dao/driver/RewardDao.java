package com.caogen.jfd.dao.driver;

import com.caogen.jfd.dao.BaseDao;
import com.caogen.jfd.entity.driver.Reward;

public interface RewardDao extends BaseDao<Reward> {


    Reward get1(Reward reward);
}
