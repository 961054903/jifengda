package com.caogen.jfd.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.user.VehiclePriceDao;
import com.caogen.jfd.entity.user.VehiclePrice;

/**
 * 
 * @author Spuiln
 *
 */
@Service
public class VehiclePriceServiceImpl implements VehiclePriceService {
	@Autowired
	private VehiclePriceDao priceDao;

	@Override
	public void create(VehiclePrice entity) {
		priceDao.insert(entity);
	}

	@Override
	public void remove(VehiclePrice entity) {
		priceDao.delete(entity);
	}

	@Override
	public void modify(VehiclePrice entity) {
		priceDao.update(entity);
	}

	@Override
	public VehiclePrice getById(Integer id) {
		return priceDao.get(new VehiclePrice(id));
	}

}
