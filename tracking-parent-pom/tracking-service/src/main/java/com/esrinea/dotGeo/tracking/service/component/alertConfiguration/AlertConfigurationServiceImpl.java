package com.esrinea.dotGeo.tracking.service.component.alertConfiguration;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.dao.AlertConfigurationDAO;
import com.esrinea.dotGeo.tracking.model.component.alertConfiguration.entity.AlertConfiguration;
import com.esrinea.dotGeo.tracking.service.common.AbstractService;

public class AlertConfigurationServiceImpl extends AbstractService<AlertConfiguration> implements AlertConfigurationService{

	private AlertConfigurationDAO alertConfigurationDAO;
	
	public AlertConfigurationServiceImpl(AlertConfigurationDAO alertConfigurationDAO) {
		super(alertConfigurationDAO);
		this.alertConfigurationDAO = alertConfigurationDAO;
	}

	@Override
	public List<AlertConfiguration> find(int alertId, boolean retired) {
		return alertConfigurationDAO.find(alertId, retired);
	}

}
