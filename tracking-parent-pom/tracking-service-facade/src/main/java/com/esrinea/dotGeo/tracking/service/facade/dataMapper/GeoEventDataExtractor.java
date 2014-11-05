package com.esrinea.dotGeo.tracking.service.facade.dataMapper;

import com.esri.ges.core.geoevent.GeoEvent;
import com.esrinea.dotGeo.tracking.service.facade.dto.EventData;

/**
 * This interface has two implementations, see:<br>
 * {@link GeoEventDataExtractorStaticImpl}<br>
 * {@link GeoEventDataExtractorDynamicImpl}
 * @author islam.zenbaei
 */
public interface GeoEventDataExtractor {
	
	/**
	 * Extracts Data from {@link GeoEvent} then construct a {@link EventData}.
	 * 
	 * @param geoEvent
	 * @return
	 */
	public EventData extract(GeoEvent geoEvent);

}
