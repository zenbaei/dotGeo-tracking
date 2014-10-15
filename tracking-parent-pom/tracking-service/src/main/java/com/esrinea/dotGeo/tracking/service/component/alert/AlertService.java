package com.esrinea.dotGeo.tracking.service.component.alert;

import java.util.List;

import com.esrinea.dotGeo.tracking.model.component.alert.entity.Alert;
import com.esrinea.dotGeo.tracking.service.common.GenericService;

public interface AlertService  extends GenericService<Alert>{

	List<Alert> find(int deviceTypeId, boolean retired);

}
