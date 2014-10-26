package com.esrinea.dotGeo.tracking.model.component.resourceLiveFeed.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;

@Generated(value="Dali", date="2014-10-12T14:50:47.493+0200")
@StaticMetamodel(ResourceLiveFeed.class)
public class ResourceLiveFeed_ {
	public static volatile SingularAttribute<ResourceLiveFeed, Integer> id;
	public static volatile SingularAttribute<ResourceLiveFeed, Device> device;
	public static volatile SingularAttribute<ResourceLiveFeed, Date> feedDateTime;
	public static volatile SingularAttribute<ResourceLiveFeed, Double> heading;
	public static volatile SingularAttribute<ResourceLiveFeed, Integer> speed;
	public static volatile SingularAttribute<ResourceLiveFeed, Double> xCoord;
	public static volatile SingularAttribute<ResourceLiveFeed, Double> yCoord;
	public static volatile SingularAttribute<ResourceLiveFeed, String> zone;
}
