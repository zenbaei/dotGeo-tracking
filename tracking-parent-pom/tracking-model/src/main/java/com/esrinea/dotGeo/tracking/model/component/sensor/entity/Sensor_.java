package com.esrinea.dotGeo.tracking.model.component.sensor.entity;

import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-12T14:50:47.500+0200")
@StaticMetamodel(Sensor.class)
public class Sensor_ {
	public static volatile SingularAttribute<Sensor, Integer> id;
	public static volatile SingularAttribute<Sensor, Boolean> retired;
	public static volatile SingularAttribute<Sensor, String> nameEn;
	public static volatile ListAttribute<Sensor, SensorConfiguration> sensorConfigurations;
	public static volatile SingularAttribute<Sensor, DeviceType> deviceType;
}
