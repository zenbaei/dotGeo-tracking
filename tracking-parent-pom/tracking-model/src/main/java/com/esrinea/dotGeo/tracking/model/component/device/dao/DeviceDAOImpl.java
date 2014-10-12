package com.esrinea.dotGeo.tracking.model.component.device.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.esrinea.dotGeo.tracking.model.common.dao.AbstractDAO;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device;
import com.esrinea.dotGeo.tracking.model.component.device.entity.Device_;

public class DeviceDAOImpl extends AbstractDAO<Device> implements DeviceDAO {

	public DeviceDAOImpl() {
		super(Device.class);
	}

	@Override
	public List<Device> findByIdQuery(int id) {
		return entityManager.createNamedQuery("Device.findById", Device.class).setParameter(1, id).getResultList();
	}

	public Device findByIdCriteria(int id) {
		CriteriaBuilder cb = super.entityManager.getCriteriaBuilder();
		CriteriaQuery<Device> cq = cb.createQuery(Device.class);

		Root<Device> device = cq.from(Device.class);

		cq.where(cb.equal(device.get(Device_.retired), new Boolean(false)));
		cb.and(cb.equal(device.get(Device_.id), id));

		TypedQuery<Device> query = super.entityManager.createQuery(cq);
		return query.getSingleResult();

	}
}
