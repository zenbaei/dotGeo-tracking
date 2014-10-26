package com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.sensorConfiguration.entity.SensorConfiguration;

@Generated(value="Dali", date="2014-10-12T14:50:47.450+0200")
@StaticMetamodel(AlertConfiguration.class)
public class AlertConfiguration_ {
	public static volatile SingularAttribute<AlertConfiguration, Integer> id;
	public static volatile SingularAttribute<AlertConfiguration, Boolean> retired;
	public static volatile SingularAttribute<AlertConfiguration, Alert> alert;
	public static volatile SingularAttribute<AlertConfiguration, SensorConfiguration> sensorConfiguration;
}
