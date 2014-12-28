package com.esrinea.dotGeo.tracking.service.component.sensorConfiguration;

import java.util.List;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.dao.SensorConfigurationDAO;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;
import com.esrinea.dotGeo.tracking.service.common.service.AbstractService;

public class SensorConfigurationServiceImpl extends AbstractService<SensorConfiguration> implements SensorConfigurationService {

	private SensorConfigurationDAO sensorConfigurationDAO;

	public SensorConfigurationServiceImpl(SensorConfigurationDAO sensorConfigurationDAO) {
		super(sensorConfigurationDAO);
		this.sensorConfigurationDAO = sensorConfigurationDAO;
	}

	private static Logger LOG = Logger.getLogger(SensorConfigurationServiceImpl.class);

	@Override
	public boolean isBusinessRuleSatisfied(SensorConfiguration sensorConfiguration, double receivedSensorValue) {

		if (!commonCheck(sensorConfiguration, receivedSensorValue)) {
			return false;
		}

		if (sensorConfiguration.getMinValue() <= receivedSensorValue && receivedSensorValue < sensorConfiguration.getMaxValue()) {
			LOG.debug(String.format("\n----------------------------------------------\nSENSOR %s HAS SUCCEEDED FOR SENSOR CONFIGURATION OF %s\n----------------------------------------------", sensorConfiguration.getSensor().getNameEn().toUpperCase() ,sensorConfiguration.getConfigText() == null ? "NO DESCRIPTION IN DB"
					: sensorConfiguration.getConfigText().toUpperCase()));
			return true;
		}

		LOG.debug(String.format("Sensor Configuration's %s Rule has failed.", sensorConfiguration.getConfigText()));
		return false;
	}

	@Override
	public boolean isBusinessRuleSatisfied(SensorConfiguration sensorConfiguration, String receivedSensorValue) {

		if (!commonCheck(sensorConfiguration, receivedSensorValue)) {
			return false;
		}

		if (receivedSensorValue == null || receivedSensorValue.trim().isEmpty()) {
			LOG.warn("receivedValue is Null");
			return false;
		}

		if (sensorConfiguration.getTextValue() == null || sensorConfiguration.getTextValue().trim().isEmpty()) {
			LOG.warn("TextValue is empty");
			return false;
		}

		if (sensorConfiguration.getTextValue().trim().equalsIgnoreCase(receivedSensorValue.trim())) {
			LOG.debug(String.format("\n----------------------------------------------\nSENSOR %s HAS SUCCEEDED FOR SENSOR CONFIGURATION OF %s\n----------------------------------------------", sensorConfiguration.getSensor().getNameEn().toUpperCase() ,sensorConfiguration.getConfigText() == null ? "NO DESCRIPTION IN DB"
					: sensorConfiguration.getConfigText().toUpperCase()));
			return true;
		}

		LOG.debug(String.format("Sensor Configuration's %s Rule has failed.", sensorConfiguration.getConfigText()));
		return false;
	}

	@Override
	public boolean isBusinessRuleSatisfiedDelegate(SensorConfiguration sensorConfiguration, Object receivedSensorValue) {
		String val = String.valueOf(receivedSensorValue);
		try {
			Double d = Double.valueOf(val);
			return isBusinessRuleSatisfied(sensorConfiguration, d);
		} catch (Exception ex) { //NumberFormatException | ClassCastException
			return isBusinessRuleSatisfied(sensorConfiguration, val);
		}
	}

	// Common check done on overloaded isBusinessRuleSatisfied() method
	private boolean commonCheck(SensorConfiguration sensorConfiguration, Object receivedSensorValue) {

		if (sensorConfiguration == null) {
			LOG.warn("SensorConfiguration is Null.");
			return false;
		}

		if (sensorConfiguration.isRetired()) {
			LOG.debug("Retired Sensor Configuration.");
			return false;
		}

		LOG.debug(String.format("Check if received value (%s) falls under the rule configured on %s Sensor.", receivedSensorValue, sensorConfiguration.getSensor().getNameEn().toUpperCase()));
		LOG.debug(sensorConfiguration);

		return true;
	}

	@Override
	public List<SensorConfiguration> find(int sensorId, boolean retired) {
		return sensorConfigurationDAO.find(sensorId, retired);
	}

}
