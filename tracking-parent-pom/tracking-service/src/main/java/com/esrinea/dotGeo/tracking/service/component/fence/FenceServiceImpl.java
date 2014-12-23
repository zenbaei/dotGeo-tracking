package com.esrinea.dotGeo.tracking.service.component.fence;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.component.fence.dao.FenceDAO;
import com.esrinea.dotGeo.tracking.model.component.fence.entity.Fence;
import com.esrinea.dotGeo.tracking.service.common.service.AbstractService;
import com.esrinea.dotGeo.tracking.service.common.util.GisUtils;

public class FenceServiceImpl extends AbstractService<Fence> implements FenceService {

	private FenceDAO fenceDAO;
	private static final Logger LOG = Logger.getLogger(FenceServiceImpl.class);

	public FenceServiceImpl(FenceDAO fenceDAO) {
		super(fenceDAO);
	}

	@Override
	public List<Fence> find(int groupId, boolean retired) {
		return fenceDAO.find(groupId, retired);
	}

	@Override
	public boolean intersect(Fence fence, String gdbDatasource, String featureFieldName, double xCoord, double yCoord) throws UnknownHostException, IOException {
		LOG.debug(String.format("Method intersect is called with parameters: Fence ID %s, Fence Rule %s, Xcoord %s and Ycoord %s.", fence.getFenceId(), fence.getRule(), xCoord, yCoord));
		return GisUtils.isInFence(gdbDatasource, featureFieldName, fence.getFenceId(), xCoord, yCoord);
	}

}
