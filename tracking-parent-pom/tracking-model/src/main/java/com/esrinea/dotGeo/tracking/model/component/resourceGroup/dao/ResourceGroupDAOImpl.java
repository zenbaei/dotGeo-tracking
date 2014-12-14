package com.esrinea.dotGeo.tracking.model.component.resourceGroup.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.resourceGroup.entity.ResourceGroup;

public class ResourceGroupDAOImpl extends AbstractDAO<ResourceGroup> implements ResourceGroupDAO {

	private static Logger LOG = Logger.getLogger(ResourceGroupDAOImpl.class);

	public ResourceGroupDAOImpl() {
		super(ResourceGroup.class);
	}

	@Override
	public List<ResourceGroup> find(boolean retired, boolean hasFence) {
		LOG.debug(String.format("ResourceGroup.findByRetiredFence, parameters: %s, %s", retired, hasFence));
		List<ResourceGroup> resourceGroups = null;
		resourceGroups = entityManager.createNamedQuery("ResourceGroup.findByRetiredFence", ResourceGroup.class).setParameter("retired", retired).setParameter("hasFence", hasFence).getResultList();
		if (resourceGroups.isEmpty()) {
			LOG.info(String.format("No Records found in Tracking_Resource_ResGroup_Ass table using conditions of RETIRED is %s and FENCE is %s.", retired, hasFence));
		}

		return resourceGroups;
	}

	@Override
	public List<ResourceGroup> find(String deviceSerial, boolean retired) {
		LOG.debug(String.format("ResourceGroup.findByDeviceSerialRetired, parameters are: %s, %s.", deviceSerial, retired));
		List<ResourceGroup> resourceGroups = null;
		resourceGroups = entityManager.createNamedQuery("ResourceGroup.findByDeviceSerialRetired", ResourceGroup.class).setParameter("deviceSerial", deviceSerial).setParameter("retired", retired).getResultList();
		if (resourceGroups.isEmpty()) {
			LOG.info(String.format("No Records found in Tracking_Resource_ResGroup_Ass table join with Tracking_Devices table using conditions of DEVICE SERIAL is %s and RETIRED is %s.", deviceSerial, retired));
		}
		return resourceGroups;
	}

	@Override
	public List<ResourceGroup> find(int resourceId, boolean retired) {
		LOG.debug(String.format("ResourceGroup.findByResourceIdRetired, parameters: %s, %s", resourceId, retired));
		List<ResourceGroup> resourceGroups = null;
		resourceGroups = entityManager.createNamedQuery("ResourceGroup.findByResourceIdRetired", ResourceGroup.class).setParameter("resourceId", resourceId).setParameter("retired", retired).getResultList();
		if (resourceGroups.isEmpty()) {
			LOG.info(String.format("No Records found in Tracking_Resource_ResGroup_Ass table using conditions of RESOURCE ID is %s and RETIRED is %s.", resourceId, retired));
		}
		return resourceGroups;
	}
}
