package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.Reward;
import com.caogen.jfd.service.BaseService;

import java.util.List;

public interface RewardService extends BaseService<Reward> {

    List<Reward>getContent(String phone);
}
