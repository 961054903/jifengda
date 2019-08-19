package com.caogen.jfd.service;

import com.caogen.jfd.entity.DriverSite;

public interface DriverSiteService extends BaseService<DriverSite> {
    /**
     * 经纬度
     * @return
     */
    void getWhole(Integer driver_id,Double longitude,Double latitude);
}
