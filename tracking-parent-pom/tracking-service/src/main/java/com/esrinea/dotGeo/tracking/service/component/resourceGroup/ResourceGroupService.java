package com.esrinea.dotGeo.tracking.service.component.resourceGroup;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.resourceGroup.entity.ResourceGroup;
import com.esrinea.dotGeo.tracking.service.common.service.GenericService;

public interface ResourceGroupService extends GenericService<ResourceGroup> {

	List<ResourceGroup> find(int resourceId, boolean retired);
}
