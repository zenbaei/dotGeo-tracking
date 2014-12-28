package com.esrinea.dotGeo.tracking.service.component.fence;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import javax.jms.IllegalStateException;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;
import com.esrinea.dotGeo.tracking.model.component.fence.entity.Fence;

public interface FenceService extends GenericDAO<Fence>{
	
	List<Fence> find(int groupId, boolean retired);

	boolean intersect(Fence fence, String gdbDatasource, String featureFieldName, double xCoord, double yCoord)throws UnknownHostException, IOException, IllegalStateException;

}
