package com.esrinea.dotGeo.tracking.model.component.resource.entity;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.execludedAlert.entity.ExecludedAlert;
import com.esrinea.dotGeo.tracking.model.component.execludedSensor.entity.ExecludedSensor;
import com.esrinea.dotGeo.tracking.model.component.sensor.entity.Sensor;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-12T14:50:47.486+0200")
@StaticMetamodel(Resource.class)
public class Resource_ {
	public static volatile SingularAttribute<Resource, Integer> id;
	public static volatile MapAttribute<Resource, Alert, ExecludedAlert> execludedAlerts;
	public static volatile MapAttribute<Resource, Sensor, ExecludedSensor> execludedSensors;
	public static volatile SingularAttribute<Resource, Device> device;
}
