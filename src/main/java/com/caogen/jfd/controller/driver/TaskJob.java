package com.caogen.jfd.controller.driver;
import com.caogen.jfd.service.driver.PeservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class TaskJob {
    @Autowired
    private PeservationService peservationService;
    public void job1() {
        peservationService.getput();
    }
}
