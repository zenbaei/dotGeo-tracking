package com.esrinea.dotGeo.tracking.model.component.sensorLiveFeed.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;

@Generated(value="Dali", date="2014-10-12T14:50:47.512+0200")
@StaticMetamodel(SensorLiveFeed.class)
public class SensorLiveFeed_ {
	public static volatile SingularAttribute<SensorLiveFeed, Integer> id;
	public static volatile SingularAttribute<SensorLiveFeed, Device> device;
	public static volatile SingularAttribute<SensorLiveFeed, String> sensorValue;
	public static volatile SingularAttribute<SensorLiveFeed, SensorConfiguration> sensorConfiguration;
	public static volatile SingularAttribute<SensorLiveFeed, Date> dateTime;
}
