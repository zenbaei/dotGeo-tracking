package com.esrinea.dotGeo.tracking.model.component.device.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;
import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;

@Generated(value="Dali", date="2014-10-12T15:30:56.051+0200")
@StaticMetamodel(Device.class)
public class Device_ {
	public static volatile SingularAttribute<Device, Integer> id;
	public static volatile SingularAttribute<Device, Boolean> retired;
	public static volatile SingularAttribute<Device, DeviceType> deviceType;
	public static volatile SingularAttribute<Device, Resource> resource;
}
