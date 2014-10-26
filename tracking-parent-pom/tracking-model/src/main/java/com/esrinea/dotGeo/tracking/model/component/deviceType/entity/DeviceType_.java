package com.esrinea.dotGeo.tracking.model.component.deviceType.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;

@Generated(value="Dali", date="2014-10-12T14:50:47.469+0200")
@StaticMetamodel(DeviceType.class)
public class DeviceType_ {
	public static volatile SingularAttribute<DeviceType, Integer> id;
	public static volatile ListAttribute<DeviceType, Sensor> sensors;
	public static volatile ListAttribute<DeviceType, Alert> alerts;
}
