package com.esrinea.dotGeo.tracking.model.component.alert.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity.AlertConfiguration;
import com.esrinea.dotGeo.tracking.model.component.deviceType.entity.DeviceType;

@Generated(value="Dali", date="2014-10-12T14:50:47.169+0200")
@StaticMetamodel(Alert.class)
public class Alert_ {
	public static volatile SingularAttribute<Alert, Integer> id;
	public static volatile SingularAttribute<Alert, Boolean> retired;
	public static volatile SingularAttribute<Alert, String> nameEn;
	public static volatile ListAttribute<Alert, AlertConfiguration> alertConfigurations;
	public static volatile SingularAttribute<Alert, DeviceType> deviceType;
}
