package com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity;

import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity.AlertConfiguration;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-12T14:50:47.506+0200")
@StaticMetamodel(SensorConfiguration.class)
public class SensorConfiguration_ {
	public static volatile SingularAttribute<SensorConfiguration, Integer> id;
	public static volatile SingularAttribute<SensorConfiguration, String> configText;
	public static volatile SingularAttribute<SensorConfiguration, Double> maxValue;
	public static volatile SingularAttribute<SensorConfiguration, Double> minValue;
	public static volatile SingularAttribute<SensorConfiguration, String> textValue;
	public static volatile ListAttribute<SensorConfiguration, AlertConfiguration> alertConfigurations;
	public static volatile SingularAttribute<SensorConfiguration, Sensor> sensor;
	public static volatile SingularAttribute<SensorConfiguration, Boolean> retired;
}
