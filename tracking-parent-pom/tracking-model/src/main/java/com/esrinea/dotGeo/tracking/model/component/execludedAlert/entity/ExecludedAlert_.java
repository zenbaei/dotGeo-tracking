package com.esrinea.dotGeo.tracking.model.component.execludedAlert.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.model.component.resource.entity.Resource;

@Generated(value="Dali", date="2014-10-12T14:50:47.473+0200")
@StaticMetamodel(ExecludedAlert.class)
public class ExecludedAlert_ {
	public static volatile SingularAttribute<ExecludedAlert, Integer> id;
	public static volatile SingularAttribute<ExecludedAlert, Alert> alert;
	public static volatile SingularAttribute<ExecludedAlert, Resource> resource;
}
