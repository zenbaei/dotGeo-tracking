package com.esrinea.dotGeo.tracking.model.component.group.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.group.entity.Group;

public class GroupDAOImpl extends AbstractDAO<Group> implements GroupDAO {

	private static Logger LOG = Logger.getLogger(GroupDAOImpl.class);

	public GroupDAOImpl() {
		super(Group.class);
	}

	@Override
	public List<Group> findByNotNullFenceLayer(boolean retired) {
		LOG.debug(String.format("Group.findByRetiredFenceLayer, parameteres %s and FenceLayer is not Null.", retired));
		List<Group> groups = entityManager.createNamedQuery("Group.findByRetiredFenceLayer", Group.class).setParameter("retired", retired).getResultList();
		if (groups.isEmpty()) {
			LOG.info(String.format("No Records were found in Tracking_Resource_Groups table, with criteria of RETIRED is %s and FENCE LAYER is not Null.", retired));
		}
		return groups;
	}

	@Override
	public Group findByNotNullFenceLayer(int id, boolean retired) {
		LOG.debug(String.format("Group.findByIdRetiredFenceLayer, parameteres are ID %s, RETIRED %s and FenceLayer is not Null.", id, retired));
		Group group = null;
		try {
			group = entityManager.createNamedQuery("Group.findByIdRetiredFenceLayer", Group.class).setParameter("id", id).setParameter("retired", retired).getSingleResult();
		} catch (NoResultException ex) {
			LOG.warn(String.format("%s with criteria of ID is %s, RETIRED is %s and FENCE LAYER is not Null does not exist in DB.", "Group", id, retired));
		} catch (NonUniqueResultException ex) {
			LOG.warn(String.format("%s with criteria of ID is %s, RETIRED is %s and FENCE LAYER is not Null is duplicated or the one to one realtion it is joining with is refering it, more than once by mistake.", "Group",
					id, retired));
		}
		return group;
	}

}
