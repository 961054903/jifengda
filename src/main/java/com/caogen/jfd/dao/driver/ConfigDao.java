package com.caogen.jfd.dao.driver;

import com.caogen.jfd.dao.user.BaseDao;
import com.caogen.jfd.entity.driver.Config;

/**
 * 
 * @author Spuiln
 *
 */
public interface ConfigDao extends BaseDao<Config> {

    void insert(com.caogen.jfd.entity.driver.Config entity);
}
