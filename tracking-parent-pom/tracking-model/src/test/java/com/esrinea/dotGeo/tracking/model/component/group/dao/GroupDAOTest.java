package com.esrinea.dotGeo.tracking.model.component.group.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.esrinea.dotGeo.tracking.model.component.fence.dao.FenceDAO;
import com.esrinea.dotGeo.tracking.model.component.fence.entity.Fence;
import com.esrinea.dotGeo.tracking.model.component.group.entity.Group;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/tracking-model-spring-test-context.xml" })
public class GroupDAOTest {

	@Autowired
	private GroupDAO groupDAO;
	@Autowired
	private FenceDAO fenceDAO;

	//@Test
	public void testFindByRetiredFence() {
		List<Group> groups = groupDAO.findByNotNullFenceLayer(false);
		Assert.assertTrue(groups.size() > 0);
		Assert.assertNotNull(groups.get(0).getFenceLayer());

		List<Fence> fences = fenceDAO.find(groups.get(0).getId(), false);
		Assert.assertFalse(fences.isEmpty());
	}
	
	@Test
	public void testFindByIdRetiredFence() {
		Group group = groupDAO.findByNotNullFenceLayer(1, false);
		Assert.assertNotNull(group);
		List<Fence> fences = fenceDAO.find(group.getId(), false);
		Assert.assertFalse(fences.isEmpty());
	}
}
