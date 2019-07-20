package com.caogen.jfd.service.user;

import java.util.List;

import com.caogen.jfd.entity.user.VehicleModel;
import com.caogen.jfd.service.BaseService;

/**
 * 
 * @author Spuiln
 *
 */
public interface VehicleModelService extends BaseService<VehicleModel> {
	/**
	 * 查询全部
	 * 
	 * @return
	 */
	List<VehicleModel> getAll();

}
