package com.esrinea.dotGeo.tracking.service.component.alert;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.alert.dao.AlertDAO;
import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.service.common.service.AbstractService;

public class AlertServiceImpl extends AbstractService<Alert> implements AlertService {

	private AlertDAO alertDAO;

	public AlertServiceImpl(AlertDAO alertDAO) {
		super(alertDAO);
		this.alertDAO = alertDAO;
	}

	@Override
	public List<Alert> find(int deviceTypeId, boolean retired) {
		return alertDAO.find(deviceTypeId, retired);
	}
}
