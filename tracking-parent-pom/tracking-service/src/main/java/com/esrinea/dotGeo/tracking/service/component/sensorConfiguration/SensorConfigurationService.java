package com.esrinea.dotGeo.tracking.service.component.sensorConfiguration;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;
import com.esrinea.dotGeo.tracking.service.common.service.GenericService;

public interface SensorConfigurationService extends GenericService<SensorConfiguration>{
	
	/**
	 * The sensor input received from the device's sensor might be a double in that case 
	 * sensor value will be validated against a sensor configuration.
	 * Rule: receivedValue is between minValue and maxValue 
	 * @param sensorConfiguration
	 * @param receivedValue
	 * @return
	 */
	boolean isBusinessRuleSatisfied(SensorConfiguration sensorConfiguration, double receivedSensorValue);
	
	/**
	 * The sensor input received from the device's sensor might be a string in that case 
	 * sensor value will be validated against a sensor configuration.
	 * Rule: receivedValue equals to textValue 
	 * @param sensorConfiguration
	 * @param receivedValue
	 * @return
	 */
	boolean isBusinessRuleSatisfied(SensorConfiguration sensorConfiguration, String receivedSensorValue);

	List<SensorConfiguration> find(int sensorId, boolean retired);
	
	/**
	 * This method will delegate the received sensor value to one of corresponding methods(double or string value)
	 * @param sensorConfiguration
	 * @param receivedSensorValue
	 * @return
	 */
	boolean isBusinessRuleSatisfiedDelegate(SensorConfiguration sensorConfiguration, Object receivedSensorValue);

}
