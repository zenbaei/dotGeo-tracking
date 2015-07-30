package com.esrinea.dotGeo.tracking.service.facade.business;

import com.esri.ges.core.geoevent.GeoEvent;
import com.esrinea.dotGeo.tracking.service.facade.dto.EventData;

/**
 * A facade that combines different tracking services together to fill the database with the data received from the GeoEvent based on the given scenario.<br>
 * The reason for separating this thin application is to be able to change and deploy it without changing the GeoEvent's tracking-processor or tracking-service applications.
 * 
 * @author islam.zenbaei
 *
 */
public interface TrackingServiceFacade {

	/**
	 * Extracts Data from {@link GeoEvent} into a custom object {@link EventData},<br>
	 * then process the passed info against Device's configurations.
	 */
	void process(GeoEvent geoEvent) throws Exception;

	/**
	 * 
	 * Retrieve all active devices along with active deviceTypes and active (not retired) sensors, sensors configurations,<br>
	 * alerts and alerts configurations, resources and its groups then add them to map that will act as a cache for devices.
	 * 
	 */
	void initializeCache();

	/**
	 * Process Received Device and check its passed information against its configurations using the cached data then acts accordingly.<br>
	 * Note: Device info will only exist in cache if it has an active deviceType and sensorConfigurations.
	 * 
	 * @throws Exception
	 */
	void deviceFeedReceived(EventData eventData) throws Exception;
}
