package com.esrinea.dotGeo.tracking.processor;

import com.esri.ges.processor.GeoEventProcessorDefinitionBase;

public class DotGeoProcessorDefinition extends GeoEventProcessorDefinitionBase
{
	public DotGeoProcessorDefinition()
	{
		;
	}

	@Override
	public String getName()
	{
		return "SampleProcessor";
	}

	@Override
	public String getDomain()
	{
		return "sample.processor";
	}

	@Override
	public String getVersion()
	{
		return "10.2.2";
	}

	@Override
	public String getLabel()
	{
		return "Sample Processor";
	}

	@Override
	public String getDescription()
	{
		return "This is a sample processor.";
	}

	@Override
	public String getContactInfo()
	{
		return "geoeventprocessor@esri.com";
	}
}