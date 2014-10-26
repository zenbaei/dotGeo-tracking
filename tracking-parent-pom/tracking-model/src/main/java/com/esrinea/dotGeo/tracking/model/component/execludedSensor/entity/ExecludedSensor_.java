package com.esrinea.dotGeo.tracking.model.component.execludedSensor.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;

@Generated(value="Dali", date="2014-10-12T14:50:47.480+0200")
@StaticMetamodel(ExecludedSensor.class)
public class ExecludedSensor_ {
	public static volatile SingularAttribute<ExecludedSensor, Integer> id;
	public static volatile SingularAttribute<ExecludedSensor, Sensor> sensor;
	public static volatile SingularAttribute<ExecludedSensor, Resource> resource;
}
