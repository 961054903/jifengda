package com.caogen.jfd.dao.driver;

import com.caogen.jfd.entity.Config;

/**
 * 
 * @author Spuiln
 *
 */
public interface ConfigDao extends BaseDao<Config> {

    void insert(com.caogen.jfd.entity.Config entity);
}
