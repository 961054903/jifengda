package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.DriverSite;
import com.caogen.jfd.service.BaseService;

public interface DriverSiteService extends BaseService<DriverSite> {
    /**
     * 经纬度
     * @return
     */
    void getWhole(String phone,Double longitude,Double latitude);
}
