package com.esrinea.dotGeo.tracking.model.component.alert.dao;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;

public class AlertDAOImpl extends AbstractDAO<Alert> implements AlertDAO<Alert> {

	public AlertDAOImpl() {
		super(Alert.class);
	}

}
