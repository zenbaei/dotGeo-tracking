package com.esrinea.dotGeo.tracking.service.component.sensorConfiguration;

import java.util.List;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.dao.SensorConfigurationDAO;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;
import com.esrinea.dotGeo.tracking.service.common.service.AbstractService;

public class SensorConfigurationServiceImpl extends AbstractService<SensorConfiguration> implements
		SensorConfigurationService {

	private SensorConfigurationDAO sensorConfigurationDAO;
	
	
	public SensorConfigurationServiceImpl(SensorConfigurationDAO sensorConfigurationDAO) {
		super(sensorConfigurationDAO);
		this.sensorConfigurationDAO = sensorConfigurationDAO;
	}

	private static Logger LOG = Logger
			.getLogger(SensorConfigurationServiceImpl.class);

	@Override
	public boolean isBusinessRuleSatisfied(
			SensorConfiguration sensorConfiguration, double receivedSensorValue) {

		if (!commonCheck(sensorConfiguration, receivedSensorValue)) {
			return false;
		}

		if (sensorConfiguration.getConfigText() == null
				|| sensorConfiguration.getConfigText().trim().isEmpty()) {
			LOG.warn("ConfigText is empty");
			return false;
		}

		if (sensorConfiguration.getMinValue() < receivedSensorValue
				&& receivedSensorValue < sensorConfiguration.getMaxValue()) {
			return true;
		}

		LOG.debug("Please check Business Rule logic as non of the checks were satisfied.");
		return false;
	}

	@Override
	public boolean isBusinessRuleSatisfied(
			SensorConfiguration sensorConfiguration, String receivedSensorValue) {

		if (!commonCheck(sensorConfiguration, receivedSensorValue)) {
			return false;
		}

		if (receivedSensorValue == null || receivedSensorValue.trim().isEmpty()) {
			LOG.warn("receivedValue is Null");
			return false;
		}

		if (sensorConfiguration.getTextValue() == null
				|| sensorConfiguration.getTextValue().trim().isEmpty()) {
			LOG.warn("TextValue is empty");
			return false;
		}

		if (sensorConfiguration.getTextValue().trim()
				.equalsIgnoreCase(receivedSensorValue.trim())) {
			return true;
		}

		LOG.debug("Please check Business Rule logic as non of the checks were satisfied.");
		return false;
	}

	@Override
	public boolean isBusinessRuleSatisfiedDelegate(SensorConfiguration sensorConfiguration, Object receivedSensorValue) {
		String val = String.valueOf(receivedSensorValue);
		try{
			Double d =  Double.valueOf(val);
			return isBusinessRuleSatisfied(sensorConfiguration, d);
		}catch(NumberFormatException | ClassCastException ex){
			return isBusinessRuleSatisfied(sensorConfiguration, val);
		}
	}
	
	// Common check done on overloaded isBusinessRuleSatisfied() method
	private boolean commonCheck(SensorConfiguration sensorConfiguration,
			Object receivedSensorValue) {

		LOG.debug("Apply Business Rule:\nSensor Configuration: " + sensorConfiguration
				+ "\nReceived Sensor Value: " + receivedSensorValue);

		if (sensorConfiguration == null) {
			LOG.warn("SensorConfiguration is Null");
			return false;
		}

		if (sensorConfiguration.isRetired()) {
			LOG.debug("Retired Sensor Configuration");
			return false;
		}

		return true;
	}
	
	@Override
	public List<SensorConfiguration> find(int sensorId, boolean retired) {
		return sensorConfigurationDAO.find(sensorId, retired);
	}

}
