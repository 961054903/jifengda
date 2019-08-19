package com.caogen.jfd.dao.driver;

import java.util.List;

import com.caogen.jfd.entity.Reward;

public interface RewardDao extends BaseDao<Reward> {


    Reward get1(Reward reward);

   List <Reward> find1(Reward reward);
}
