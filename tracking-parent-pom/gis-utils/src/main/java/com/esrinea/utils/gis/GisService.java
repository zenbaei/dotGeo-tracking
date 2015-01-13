package com.esrinea.utils.gis;

import java.io.IOException;
import java.net.UnknownHostException;

public interface GisService {

	boolean isInFence(String gdbDatasource, String queryByField, int id, double xCoord, double yCoord) throws UnknownHostException, IOException, IllegalStateException;
}