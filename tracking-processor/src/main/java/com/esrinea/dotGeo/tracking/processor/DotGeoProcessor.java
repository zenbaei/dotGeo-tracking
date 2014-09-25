package com.esrinea.dotGeo.tracking.processor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.esri.ges.core.component.ComponentException;
import com.esri.ges.core.geoevent.GeoEvent;
import com.esri.ges.core.property.Property;
import com.esri.ges.processor.GeoEventProcessorBase;
import com.esri.ges.processor.GeoEventProcessorDefinition;
import com.esrinea.dotGeo.tracking.service.component.device.DeviceService;

public class DotGeoProcessor extends GeoEventProcessorBase {
	private static final Log LOG = LogFactory.getLog(DotGeoProcessor.class);

	private long lastReport = 0;
	private int maxMessageRate = 500;
	private boolean printedWarning;
	private DeviceService deviceService;

	protected DotGeoProcessor(GeoEventProcessorDefinition definition, DeviceService deviceService)
			throws ComponentException {
		super(definition);
		this.deviceService = deviceService;
	}

	@Override
	public GeoEvent process(GeoEvent geoEvent) throws Exception {

		LOG.info("Succeeded to find employee");
		LOG.info(deviceService.getEmployee(100l));

		if (maxMessageRate > 0) {
			if ((System.currentTimeMillis() - lastReport) > maxMessageRate) {
				if (!printedWarning)
					LOG.debug("Sample Processing ... (Limiting output to no more than 1 line every "
							+ maxMessageRate + " ms)");
				else
					LOG.debug("Sample Processing ... ");
				lastReport = System.currentTimeMillis();
			}
		} else
			LOG.debug("Sample Processing ... ");

		return geoEvent;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(definition.getName());
		sb.append("/");
		sb.append(definition.getVersion());
		sb.append("[");
		for (Property p : getProperties()) {
			sb.append(p.getDefinition().getPropertyName());
			sb.append(":");
			sb.append(p.getValue());
			sb.append(" ");
		}
		sb.append("]");
		return sb.toString();
	}

}