package com.caogen.jfd.dao.driver;

import com.caogen.jfd.dao.user.BaseDao;
import com.caogen.jfd.entity.driver.Reward;

import java.util.List;

public interface RewardDao extends BaseDao<Reward> {


    Reward get1(Reward reward);

   List <Reward> find1(Reward reward);
}
