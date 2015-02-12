package com.esrinea.utils.gis;

import java.io.IOException;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GisController {

	@Autowired
	private GisService gisUtils;

	@RequestMapping("/isInFence/{drivePath}/{gdbDatasource}/{datasetName}/{queryByField}/{id}/{xCoord}/{yCoord}")
	public boolean isInFence(@PathVariable String gdbDatasource, @PathVariable String drivePath, @PathVariable String datasetName, @PathVariable String queryByField, @PathVariable int id, @PathVariable double xCoord, @PathVariable double yCoord)
			throws UnknownHostException, IllegalStateException, IOException {
		return gisUtils.isInFence(drivePath + ":/" + gdbDatasource, datasetName, queryByField, id, xCoord, yCoord);
	}

	@RequestMapping("/getAddress/{drivePath}/{gdbDatasource}/{datasetName}/{fieldName}/{xCoord}/{yCoord}")
	public String getAddress(@PathVariable String gdbDatasource, @PathVariable String drivePath, @PathVariable String datasetName, @PathVariable String fieldName, @PathVariable double xCoord, @PathVariable double yCoord) throws UnknownHostException,
			IllegalStateException, IOException {
		return gisUtils.getAddress(drivePath + ":/" + gdbDatasource, datasetName, fieldName, xCoord, yCoord);
	}

}
