package com.esrinea.dotGeo.tracking.service.common.util;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.jms.IllegalStateException;

import org.junit.Assert;
import org.junit.Test;

public class GisUtilsTest {

	String gdbDatasource = "D:/LA_Zones.gdb";
	String fieldName = "ID";
	int id = 4;
/*
	@Test
	public void testIsInFence() throws UnknownHostException, IOException, IllegalStateException {
		boolean inFence = false;
		inFence = GisUtilsImpl.isInFence(gdbDatasource, fieldName, id, -13194324.3944, 4063072.6992);
		Assert.assertTrue(inFence);
		inFence = GisUtilsImpl.isInFence(gdbDatasource, fieldName, id, -13191471.0165, 4042221.0916);
		Assert.assertFalse(inFence);
	}
*/
}
