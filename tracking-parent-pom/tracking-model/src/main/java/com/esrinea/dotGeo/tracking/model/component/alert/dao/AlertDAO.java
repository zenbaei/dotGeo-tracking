package com.esrinea.dotGeo.tracking.model.component.alert.dao;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.common.dao.GenericDAO;
import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;

public interface AlertDAO extends GenericDAO<Alert> {

	List<Alert> find(int deviceTypeId, boolean retired);

}
