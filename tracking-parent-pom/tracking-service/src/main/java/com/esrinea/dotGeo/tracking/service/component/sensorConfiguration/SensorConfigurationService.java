package com.esrinea.dotGeo.tracking.service.component.sensorConfiguration;

import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;

public interface SensorConfigurationService {
	
	/**
	 * The sensor input received from the device's sensor might be a double in that case 
	 * sensor value will be validated against a sensor configuration.
	 * Rule: receivedValue is between minValue and maxValue 
	 * @param sensorConfiguration
	 * @param receivedValue
	 * @return
	 */
	boolean isBusinessRuleSatisfied(SensorConfiguration sensorConfiguration, double receivedValue);
	
	/**
	 * The sensor input received from the device's sensor might be a string in that case 
	 * sensor value will be validated against a sensor configuration.
	 * Rule: receivedValue equals to textValue 
	 * @param sensorConfiguration
	 * @param receivedValue
	 * @return
	 */
	boolean isBusinessRuleSatisfied(SensorConfiguration sensorConfiguration, String receivedValue);

}
