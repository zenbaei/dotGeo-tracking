package com.esrinea.dotGeo.tracking.model.component.alertLiveFeed.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-12T14:50:47.456+0200")
@StaticMetamodel(AlertLiveFeed.class)
public class AlertLiveFeed_ {
	public static volatile SingularAttribute<AlertLiveFeed, Integer> alert_LiveFeeds_DBID;
	public static volatile SingularAttribute<AlertLiveFeed, Timestamp> alert_DateTime;
	public static volatile SingularAttribute<AlertLiveFeed, Integer> alert_DBID;
	public static volatile SingularAttribute<AlertLiveFeed, Timestamp> creationDate;
	public static volatile SingularAttribute<AlertLiveFeed, Integer> device_DBID;
	public static volatile SingularAttribute<AlertLiveFeed, Integer> device_Type_DBID;
	public static volatile SingularAttribute<AlertLiveFeed, Integer> resource_DBID;
	public static volatile SingularAttribute<AlertLiveFeed, Integer> resource_Type_DBID;
	public static volatile SingularAttribute<AlertLiveFeed, byte[]> zoneGeo;
}
