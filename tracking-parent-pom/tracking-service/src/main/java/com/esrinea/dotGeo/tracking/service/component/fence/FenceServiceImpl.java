package com.esrinea.dotGeo.tracking.service.component.fence;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.fence.dao.FenceDAO;
import com.esrinea.dotGeo.tracking.model.component.fence.entity.Fence;
import com.esrinea.dotGeo.tracking.service.common.service.AbstractService;

public class FenceServiceImpl extends AbstractService<Fence> implements FenceService {

	private FenceDAO fenceDAO;
	
	public FenceServiceImpl(FenceDAO fenceDAO) {
		super(fenceDAO);
		this.fenceDAO = fenceDAO;
	}

	@Override
	public List<Fence> find(int groupId, boolean retired) {
		return fenceDAO.find(groupId, retired);
	}
	
	
	
	
}
