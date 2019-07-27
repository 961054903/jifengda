package com.caogen.jfd.service;

import java.util.List;

import com.caogen.jfd.entity.VehicleModel;

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
