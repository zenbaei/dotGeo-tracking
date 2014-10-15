package com.esrinea.dotGeo.tracking.service.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/application-context.xml",
		"classpath:/spring/tracking-service-spring-test-context.xml",
		"classpath:/spring/tracking-model-spring-test-context.xml" })
@Transactional
public class ServiceFacadeTest {

	@Autowired
	private ServiceFacade serviceFacade;
	
	@Test
	public void testBuildDeviceType(){
		serviceFacade.buildDeviceType();
	}
	
	
	

}
