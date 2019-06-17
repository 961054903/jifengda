package com.caogen.jfd.service.driver;


import com.caogen.jfd.entity.driver.Peservation;
import com.caogen.jfd.service.BaseService;

import java.util.List;

public interface PeservationService extends BaseService<Peservation> {
   List<Peservation> getmake(String phone, Peservation.Mode mode);
}
