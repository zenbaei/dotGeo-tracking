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
import com.esrinea.dotGeo.tracking.utils.GisUtils;

public class FenceServiceImpl extends AbstractService<Fence> implements FenceService {

	private FenceDAO fenceDAO;
	private static final Logger LOG = Logger.getLogger(FenceServiceImpl.class);
	private String gisServiceURL;
	private RestTemplate restTemplate = new RestTemplate();

	public FenceServiceImpl(FenceDAO fenceDAO) {
		super(fenceDAO);
		this.fenceDAO = fenceDAO;
	}

	@Override
	public List<Fence> find(int groupId, boolean retired) {
		return fenceDAO.find(groupId, retired);
	}

	@Override
	public boolean intersect(Fence fence, String gdbDataSource, String queryByField, double xCoord, double yCoord) throws UnknownHostException, IOException, IllegalStateException, InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		LOG.debug(String.format("Method intersect is called with parameters: Fence ID %s, GdbDataSource %s, QueryByField %s, Xcoord %s and Ycoord %s.", fence.getFenceId(), gdbDataSource, queryByField, xCoord, yCoord));
		String URL = gisServiceURL + "/" + gdbDataSource.split(":")[0] + "/" + gdbDataSource.split(":")[1] + "/" + queryByField + "/" + fence.getFenceId() + "/" + xCoord + "/" + yCoord;
		LOG.info(URL);
		return Boolean.valueOf(restTemplate.getForObject(URL, String.class));
	}

	public void setGisServiceURL(String gisServiceURL) {
		this.gisServiceURL = gisServiceURL;
	}

}
