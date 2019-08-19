package com.caogen.jfd.service;

import java.util.List;

import com.caogen.jfd.entity.Reward;

public interface RewardService extends BaseService<Reward> {

    List<Reward>getContent();
}
