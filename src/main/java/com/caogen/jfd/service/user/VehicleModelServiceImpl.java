package com.caogen.jfd.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.VehicleModelDao;
import com.caogen.jfd.entity.user.VehicleModel;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class VehicleModelServiceImpl implements VehicleModelService {
	@Autowired
	private VehicleModelDao modelDao;

	@Override
	public void create(VehicleModel entity) {
		modelDao.insert(entity);
	}

	@Override
	public void remove(VehicleModel entity) {
		modelDao.delete(entity);
	}

	@Override
	public void modify(VehicleModel entity) {
		modelDao.update(entity);
	}

	@Override
	public VehicleModel getById(Integer id) {
		return modelDao.get(new VehicleModel(id));
	}

}
