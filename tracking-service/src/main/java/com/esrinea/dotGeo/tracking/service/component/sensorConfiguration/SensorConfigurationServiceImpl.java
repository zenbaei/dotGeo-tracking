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
			LOG.warn("ConfigText is empty for " + sensorConfiguration);
			return false;
		}

		if (receivedValue > sensorConfiguration.getMinValue()
				&& receivedValue < sensorConfiguration.getMaxValue()) {
			return true;
		}

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
			LOG.warn("TextValue is empty for " + sensorConfiguration);
			return false;
		}

		if (receivedValue.trim().equalsIgnoreCase(
				sensorConfiguration.getConfigText().trim())) {
			return true;
		}

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
			LOG.debug("Retired Sensor Configuration: " + sensorConfiguration);
			return false;
		}

		return false;
	}
}
