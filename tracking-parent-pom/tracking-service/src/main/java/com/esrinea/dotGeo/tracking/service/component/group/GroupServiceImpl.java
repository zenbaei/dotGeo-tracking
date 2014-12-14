package com.esrinea.dotGeo.tracking.service.component.group;

import java.util.List;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.component.group.dao.GroupDAO;
import com.esrinea.dotGeo.tracking.model.component.group.entity.Group;
import com.esrinea.dotGeo.tracking.service.common.service.AbstractService;

public class GroupServiceImpl extends AbstractService<Group> implements GroupService {

	private GroupDAO groupDAO;
	private static final Logger LOG = Logger.getLogger(GroupServiceImpl.class);

	public GroupServiceImpl(GroupDAO groupDAO) {
		super(groupDAO);
		this.groupDAO = groupDAO;
	}

	@Override
	public List<Group> findByNotNullFenceLayer(boolean retired) {
		return groupDAO.findByNotNullFenceLayer(retired);
	}

	@Override
	public Group findByNotNullFenceLayer(int id, boolean retired) {
		return groupDAO.findByNotNullFenceLayer(id, retired);
	}

}
