package com.esrinea.dotGeo.tracking.service.component.sensor;

import java.util.List;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.component.sensor.dao.SensorDAO;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;
import com.esrinea.dotGeo.tracking.service.common.service.AbstractService;

public class SensorServiceImpl extends AbstractService<Sensor> implements SensorService {

	private SensorDAO sensorDAO;
	private final static Logger LOG = Logger.getLogger(SensorServiceImpl.class);

	public SensorServiceImpl(SensorDAO sensorDAO) {
		super(sensorDAO);
		this.sensorDAO = sensorDAO;
	}

	@Override
	public List<Sensor> find(int deviceTypeId, boolean retired) {
		return sensorDAO.find(deviceTypeId, retired);
	}

	@Override
	public Sensor find(String sensorNameEn) {
		return sensorDAO.find(sensorNameEn);
	}
}
