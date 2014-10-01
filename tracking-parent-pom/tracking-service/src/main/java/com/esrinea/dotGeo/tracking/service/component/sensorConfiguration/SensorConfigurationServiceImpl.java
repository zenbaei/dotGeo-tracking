package com.esrinea.dotGeo.tracking.service.component.sensorConfiguration;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;

public class SensorConfigurationServiceImpl implements
		SensorConfigurationService {

	private static Logger LOG = Logger
			.getLogger(SensorConfigurationServiceImpl.class);

	@Override
	public boolean isBusinessRuleSatisfied(
			SensorConfiguration sensorConfiguration, double receivedValue) {

		if (!commonCheck(sensorConfiguration, receivedValue)) {
			return false;
		}

		if (sensorConfiguration.getConfigText() == null
				|| sensorConfiguration.getConfigText().trim().isEmpty()) {
			LOG.warn("ConfigText is empty");
			return false;
		}

		if (sensorConfiguration.getMinValue() < receivedValue
				&& receivedValue < sensorConfiguration.getMaxValue()) {
			return true;
		}

		LOG.debug("Please check Business Rule logic as non of the checks were satisfied");
		return false;
	}

	@Override
	public boolean isBusinessRuleSatisfied(
			SensorConfiguration sensorConfiguration, String receivedValue) {

		if (!commonCheck(sensorConfiguration, receivedValue)) {
			return false;
		}

		if (receivedValue == null || receivedValue.trim().isEmpty()) {
			LOG.warn("receivedValue is Null");
			return false;
		}

		if (sensorConfiguration.getTextValue() == null
				|| sensorConfiguration.getTextValue().trim().isEmpty()) {
			LOG.warn("TextValue is empty");
			return false;
		}

		if (sensorConfiguration.getTextValue().trim()
				.equalsIgnoreCase(receivedValue.trim())) {
			return true;
		}

		LOG.debug("Please check Business Rule logic as non of the checks were satisfied");
		return false;
	}

	// Common check done on overloaded isBusinessRuleSatisfied() method
	private boolean commonCheck(SensorConfiguration sensorConfiguration,
			Object receivedValue) {

		LOG.debug("applyBusinessRule:parameter1:" + sensorConfiguration
				+ " parameter2:" + receivedValue);

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

}
