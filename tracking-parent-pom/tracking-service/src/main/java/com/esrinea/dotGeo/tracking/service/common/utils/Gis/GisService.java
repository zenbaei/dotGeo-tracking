package com.esrinea.dotGeo.tracking.service.common.utils.Gis;

import java.io.IOException;
import java.net.UnknownHostException;

public interface GisService {

	public boolean isInFence(String gdbDatasource, String datasetName, String queryByField, int id, double xCoord, double yCoord) throws UnknownHostException, IOException, IllegalStateException;

	public String getAddress(String gdbDatasource, String datasetName, String queryByField, double xCoord, double yCoord);
}