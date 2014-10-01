package com.esrinea.dotGeo.tracking.model.component.resourceLiveFeed.dao;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.esrinea.dotGeo.tracking.model.component.device.dao.DeviceDAOTest;
import com.esrinea.dotGeo.tracking.model.component.resourceLiveFeed.entity.ResourceLiveFeed;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring/tracking-model-test-context.xml" })
@Transactional
public class ResourceLiveFeedDAOTest extends DeviceDAOTest {

	@Autowired
	private ResourceLiveFeedDAO resourceLiveFeedDAO;
	private ResourceLiveFeed resourceLiveFeed;

	@Before
	public void init() {
		resourceLiveFeed = new ResourceLiveFeed(device, new Date(), 134.434,
				1.2334, 120, 1.342, "dokki");
	}

	@Test
	public void testCreate() {
		resourceLiveFeedDAO.create(resourceLiveFeed);
		List<ResourceLiveFeed> resourceLiveFeeds = resourceLiveFeedDAO
				.find(device);
		Assert.assertEquals("dokki", resourceLiveFeeds.get(0).getZone());
	}
}
