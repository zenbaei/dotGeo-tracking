package com.esrinea.dotGeo.tracking.model.component.fence.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.fence.entity.Fence;

public class FenceDAOImpl extends AbstractDAO<Fence> implements FenceDAO {

	private static final Logger LOG = Logger.getLogger(FenceDAOImpl.class);

	public FenceDAOImpl() {
		super(Fence.class);
	}

	@Override
	public List<Fence> find(int groupId, boolean retired) {
		LOG.debug(String.format("Fence.findByGroupIdRetired, parameters %s, %s.", groupId, retired));
		List<Fence> fences = entityManager.createNamedQuery("Fence.findByGroupIdRetired", Fence.class).setParameter("groupId", groupId).setParameter("retired", retired).getResultList();
		if (fences == null || fences.isEmpty()) {
			LOG.info(String.format("No records were found in Tracking_ResGroup_Fences_Ass table with criteria of GROUP ID is %s and RETIRED is %s.", groupId, retired));
		}
		return fences;
	}

}
