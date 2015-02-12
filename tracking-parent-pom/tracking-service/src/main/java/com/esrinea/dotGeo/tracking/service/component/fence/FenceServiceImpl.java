package com.esrinea.dotGeo.tracking.service.component.fence;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import javax.jms.IllegalStateException;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import com.esrinea.dotGeo.tracking.model.component.fence.dao.FenceDAO;
import com.esrinea.dotGeo.tracking.model.component.fence.entity.Fence;
import com.esrinea.dotGeo.tracking.service.common.service.AbstractService;
import com.esrinea.dotGeo.tracking.service.common.utils.Gis.GisService;

public class FenceServiceImpl extends AbstractService<Fence> implements FenceService {

	private FenceDAO fenceDAO;
	private static final Logger LOG = Logger.getLogger(FenceServiceImpl.class);
	private String gisServiceURL;
	private RestTemplate restTemplate = new RestTemplate();
	private GisService gisService;

	public FenceServiceImpl(FenceDAO fenceDAO) {
		super(fenceDAO);
		this.fenceDAO = fenceDAO;
	}

	@Override
	public List<Fence> find(int groupId, boolean retired) {
		return fenceDAO.find(groupId, retired);
	}

	@Override
	public boolean intersect(Fence fence, String gdbDatasource, String datasetName, String queryByField, double xCoord, double yCoord) throws UnknownHostException, IOException, IllegalStateException, InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		LOG.debug(String.format("Method intersect is called with parameters: Fence ID %s, GdbDataSource %s, DatasetName %s,QueryByField %s, Xcoord %s and Ycoord %s.", fence.getFenceId(), gdbDatasource, datasetName, queryByField, xCoord, yCoord));
	//	return gisService.isInFence(gdbDatasource, datasetName, queryByField, fence.getFenceId(), xCoord, yCoord);
		
		String URL = gisServiceURL + "/" + gdbDatasource.split(":")[0] + "/" + gdbDatasource.split(":")[1] + "/" + datasetName + "/" + queryByField + "/" + fence.getFenceId() + "/" + xCoord + "/" + yCoord;
		LOG.info(URL);
		return Boolean.valueOf(restTemplate.getForObject(URL, String.class));
	}

	public void setGisServiceURL(String gisServiceURL) {
		this.gisServiceURL = gisServiceURL;
	}
	
	public void setGisService(GisService gisService) {
		this.gisService = gisService;
	}

}
