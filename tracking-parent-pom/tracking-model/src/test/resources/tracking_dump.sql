USE [BetaTrackingDBV501]
GO
/****** Object:  StoredProcedure [dbo].[sp_GetTrackingResourceByRoleID]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP PROCEDURE [dbo].[sp_GetTrackingResourceByRoleID]
GO
/****** Object:  StoredProcedure [dbo].[SP_GetTrackingReport_Resource]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP PROCEDURE [dbo].[SP_GetTrackingReport_Resource]
GO
/****** Object:  StoredProcedure [dbo].[SP_GetTrackingReport_Alert]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP PROCEDURE [dbo].[SP_GetTrackingReport_Alert]
GO
/****** Object:  StoredProcedure [dbo].[sp_GetTrackingDevicesByUser]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP PROCEDURE [dbo].[sp_GetTrackingDevicesByUser]
GO
/****** Object:  StoredProcedure [dbo].[Sp_GetGroupTree]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP PROCEDURE [dbo].[Sp_GetGroupTree]
GO
/****** Object:  StoredProcedure [dbo].[sp_getAlertsByDeviceTypeID]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP PROCEDURE [dbo].[sp_getAlertsByDeviceTypeID]
GO
/****** Object:  StoredProcedure [dbo].[Sp_GetAlertInfo]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP PROCEDURE [dbo].[Sp_GetAlertInfo]
GO
/****** Object:  StoredProcedure [dbo].[SP_Get_Sensor_Configurations]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP PROCEDURE [dbo].[SP_Get_Sensor_Configurations]
GO
/****** Object:  StoredProcedure [dbo].[SP_Get_Group_LiveFeeds]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP PROCEDURE [dbo].[SP_Get_Group_LiveFeeds]
GO
/****** Object:  StoredProcedure [dbo].[SP_Get_Group_AlertLiveFeeds]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP PROCEDURE [dbo].[SP_Get_Group_AlertLiveFeeds]
GO
ALTER TABLE [dbo].[Tracking_Resources] DROP CONSTRAINT [FK_Tracking_Resources_ResourcesTypes]
GO
ALTER TABLE [dbo].[Tracking_Resources] DROP CONSTRAINT [FK_Tracking_Resources_Devices]
GO
ALTER TABLE [dbo].[Tracking_ResourceGroup_GeoRole] DROP CONSTRAINT [FK_Tracking_ResourceGroup_GeoRole_ResourceGroup]
GO
ALTER TABLE [dbo].[Tracking_Resource_ResGroup_Ass] DROP CONSTRAINT [FK_Tracking_Resource_ResourceGroup_Ass_ResourceGroup]
GO
ALTER TABLE [dbo].[Tracking_Resource_ResGroup_Ass] DROP CONSTRAINT [FK_Tracking_Resource_ResourceGroup_Ass_Resource]
GO
ALTER TABLE [dbo].[Tracking_Resource_Groups] DROP CONSTRAINT [FK_Tracking_Resource_Groups_Tracking_Resource_Groups]
GO
ALTER TABLE [dbo].[Tracking_Resource_Groups] DROP CONSTRAINT [FK_Tracking_Resource_Groups_FenceLayer]
GO
ALTER TABLE [dbo].[Tracking_Resource_Crew] DROP CONSTRAINT [FK_Tracking_Resource_Crew_Resource]
GO
ALTER TABLE [dbo].[Tracking_Resource_Crew] DROP CONSTRAINT [FK_Tracking_Resource_Crew_Crew]
GO
ALTER TABLE [dbo].[Tracking_ResGroup_Fences_Ass] DROP CONSTRAINT [FK_Tracking_ResourceGroup_Fences_Ass_ResourceGroup]
GO
ALTER TABLE [dbo].[Tracking_Devices] DROP CONSTRAINT [FK_Tracking_Devices_DeviceTypes]
GO
ALTER TABLE [dbo].[Sensors] DROP CONSTRAINT [FK_Sensors_Tracking_Device_Types]
GO
ALTER TABLE [dbo].[Sensors] DROP CONSTRAINT [FK_Sensors_Sensor_Types]
GO
ALTER TABLE [dbo].[Sensor_Configuration] DROP CONSTRAINT [FK_Sensor_Configuration_Sensors]
GO
ALTER TABLE [dbo].[ResourceGroup_FenceLayer_Ass] DROP CONSTRAINT [FK_ResourceGroup_FenceLayer_Ass_ResourceGroup]
GO
ALTER TABLE [dbo].[ResourceGroup_FenceLayer_Ass] DROP CONSTRAINT [FK_ResourceGroup_FenceLayer_Ass_FenceLayer]
GO
ALTER TABLE [dbo].[Resource_Execluded_Sensors] DROP CONSTRAINT [FK_Resource_Execluded_Sensors_Sensors]
GO
ALTER TABLE [dbo].[Resource_Execluded_Sensors] DROP CONSTRAINT [FK_Resource_Execluded_Sensors_Resource]
GO
ALTER TABLE [dbo].[Resource_Execluded_Alerts] DROP CONSTRAINT [FK_Resource_Execluded_Alerts_Resource]
GO
ALTER TABLE [dbo].[Resource_Execluded_Alerts] DROP CONSTRAINT [FK_Resource_Execluded_Alerts_Alerts]
GO
ALTER TABLE [dbo].[DeviceType_SensorsConfig] DROP CONSTRAINT [FK_DeviceType_SensorsConfiguration_SensorsConfiguration]
GO
ALTER TABLE [dbo].[DeviceType_SensorsConfig] DROP CONSTRAINT [FK_DeviceType_SensorsConfiguration_DeviceType]
GO
ALTER TABLE [dbo].[Alerts] DROP CONSTRAINT [FK__Alerts__DeviceTy__2962141D]
GO
ALTER TABLE [dbo].[Alert_Configuration] DROP CONSTRAINT [FK_Alert_Configuration_Sensor_Configuration]
GO
ALTER TABLE [dbo].[Alert_Configuration] DROP CONSTRAINT [FK_Alert_Configuration_Alerts]
GO
ALTER TABLE [dbo].[Tracking_ResGroup_Fences_Ass] DROP CONSTRAINT [DF_Tracking_ResGroup_Fences_Ass_GeoFenceRule]
GO
ALTER TABLE [dbo].[Tracking_ResGroup_Fences_Ass] DROP CONSTRAINT [DF__Tracking___IsRet__2C3393D0]
GO
ALTER TABLE [dbo].[ResourceGroup_FenceLayer_Ass] DROP CONSTRAINT [DF__ResourceG__IsRet__173876EA]
GO
/****** Object:  Table [dbo].[User_Saved_AlertSettings]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[User_Saved_AlertSettings]
GO
/****** Object:  Table [dbo].[TRACKING_ROLES]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[TRACKING_ROLES]
GO
/****** Object:  Table [dbo].[Tracking_Resources]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Tracking_Resources]
GO
/****** Object:  Table [dbo].[Tracking_ResourceGroup_GeoRole]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Tracking_ResourceGroup_GeoRole]
GO
/****** Object:  Table [dbo].[Tracking_Resource_Types]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Tracking_Resource_Types]
GO
/****** Object:  Table [dbo].[Tracking_Resource_ResGroup_Ass]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Tracking_Resource_ResGroup_Ass]
GO
/****** Object:  Table [dbo].[Tracking_Resource_LiveFeeds]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Tracking_Resource_LiveFeeds]
GO
/****** Object:  Table [dbo].[Tracking_Resource_LFHistory]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Tracking_Resource_LFHistory]
GO
/****** Object:  Table [dbo].[Tracking_Resource_Groups]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Tracking_Resource_Groups]
GO
/****** Object:  Table [dbo].[Tracking_Resource_Crew]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Tracking_Resource_Crew]
GO
/****** Object:  Table [dbo].[Tracking_ResGroup_Fences_Ass]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Tracking_ResGroup_Fences_Ass]
GO
/****** Object:  Table [dbo].[Tracking_Fence_Layers]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Tracking_Fence_Layers]
GO
/****** Object:  Table [dbo].[Tracking_Devices]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Tracking_Devices]
GO
/****** Object:  Table [dbo].[Tracking_Device_Types]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Tracking_Device_Types]
GO
/****** Object:  Table [dbo].[Tracking_Crew]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Tracking_Crew]
GO
/****** Object:  Table [dbo].[Tracking_Alert_Sensor_LiveFeeds]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Tracking_Alert_Sensor_LiveFeeds]
GO
/****** Object:  Table [dbo].[sequence_store]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[sequence_store]
GO
/****** Object:  Table [dbo].[Sensors_LiveFeedsHistory]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Sensors_LiveFeedsHistory]
GO
/****** Object:  Table [dbo].[Sensors_LiveFeeds]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Sensors_LiveFeeds]
GO
/****** Object:  Table [dbo].[Sensors]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Sensors]
GO
/****** Object:  Table [dbo].[Sensor_Types]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Sensor_Types]
GO
/****** Object:  Table [dbo].[Sensor_Configuration]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Sensor_Configuration]
GO
/****** Object:  Table [dbo].[ResourceGroup_FenceLayer_Ass]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[ResourceGroup_FenceLayer_Ass]
GO
/****** Object:  Table [dbo].[Resource_Execluded_Sensors]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Resource_Execluded_Sensors]
GO
/****** Object:  Table [dbo].[Resource_Execluded_Alerts]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Resource_Execluded_Alerts]
GO
/****** Object:  Table [dbo].[DeviceType_SensorsConfig]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[DeviceType_SensorsConfig]
GO
/****** Object:  Table [dbo].[Alerts]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Alerts]
GO
/****** Object:  Table [dbo].[Alert_LiveFeedsHistory]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Alert_LiveFeedsHistory]
GO
/****** Object:  Table [dbo].[Alert_LiveFeeds]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Alert_LiveFeeds]
GO
/****** Object:  Table [dbo].[Alert_Configuration]    Script Date: 12/8/2014 11:48:19 AM ******/
DROP TABLE [dbo].[Alert_Configuration]
GO
/****** Object:  Table [dbo].[Alert_Configuration]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Alert_Configuration](
	[AlertConfig_DBID] [int] IDENTITY(1,1) NOT NULL,
	[Alert_DBID] [int] NOT NULL,
	[SensorConfig_DBID] [int] NOT NULL,
	[Comments] [nvarchar](200) NULL,
	[Modified_By] [int] NULL,
	[Created_By] [int] NULL,
	[Creation_Date] [datetime] NULL,
	[Modification_Date] [datetime] NULL,
	[IsRetired] [bit] NULL CONSTRAINT [DF__Alert_Con__IsRet__7F60ED59]  DEFAULT ((0)),
 CONSTRAINT [PK_Alert_Configuration] PRIMARY KEY CLUSTERED 
(
	[AlertConfig_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Alert_LiveFeeds]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Alert_LiveFeeds](
	[Alert_LiveFeeds_DBID] [int] NOT NULL,
	[Device_DBID] [int] NOT NULL,
	[Alert_DBID] [int] NOT NULL,
	[Alert_DateTime] [datetime] NOT NULL,
	[Zone] [nvarchar](150) NULL,
	[Device] [nvarchar](150) NULL,
	[ZoneGeo] [geometry] NULL,
	[AlertName_En] [nvarchar](100) NULL,
	[AlertName_Ar] [nvarchar](100) NULL,
	[Icon] [nvarchar](150) NULL,
	[Color] [nvarchar](50) NULL,
	[CreationDate] [datetime] NULL,
	[Groups_en] [nvarchar](150) NULL,
	[Groups_Ar] [nvarchar](150) NULL,
	[GroupsIDs] [nvarchar](250) NULL,
	[PlateNumber] [nvarchar](10) NULL,
	[License] [nvarchar](10) NULL,
	[Resource_DBID] [int] NULL,
	[Resource_Type_DBID] [int] NULL,
	[Resource_Type_EnDesc] [nvarchar](100) NULL,
	[Resource_Type_ArDesc] [nvarchar](100) NULL,
	[Device_Type_DBID] [int] NULL,
	[X_Coord] [float] NULL,
	[Y_Coord] [float] NULL,
	[SensorType] [nvarchar](150) NULL,
 CONSTRAINT [PK_Alert_LiveFeeds] PRIMARY KEY CLUSTERED 
(
	[Alert_LiveFeeds_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Alert_LiveFeedsHistory]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Alert_LiveFeedsHistory](
	[Alert_LiveFeeds_DBID] [int] NOT NULL,
	[Device_DBID] [int] NOT NULL,
	[Alert_DBID] [int] NOT NULL,
	[Alert_DateTime] [datetime] NOT NULL,
	[Zone] [nvarchar](150) NULL,
	[Device] [nvarchar](150) NULL,
	[ZoneGeo] [geometry] NULL,
	[AlertName_En] [nvarchar](100) NULL,
	[AlertName_Ar] [nvarchar](100) NULL,
	[Icon] [nvarchar](150) NULL,
	[Color] [nvarchar](50) NULL,
	[CreationDate] [datetime] NULL,
	[Groups_en] [nvarchar](150) NULL,
	[Groups_Ar] [nvarchar](150) NULL,
	[GroupsIDs] [nvarchar](50) NULL,
	[PlateNumber] [nvarchar](10) NULL,
	[License] [nvarchar](10) NULL,
	[Resource_DBID] [int] NULL,
	[Resource_Type_DBID] [int] NULL,
	[Resource_Type_EnDesc] [nvarchar](100) NULL,
	[Resource_Type_ArDesc] [nvarchar](100) NULL,
	[Device_Type_DBID] [int] NULL,
	[X_Coord] [float] NULL,
	[Y_Coord] [float] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Alerts]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Alerts](
	[Alert_DBID] [int] IDENTITY(1,1) NOT NULL,
	[Name_Ar] [nvarchar](100) NULL,
	[Name_En] [nvarchar](100) NULL,
	[Icon] [nvarchar](150) NULL,
	[Color] [nvarchar](50) NULL,
	[Created_By] [int] NULL,
	[Modified_By] [int] NULL,
	[Creation_Date] [datetime] NULL,
	[Modification_Date] [datetime] NULL,
	[IsRetired] [bit] NULL CONSTRAINT [DF__Alerts__IsRetire__0CBAE877]  DEFAULT ((0)),
	[DeviceType_DBID] [int] NULL,
 CONSTRAINT [PK_Alerts] PRIMARY KEY CLUSTERED 
(
	[Alert_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DeviceType_SensorsConfig]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DeviceType_SensorsConfig](
	[DeviceType_DBID] [int] NULL,
	[SensorConfig_DBID] [int] NULL,
	[Comments] [nvarchar](100) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Resource_Execluded_Alerts]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Resource_Execluded_Alerts](
	[ResExAlerts_DBID] [int] IDENTITY(1,1) NOT NULL,
	[Resource_DBID] [int] NOT NULL,
	[Alert_DBID] [int] NOT NULL,
	[Created_By] [int] NULL,
	[Modified_By] [int] NULL,
	[Creation_Date] [datetime] NULL,
	[Modification_Date] [datetime] NULL,
 CONSTRAINT [PK_Resource_Execluded_Alerts_1] PRIMARY KEY CLUSTERED 
(
	[ResExAlerts_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UQ_Resource_Execluded_Alerts] UNIQUE NONCLUSTERED 
(
	[Resource_DBID] ASC,
	[Alert_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Resource_Execluded_Sensors]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Resource_Execluded_Sensors](
	[ResExSensor_DBID] [int] IDENTITY(1,1) NOT NULL,
	[Resource_DBID] [int] NOT NULL,
	[Sensor_DBID] [int] NOT NULL,
	[Created_By] [int] NULL,
	[Creation_Date] [datetime] NULL,
	[Modified_By] [int] NULL,
	[Modification_Date] [datetime] NULL,
 CONSTRAINT [PK_Resource_Execluded_Sensors] PRIMARY KEY CLUSTERED 
(
	[ResExSensor_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UQ_Resource_Execluded_Sensors] UNIQUE NONCLUSTERED 
(
	[Resource_DBID] ASC,
	[Sensor_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ResourceGroup_FenceLayer_Ass]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ResourceGroup_FenceLayer_Ass](
	[ResourceGroup_FenceLayer_DBID] [int] IDENTITY(1,1) NOT NULL,
	[ResourceGroup_DBID] [int] NULL,
	[FenceLayer_DBID] [int] NULL,
	[Created_By] [int] NULL,
	[Modified_By] [int] NULL,
	[Creation_Date] [datetime] NULL,
	[Modification_Date] [datetime] NULL,
	[IsRetired] [bit] NULL,
 CONSTRAINT [PK_ResourceGroup_FenceLayer_Ass] PRIMARY KEY CLUSTERED 
(
	[ResourceGroup_FenceLayer_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UQ_ResourceGroup_FenceLayer_Ass_ResourceGroup_FenceLayer_DBID] UNIQUE NONCLUSTERED 
(
	[ResourceGroup_FenceLayer_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Sensor_Configuration]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sensor_Configuration](
	[SensorConfig_DBID] [int] IDENTITY(1,1) NOT NULL,
	[Sensor_DBID] [int] NULL,
	[MaxValue] [float] NULL,
	[MinValue] [float] NULL,
	[TextValue] [nvarchar](100) NULL,
	[Icon] [nvarchar](100) NULL,
	[Color] [nvarchar](50) NULL,
	[Config_Text] [nvarchar](100) NULL,
	[Created_By] [int] NULL,
	[Modified_By] [int] NULL,
	[Creation_Date] [datetime] NULL,
	[Modification_Date] [datetime] NULL,
	[IsRetired] [bit] NULL CONSTRAINT [DF__Sensor_Co__IsRet__1920BF5C]  DEFAULT ((0)),
	[ShowOnMap] [bit] NULL CONSTRAINT [DF__Sensor_Co__ShowO__1A14E395]  DEFAULT ((0)),
	[Map_Rep_Indicator_En] [nvarchar](1) NULL,
	[Map_Rep_Indicator_Ar] [nvarchar](1) NULL,
	[Config_Text_Arabic] [nvarchar](100) NULL,
 CONSTRAINT [PK_Sensor_Configuration] PRIMARY KEY CLUSTERED 
(
	[SensorConfig_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Sensor_Types]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sensor_Types](
	[Sensor_Type_DBID] [int] IDENTITY(1,1) NOT NULL,
	[SensorType_Description] [nvarchar](50) NULL,
 CONSTRAINT [PK_Sensor_Types] PRIMARY KEY CLUSTERED 
(
	[Sensor_Type_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UQ_Sensor_Types_Sensor_Type_DBID] UNIQUE NONCLUSTERED 
(
	[Sensor_Type_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Sensors]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sensors](
	[Sensor_DBID] [int] IDENTITY(1,1) NOT NULL,
	[Sensor_Type_DBID] [int] NULL,
	[DeviceType_DBID] [int] NULL,
	[Name_Ar] [nvarchar](100) NULL,
	[Name_En] [nvarchar](100) NULL,
	[Created_By] [int] NULL,
	[Modified_By] [int] NULL,
	[Creation_Date] [datetime] NULL,
	[Modification_Date] [datetime] NULL,
	[IsRetired] [bit] NULL CONSTRAINT [DF__Sensors__IsRetir__1CF15040]  DEFAULT ((0)),
 CONSTRAINT [PK_Sensors] PRIMARY KEY CLUSTERED 
(
	[Sensor_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Sensors_LiveFeeds]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sensors_LiveFeeds](
	[Sensor_LiveFeeds_DBID] [int] NOT NULL,
	[Device_DBID] [int] NULL,
	[Device] [nvarchar](150) NULL,
	[SensorConfigDBID] [int] NULL,
	[Sensor_Value] [nvarchar](50) NULL,
	[Sensor_DateTime] [datetime] NULL,
	[Sensor_EnDesc] [nvarchar](150) NULL,
	[Sensor_ArDesc] [nvarchar](150) NULL,
 CONSTRAINT [PK_Sensors_LiveFeeds] PRIMARY KEY CLUSTERED 
(
	[Sensor_LiveFeeds_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UQ_Sensors_LiveFeeds_Sensor_LiveFeeds_DBID] UNIQUE NONCLUSTERED 
(
	[Sensor_LiveFeeds_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Sensors_LiveFeedsHistory]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sensors_LiveFeedsHistory](
	[Sensor_LiveFeeds_DBID] [int] NOT NULL,
	[Device_DBID] [int] NULL,
	[Device] [nvarchar](150) NULL,
	[SensorConfigDBID] [int] NULL,
	[Sensor_Value] [nvarchar](50) NULL,
	[Sensor_DateTime] [datetime] NULL,
	[Sensor_EnDesc] [nvarchar](150) NULL,
	[Sensor_ArDesc] [nvarchar](150) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[sequence_store]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[sequence_store](
	[seq_name] [varchar](255) NOT NULL,
	[seq_value] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[seq_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tracking_Alert_Sensor_LiveFeeds]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tracking_Alert_Sensor_LiveFeeds](
	[Sensor_LiveFeeds_DBID] [int] NULL,
	[Alert_LiveFeeds_DBID] [int] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tracking_Crew]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tracking_Crew](
	[Crew_DBID] [int] IDENTITY(1,1) NOT NULL,
	[Crew_Name_Ar] [nvarchar](150) NULL,
	[DriverLicense] [nvarchar](50) NULL,
	[Crew_Name_En] [nchar](150) NULL,
	[Created_By] [int] NULL,
	[Creation_Date] [datetime] NULL,
	[Modified_By] [int] NULL,
	[Modification_Date] [datetime] NULL,
	[Phone_Number] [nvarchar](15) NULL,
	[Nationality] [nvarchar](50) NULL,
	[Gender] [int] NULL,
 CONSTRAINT [PK_Crew] PRIMARY KEY CLUSTERED 
(
	[Crew_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tracking_Device_Types]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tracking_Device_Types](
	[DeviceType_DBID] [int] IDENTITY(1,1) NOT NULL,
	[DeviceType_Desc] [nvarchar](150) NULL,
	[Creation_Date] [datetime] NULL,
	[Created_By] [int] NULL,
	[Modified_By] [int] NULL,
	[Modification_Date] [datetime] NULL,
	[IsRetired] [bit] NULL CONSTRAINT [DF__Tracking___IsRet__20C1E124]  DEFAULT ((0)),
 CONSTRAINT [PK_Feeds_DevicesTypes] PRIMARY KEY CLUSTERED 
(
	[DeviceType_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tracking_Devices]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tracking_Devices](
	[Device_DBID] [int] IDENTITY(1,1) NOT NULL,
	[DeviceType_DBID] [int] NULL,
	[SIM_Card_Number] [nvarchar](50) NULL,
	[Creation_Date] [datetime] NULL,
	[Modification_Date] [datetime] NULL,
	[Created_By] [int] NULL,
	[Modified_By] [int] NULL,
	[Serial] [nvarchar](50) NULL,
	[IsRetired] [bit] NULL CONSTRAINT [DF__Tracking___IsRet__22AA2996]  DEFAULT ((0)),
 CONSTRAINT [PK_Devices] PRIMARY KEY CLUSTERED 
(
	[Device_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tracking_Fence_Layers]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tracking_Fence_Layers](
	[FenceLayer_DBID] [int] IDENTITY(1,1) NOT NULL,
	[Layer_Name] [nvarchar](100) NULL,
	[Layer_URL] [nvarchar](250) NULL,
	[Created_By] [int] NULL,
	[Modified_By] [int] NULL,
	[Creation_Date] [datetime] NULL,
	[Modification_Date] [datetime] NULL,
 CONSTRAINT [PK_Fence_Layers_List] PRIMARY KEY CLUSTERED 
(
	[FenceLayer_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UQ_Fence_Layers_List_FenceLayer_DBID] UNIQUE NONCLUSTERED 
(
	[FenceLayer_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tracking_ResGroup_Fences_Ass]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tracking_ResGroup_Fences_Ass](
	[ResourceGroup_FenceLayer_DBID] [int] IDENTITY(1,1) NOT NULL,
	[ResourceGroup_DBID] [int] NULL,
	[Fence_ID] [int] NULL,
	[Creation_Date] [datetime] NULL,
	[Modification_Date] [datetime] NULL,
	[Created_By] [int] NULL,
	[Modified_By] [int] NULL,
	[IsRetired] [bit] NULL,
	[GeoFenceRule] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_ResourceGroup_Fences_Ass] PRIMARY KEY CLUSTERED 
(
	[ResourceGroup_FenceLayer_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UQ_ResourceGroup_Fences_Ass_ResourceGroup_FenceLayer_DBID] UNIQUE NONCLUSTERED 
(
	[ResourceGroup_FenceLayer_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tracking_Resource_Crew]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tracking_Resource_Crew](
	[Resource_Crew_DBID] [int] IDENTITY(1,1) NOT NULL,
	[Resource_DBID] [int] NULL,
	[Crew_DBID] [int] NULL,
	[Is_Driver] [bit] NULL CONSTRAINT [DF_Tracking_Resource_Crew_Is_Driver]  DEFAULT ((0)),
	[Create_By] [int] NULL,
	[Creation_Date] [datetime] NULL,
	[Modified_By] [int] NULL,
	[Modification_Date] [datetime] NULL,
	[IsRetired] [bit] NULL CONSTRAINT [DF__Tracking___IsRet__25869641]  DEFAULT ((0)),
 CONSTRAINT [PK_Resource_Crew] PRIMARY KEY CLUSTERED 
(
	[Resource_Crew_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UQ_Resource_Crew_Resource_Crew_DBID] UNIQUE NONCLUSTERED 
(
	[Resource_Crew_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tracking_Resource_Groups]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tracking_Resource_Groups](
	[ResourceGroup_DBID] [int] IDENTITY(1,1) NOT NULL,
	[ParentResourceGroup_DBID] [int] NULL,
	[FenceLayer_DBID] [int] NULL,
	[Description_En] [nvarchar](150) NULL,
	[Description_Ar] [nvarchar](150) NULL,
	[Creation_Date] [datetime] NULL,
	[Modification_Date] [datetime] NULL,
	[Modified_By] [int] NULL,
	[Created_By] [int] NULL,
	[Res_Group_Image] [nvarchar](150) NULL,
	[Name_En] [nvarchar](70) NULL,
	[Name_Ar] [nvarchar](70) NULL,
	[VisibleForParent] [bit] NULL,
	[IsRetired] [bit] NULL,
 CONSTRAINT [PK_ResourceGroups] PRIMARY KEY CLUSTERED 
(
	[ResourceGroup_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tracking_Resource_LFHistory]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tracking_Resource_LFHistory](
	[Device_DBID] [int] NULL,
	[Device] [nvarchar](150) NULL,
	[Resource_DBID] [int] NULL,
	[PlateNumber] [nvarchar](10) NULL,
	[License] [nvarchar](10) NULL,
	[Resource_Type_DBID] [int] NULL,
	[Resource_Type_EnDesc] [nvarchar](100) NULL,
	[Resource_Type_ArDesc] [nvarchar](100) NULL,
	[X_Coord] [float] NULL,
	[Y_Coord] [float] NULL,
	[Speed] [int] NULL,
	[Heading] [float] NULL,
	[Zone] [nvarchar](150) NULL,
	[ZoneGeo] [geometry] NULL,
	[GroupsIDs] [nvarchar](50) NULL,
	[Groups_en] [nvarchar](150) NULL,
	[Groups_Ar] [nvarchar](10) NULL,
	[FeedDateTime] [datetime] NOT NULL,
	[Creation_Datetime] [datetime] NULL,
	[Device_Type_DBID] [int] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tracking_Resource_LiveFeeds]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tracking_Resource_LiveFeeds](
	[Device_DBID] [int] NOT NULL,
	[Device] [nvarchar](150) NULL,
	[Resource_DBID] [int] NULL,
	[PlateNumber] [nvarchar](10) NULL,
	[License] [nvarchar](10) NULL,
	[Resource_Type_DBID] [int] NULL,
	[Resource_Type_EnDesc] [nvarchar](100) NULL,
	[Resource_Type_ArDesc] [nvarchar](100) NULL,
	[Resource_Type_Image] [nvarchar](150) NULL,
	[Resource_Type_Img_Top] [nvarchar](150) NULL,
	[X_Coord] [float] NULL,
	[Y_Coord] [float] NULL,
	[Speed] [int] NULL,
	[Heading] [float] NULL,
	[Zone] [nvarchar](150) NULL,
	[ZoneGeo] [geometry] NULL,
	[GroupsIDs] [nvarchar](50) NULL,
	[Groups_en] [nvarchar](150) NULL,
	[Groups_Ar] [nvarchar](10) NULL,
	[FeedDateTime] [datetime] NOT NULL,
	[Creation_Datetime] [datetime] NULL,
	[Device_Type_DBID] [int] NULL,
	[Resource_livefeeds_DBID] [int] NULL,
 CONSTRAINT [PK_Tracking_Resource_LiveFeeds] PRIMARY KEY CLUSTERED 
(
	[Device_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tracking_Resource_ResGroup_Ass]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tracking_Resource_ResGroup_Ass](
	[Track_Resource_ResGrp_DBID] [int] NOT NULL,
	[Resource_DBID] [int] NOT NULL,
	[ResourceGroup_DBID] [int] NOT NULL,
	[Creation_Date] [datetime] NULL,
	[Created_By] [int] NULL,
	[Modification_Date] [datetime] NULL,
	[Modified_By] [int] NULL,
	[IsRetired] [bit] NULL CONSTRAINT [DF__Tracking___IsRet__29572725]  DEFAULT ((0)),
 CONSTRAINT [PK_Tracking_Resource_ResourceGroup_Ass] PRIMARY KEY CLUSTERED 
(
	[Track_Resource_ResGrp_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tracking_Resource_Types]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tracking_Resource_Types](
	[Resource_Type_DBID] [int] IDENTITY(1,1) NOT NULL,
	[Name_Ar] [nvarchar](100) NULL,
	[Name_En] [nvarchar](100) NULL,
	[Tracking_Res_Image] [nvarchar](150) NULL,
	[Modified_By] [int] NULL,
	[Created_By] [int] NULL,
	[Creation_Date] [datetime] NULL,
	[Modification_date] [datetime] NULL,
	[Tracking_Res_Image_Top] [nvarchar](150) NULL,
 CONSTRAINT [PK_Resource_Types] PRIMARY KEY CLUSTERED 
(
	[Resource_Type_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tracking_ResourceGroup_GeoRole]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tracking_ResourceGroup_GeoRole](
	[Tracking_ResGrp_GeoRole_DBID] [int] IDENTITY(1,1) NOT NULL,
	[GEO_RoleID] [float] NOT NULL,
	[ResourceGroup_DBID] [int] NOT NULL,
	[Creation_Date] [datetime] NULL,
	[Modification_Date] [datetime] NULL,
	[Created_By] [int] NULL,
	[Modified_By] [int] NULL,
	[IsRetired] [bit] NULL CONSTRAINT [DF__Tracking___IsRet__2E1BDC42]  DEFAULT ((0)),
	[IsOwner] [bit] NOT NULL CONSTRAINT [DF_Tracking_ResourceGroup_GeoRole_IsOwner]  DEFAULT ((0)),
 CONSTRAINT [PK_Tracking_ResourceGroup_GeoRole] PRIMARY KEY CLUSTERED 
(
	[Tracking_ResGrp_GeoRole_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Tracking_Resources]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tracking_Resources](
	[Resource_DBID] [int] IDENTITY(1,1) NOT NULL,
	[Device_DBID] [int] NOT NULL,
	[Resource_Type_DBID] [int] NULL,
	[Resource_Desc] [nvarchar](150) NULL,
	[PlateNumber] [nvarchar](10) NULL,
	[License] [nvarchar](10) NULL,
	[Created_By] [int] NULL,
	[Modified_By] [int] NULL,
	[Creation_Date] [datetime] NULL,
	[Modification_Date] [datetime] NULL,
	[IsRetired] [bit] NULL CONSTRAINT [DF__Tracking___IsRet__300424B4]  DEFAULT ((0)),
	[Description_Ar] [nvarchar](150) NULL,
	[Description_En] [nvarchar](150) NULL,
 CONSTRAINT [PK_Resources] PRIMARY KEY CLUSTERED 
(
	[Resource_DBID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TRACKING_ROLES]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TRACKING_ROLES](
	[Tracking_ROLE_ID] [int] NOT NULL,
	[GROUP_ROLE_OPER_ID] [numeric](38, 0) NOT NULL,
	[Enable_Feeds] [numeric](1, 0) NOT NULL CONSTRAINT [DF_TRACKING_ROLES_Enable_Feeds]  DEFAULT ((0)),
	[Enable_Alerts] [numeric](1, 0) NOT NULL CONSTRAINT [DF_TRACKING_ROLES_Enable_Alerts]  DEFAULT ((0)),
	[Enable_Playback] [numeric](1, 0) NOT NULL CONSTRAINT [DF_TRACKING_ROLES_Enable_Playback]  DEFAULT ((0)),
	[Enable_Reports] [numeric](1, 0) NOT NULL CONSTRAINT [DF_TRACKING_ROLES_Enable_Reports]  DEFAULT ((0)),
	[Default_Refresh_Rate] [int] NOT NULL,
	[Map_Label_Fields] [nchar](500) NOT NULL,
	[Enable_FleetGroups] [numeric](1, 0) NULL,
	[Enable_GPSDevices] [numeric](1, 0) NULL,
	[Enable_Assignment] [numeric](1, 0) NULL,
	[Enable_ChildGroupUpdates] [numeric](1, 0) NULL,
	[Enable_Master] [numeric](1, 0) NULL,
	[Trailer_Point_Count] [int] NULL,
	[Alerts_Last_Hours] [int] NULL,
 CONSTRAINT [PK_TRACKING_ROLES] PRIMARY KEY CLUSTERED 
(
	[Tracking_ROLE_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[User_Saved_AlertSettings]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User_Saved_AlertSettings](
	[UserId] [int] NOT NULL,
	[RoleId] [int] NOT NULL,
	[FilterCriteria] [nvarchar](max) NULL,
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NULL,
 CONSTRAINT [PK_SavedAlertFilter_1] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
ALTER TABLE [dbo].[ResourceGroup_FenceLayer_Ass] ADD  CONSTRAINT [DF__ResourceG__IsRet__173876EA]  DEFAULT ((0)) FOR [IsRetired]
GO
ALTER TABLE [dbo].[Tracking_ResGroup_Fences_Ass] ADD  CONSTRAINT [DF__Tracking___IsRet__2C3393D0]  DEFAULT ((0)) FOR [IsRetired]
GO
ALTER TABLE [dbo].[Tracking_ResGroup_Fences_Ass] ADD  CONSTRAINT [DF_Tracking_ResGroup_Fences_Ass_GeoFenceRule]  DEFAULT (N'in') FOR [GeoFenceRule]
GO
ALTER TABLE [dbo].[Alert_Configuration]  WITH CHECK ADD  CONSTRAINT [FK_Alert_Configuration_Alerts] FOREIGN KEY([Alert_DBID])
REFERENCES [dbo].[Alerts] ([Alert_DBID])
GO
ALTER TABLE [dbo].[Alert_Configuration] CHECK CONSTRAINT [FK_Alert_Configuration_Alerts]
GO
ALTER TABLE [dbo].[Alert_Configuration]  WITH CHECK ADD  CONSTRAINT [FK_Alert_Configuration_Sensor_Configuration] FOREIGN KEY([SensorConfig_DBID])
REFERENCES [dbo].[Sensor_Configuration] ([SensorConfig_DBID])
GO
ALTER TABLE [dbo].[Alert_Configuration] CHECK CONSTRAINT [FK_Alert_Configuration_Sensor_Configuration]
GO
ALTER TABLE [dbo].[Alerts]  WITH CHECK ADD FOREIGN KEY([DeviceType_DBID])
REFERENCES [dbo].[Tracking_Device_Types] ([DeviceType_DBID])
GO
ALTER TABLE [dbo].[DeviceType_SensorsConfig]  WITH CHECK ADD  CONSTRAINT [FK_DeviceType_SensorsConfiguration_DeviceType] FOREIGN KEY([DeviceType_DBID])
REFERENCES [dbo].[Tracking_Device_Types] ([DeviceType_DBID])
GO
ALTER TABLE [dbo].[DeviceType_SensorsConfig] CHECK CONSTRAINT [FK_DeviceType_SensorsConfiguration_DeviceType]
GO
ALTER TABLE [dbo].[DeviceType_SensorsConfig]  WITH CHECK ADD  CONSTRAINT [FK_DeviceType_SensorsConfiguration_SensorsConfiguration] FOREIGN KEY([SensorConfig_DBID])
REFERENCES [dbo].[Sensor_Configuration] ([SensorConfig_DBID])
GO
ALTER TABLE [dbo].[DeviceType_SensorsConfig] CHECK CONSTRAINT [FK_DeviceType_SensorsConfiguration_SensorsConfiguration]
GO
ALTER TABLE [dbo].[Resource_Execluded_Alerts]  WITH CHECK ADD  CONSTRAINT [FK_Resource_Execluded_Alerts_Alerts] FOREIGN KEY([Alert_DBID])
REFERENCES [dbo].[Alerts] ([Alert_DBID])
GO
ALTER TABLE [dbo].[Resource_Execluded_Alerts] CHECK CONSTRAINT [FK_Resource_Execluded_Alerts_Alerts]
GO
ALTER TABLE [dbo].[Resource_Execluded_Alerts]  WITH CHECK ADD  CONSTRAINT [FK_Resource_Execluded_Alerts_Resource] FOREIGN KEY([Resource_DBID])
REFERENCES [dbo].[Tracking_Resources] ([Resource_DBID])
GO
ALTER TABLE [dbo].[Resource_Execluded_Alerts] CHECK CONSTRAINT [FK_Resource_Execluded_Alerts_Resource]
GO
ALTER TABLE [dbo].[Resource_Execluded_Sensors]  WITH CHECK ADD  CONSTRAINT [FK_Resource_Execluded_Sensors_Resource] FOREIGN KEY([Resource_DBID])
REFERENCES [dbo].[Tracking_Resources] ([Resource_DBID])
GO
ALTER TABLE [dbo].[Resource_Execluded_Sensors] CHECK CONSTRAINT [FK_Resource_Execluded_Sensors_Resource]
GO
ALTER TABLE [dbo].[Resource_Execluded_Sensors]  WITH CHECK ADD  CONSTRAINT [FK_Resource_Execluded_Sensors_Sensors] FOREIGN KEY([Sensor_DBID])
REFERENCES [dbo].[Sensors] ([Sensor_DBID])
GO
ALTER TABLE [dbo].[Resource_Execluded_Sensors] CHECK CONSTRAINT [FK_Resource_Execluded_Sensors_Sensors]
GO
ALTER TABLE [dbo].[ResourceGroup_FenceLayer_Ass]  WITH CHECK ADD  CONSTRAINT [FK_ResourceGroup_FenceLayer_Ass_FenceLayer] FOREIGN KEY([FenceLayer_DBID])
REFERENCES [dbo].[Tracking_Fence_Layers] ([FenceLayer_DBID])
GO
ALTER TABLE [dbo].[ResourceGroup_FenceLayer_Ass] CHECK CONSTRAINT [FK_ResourceGroup_FenceLayer_Ass_FenceLayer]
GO
ALTER TABLE [dbo].[ResourceGroup_FenceLayer_Ass]  WITH CHECK ADD  CONSTRAINT [FK_ResourceGroup_FenceLayer_Ass_ResourceGroup] FOREIGN KEY([ResourceGroup_DBID])
REFERENCES [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID])
GO
ALTER TABLE [dbo].[ResourceGroup_FenceLayer_Ass] CHECK CONSTRAINT [FK_ResourceGroup_FenceLayer_Ass_ResourceGroup]
GO
ALTER TABLE [dbo].[Sensor_Configuration]  WITH CHECK ADD  CONSTRAINT [FK_Sensor_Configuration_Sensors] FOREIGN KEY([Sensor_DBID])
REFERENCES [dbo].[Sensors] ([Sensor_DBID])
GO
ALTER TABLE [dbo].[Sensor_Configuration] CHECK CONSTRAINT [FK_Sensor_Configuration_Sensors]
GO
ALTER TABLE [dbo].[Sensors]  WITH CHECK ADD  CONSTRAINT [FK_Sensors_Sensor_Types] FOREIGN KEY([Sensor_Type_DBID])
REFERENCES [dbo].[Sensor_Types] ([Sensor_Type_DBID])
GO
ALTER TABLE [dbo].[Sensors] CHECK CONSTRAINT [FK_Sensors_Sensor_Types]
GO
ALTER TABLE [dbo].[Sensors]  WITH CHECK ADD  CONSTRAINT [FK_Sensors_Tracking_Device_Types] FOREIGN KEY([DeviceType_DBID])
REFERENCES [dbo].[Tracking_Device_Types] ([DeviceType_DBID])
GO
ALTER TABLE [dbo].[Sensors] CHECK CONSTRAINT [FK_Sensors_Tracking_Device_Types]
GO
ALTER TABLE [dbo].[Tracking_Devices]  WITH CHECK ADD  CONSTRAINT [FK_Tracking_Devices_DeviceTypes] FOREIGN KEY([DeviceType_DBID])
REFERENCES [dbo].[Tracking_Device_Types] ([DeviceType_DBID])
GO
ALTER TABLE [dbo].[Tracking_Devices] CHECK CONSTRAINT [FK_Tracking_Devices_DeviceTypes]
GO
ALTER TABLE [dbo].[Tracking_ResGroup_Fences_Ass]  WITH CHECK ADD  CONSTRAINT [FK_Tracking_ResourceGroup_Fences_Ass_ResourceGroup] FOREIGN KEY([ResourceGroup_DBID])
REFERENCES [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID])
GO
ALTER TABLE [dbo].[Tracking_ResGroup_Fences_Ass] CHECK CONSTRAINT [FK_Tracking_ResourceGroup_Fences_Ass_ResourceGroup]
GO
ALTER TABLE [dbo].[Tracking_Resource_Crew]  WITH CHECK ADD  CONSTRAINT [FK_Tracking_Resource_Crew_Crew] FOREIGN KEY([Crew_DBID])
REFERENCES [dbo].[Tracking_Crew] ([Crew_DBID])
GO
ALTER TABLE [dbo].[Tracking_Resource_Crew] CHECK CONSTRAINT [FK_Tracking_Resource_Crew_Crew]
GO
ALTER TABLE [dbo].[Tracking_Resource_Crew]  WITH CHECK ADD  CONSTRAINT [FK_Tracking_Resource_Crew_Resource] FOREIGN KEY([Resource_DBID])
REFERENCES [dbo].[Tracking_Resources] ([Resource_DBID])
GO
ALTER TABLE [dbo].[Tracking_Resource_Crew] CHECK CONSTRAINT [FK_Tracking_Resource_Crew_Resource]
GO
ALTER TABLE [dbo].[Tracking_Resource_Groups]  WITH CHECK ADD  CONSTRAINT [FK_Tracking_Resource_Groups_FenceLayer] FOREIGN KEY([FenceLayer_DBID])
REFERENCES [dbo].[Tracking_Fence_Layers] ([FenceLayer_DBID])
GO
ALTER TABLE [dbo].[Tracking_Resource_Groups] CHECK CONSTRAINT [FK_Tracking_Resource_Groups_FenceLayer]
GO
ALTER TABLE [dbo].[Tracking_Resource_Groups]  WITH NOCHECK ADD  CONSTRAINT [FK_Tracking_Resource_Groups_Tracking_Resource_Groups] FOREIGN KEY([ParentResourceGroup_DBID])
REFERENCES [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID])
GO
ALTER TABLE [dbo].[Tracking_Resource_Groups] NOCHECK CONSTRAINT [FK_Tracking_Resource_Groups_Tracking_Resource_Groups]
GO
ALTER TABLE [dbo].[Tracking_Resource_ResGroup_Ass]  WITH CHECK ADD  CONSTRAINT [FK_Tracking_Resource_ResourceGroup_Ass_Resource] FOREIGN KEY([Resource_DBID])
REFERENCES [dbo].[Tracking_Resources] ([Resource_DBID])
GO
ALTER TABLE [dbo].[Tracking_Resource_ResGroup_Ass] CHECK CONSTRAINT [FK_Tracking_Resource_ResourceGroup_Ass_Resource]
GO
ALTER TABLE [dbo].[Tracking_Resource_ResGroup_Ass]  WITH CHECK ADD  CONSTRAINT [FK_Tracking_Resource_ResourceGroup_Ass_ResourceGroup] FOREIGN KEY([ResourceGroup_DBID])
REFERENCES [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID])
GO
ALTER TABLE [dbo].[Tracking_Resource_ResGroup_Ass] CHECK CONSTRAINT [FK_Tracking_Resource_ResourceGroup_Ass_ResourceGroup]
GO
ALTER TABLE [dbo].[Tracking_ResourceGroup_GeoRole]  WITH CHECK ADD  CONSTRAINT [FK_Tracking_ResourceGroup_GeoRole_ResourceGroup] FOREIGN KEY([ResourceGroup_DBID])
REFERENCES [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID])
GO
ALTER TABLE [dbo].[Tracking_ResourceGroup_GeoRole] CHECK CONSTRAINT [FK_Tracking_ResourceGroup_GeoRole_ResourceGroup]
GO
ALTER TABLE [dbo].[Tracking_Resources]  WITH CHECK ADD  CONSTRAINT [FK_Tracking_Resources_Devices] FOREIGN KEY([Device_DBID])
REFERENCES [dbo].[Tracking_Devices] ([Device_DBID])
GO
ALTER TABLE [dbo].[Tracking_Resources] CHECK CONSTRAINT [FK_Tracking_Resources_Devices]
GO
ALTER TABLE [dbo].[Tracking_Resources]  WITH CHECK ADD  CONSTRAINT [FK_Tracking_Resources_ResourcesTypes] FOREIGN KEY([Resource_Type_DBID])
REFERENCES [dbo].[Tracking_Resource_Types] ([Resource_Type_DBID])
GO
ALTER TABLE [dbo].[Tracking_Resources] CHECK CONSTRAINT [FK_Tracking_Resources_ResourcesTypes]
GO
/****** Object:  StoredProcedure [dbo].[SP_Get_Group_AlertLiveFeeds]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Procedure [dbo].[SP_Get_Group_AlertLiveFeeds] 
(@GroupIds nvarchar(max) ,
 @license nvarchar(10) =  null,
 @PlateNumber nvarchar(10) = null,
 @DeviceType int= null,
 @Zone nvarchar(150) = null,
 @fromdate1 datetime = null, @todate1 datetime= null,
 @fromdate2 datetime = null, @todate2 datetime= null  ) 
/*RETURNS @OUTTABLE TABLE ( 
    [Alert_LiveFeeds_DBID] int ,
	[Device_DBID] int,
	[Alert_DBID] int,
	[Alert_DateTime] datetime,
	[Zone] nvarchar(150) ,
	[Device] nvarchar(150) ,
	[ZoneGeo] geometry ,
	[AlertName_En] nvarchar(100) ,
	[AltertName_Ar] nvarchar(100),
	[Icon] nvarchar(150) ,
	[Color] nvarchar(50) ,
	[CreationDate] datetime,
	[Groups_en] nvarchar(150) ,
	[Groups_Ar] nvarchar(150) ,
	[GroupsIDs] nvarchar(50),
	[PlateNumber] nvarchar(10) ,
	[License] nvarchar(10) ,
	[Resource_DBID] int ,
	[Resource_Type_DBID] int,
	[Resource_Type_EnDesc] nvarchar(100) ,
	[Resource_Type_ArDesc] nvarchar(100) 
)*/
AS 

BEGIN  /*PROCEDURE BEGIN*/

create table #Table ( RowID int not null primary key identity(1,1), grpid nvarchar(max) )
create TABLE #OUTTABLE  ( 
    [Alert_LiveFeeds_DBID] int ,
	[Device_DBID] int,
	[Alert_DBID] int,
	[Alert_DateTime] datetime,
	[Zone] nvarchar(150) ,
	[Device_Type_DBID] int,
	[Device] nvarchar(150) ,
	[ZoneGeo] geometry ,
	[AlertName_En] nvarchar(100) ,
	[AlertName_Ar] nvarchar(100),
	[Icon] nvarchar(150) ,
	[Color] nvarchar(50) ,
	[CreationDate] datetime,
	[Groups_en] nvarchar(150) ,
	[Groups_Ar] nvarchar(150) ,
	[GroupsIDs] nvarchar(50),
	[PlateNumber] nvarchar(10) ,
	[License] nvarchar(10) ,
	[Resource_DBID] int ,
	[Resource_Type_DBID] int,
	[Resource_Type_EnDesc] nvarchar(100) ,
	[Resource_Type_ArDesc] nvarchar(100) 
)
declare @RowsToProcess integer = 0,
@CurrentRow integer = 0,
@Grpcondition nvarchar(max)= '',
@grpid nvarchar(50),
@Curs_grpid nvarchar(50), 
@licenseCondition nvarchar(max),
@PlateNumberCondition nvarchar(max),
@zoneCondition nvarchar(max),
@DeviceCondition nvarchar(max),
@Date1Condition nvarchar(max),
@Date2Condition nvarchar(max),
@QUERY NVARCHAR(MAX),
@QUERY1 NVARCHAR(MAX),
@QUERY2 NVARCHAR(MAX),
@fromdate11 NVARCHAR(50) , @todate11 NVARCHAR(50),
@fromdate22 NVARCHAR(50) , @todate22 NVARCHAR(50) 



        Begin 
		INSERT #Table (grpid)
		SELECT * 
		FROM [dbo].[Split]( @GroupIds,',');-- SPLIT THE SEARCH STRING INTO WORDS
		SET @RowsToProcess=@@ROWCOUNT
		SET @CurrentRow=0
		
		WHILE @CurrentRow<@RowsToProcess     
				 begin 
				   SET @CurrentRow=@CurrentRow+1  
				   SELECT @grpid=grpid
				   FROM #Table
				   WHERE RowID=@CurrentRow;
				   set @Grpcondition = @Grpcondition+' OR  ('+@grpid+' ) in ( select * from [dbo].[Split]( GroupsIDs,'','') ) ';
				 end ;
		IF @Grpcondition is not null 
		begin
		 set @Grpcondition = ' And ( '+substring(@Grpcondition,5,len(@Grpcondition))+' ) ';-- THIS CONDTION STRING WILL BE OR (..... AND ....) 		 
        end;
		else 
		begin
			select @Grpcondition = ' '		
		end;	

		End;  
        print @Grpcondition
        
begin 
 if @license is not null 
 begin
  select @licenseCondition = ' And license like ''%'+@license+'%'''
 end; 
 else 
 select @licenseCondition = '' 
 
 
 if @PlateNumber is not null
 begin 
  select @PlateNumberCondition = ' And PlateNumber like ''%'+@PlateNumber+'%'''
 end;
 else 
 select @PlateNumberCondition =''
 
 
  if @Zone is not null
 begin 
  select @zoneCondition = ' And zone like ''%'+@Zone+'%'''
 end;
 else 
 select @zoneCondition =''
 
 if @DeviceType is not null
  begin 
  select @DeviceCondition = ' And Device_Type_DBID = '+convert(nvarchar,@DeviceType)
 end;
 else 
 select @DeviceCondition = ''
 
 select @fromdate11 = CONVERT(nvarchar,@fromdate1,121)
 select @todate11 = CONVERT(nvarchar,@todate1,121)
 select @fromdate22 = CONVERT(nvarchar,@fromdate2,121)
 select @todate22 = CONVERT(nvarchar,@todate2,121)
 
 
 if @fromdate1 is not null and @todate1 is not null
  begin 
  select @Date1Condition = ' And ( Alert_DateTime between convert(datetime,'''+@fromdate11+''' ,121) and convert(datetime,'''+@todate11+''',121))'
 end;
 else 
 select @Date1Condition = ''
 
 if @fromdate2 is not null and @todate2 is not null
  begin 
  select @Date2Condition = ' Or ( Alert_DateTime between convert(datetime,'''+@fromdate22+''' ,121) and convert(datetime,'''+@todate22+''',121))'
 end; 
 else 
 select @Date2Condition = ''
 end; 
  
  
  
 begin 
 select @QUERY = N'select * from (SELECT [Alert_LiveFeeds_DBID]  ,
	[Device_DBID] ,
	[Alert_DBID] ,
	[Alert_DateTime] ,
	[Zone]  ,
	[Device_Type_DBID],
	[Device]  ,
	[ZoneGeo]  ,
	[AlertName_En]  ,
	[AlertName_Ar] ,
	[Icon] ,
	[Color]  ,
	[CreationDate] ,
	[Groups_en]  ,
	[Groups_Ar]  ,
	[GroupsIDs] ,
	[PlateNumber]  ,
	[License] ,
	[Resource_DBID]  ,
	[Resource_Type_DBID] ,
	[Resource_Type_EnDesc]  ,
	[Resource_Type_ArDesc]   
FROM dbo.Alert_LiveFeeds WITH(NOLOCK) 
WHERE 1=1  '
+@Grpcondition +') x where 1=1'
+@licenseCondition
+@PlateNumberCondition
+@DeviceCondition
+@Date1Condition
+@Date2Condition
+ ' ORDER BY [Alert_DateTime] DESC'

end;
  
print @QUERY

INSERT #OUTTABLE
EXEC sp_executeSQL @QUERY
  
select *
from #OUTTABLE  
  
return
End;

GO
/****** Object:  StoredProcedure [dbo].[SP_Get_Group_LiveFeeds]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Procedure [dbo].[SP_Get_Group_LiveFeeds] 
(@GroupIds nvarchar(max) = null ) 
AS 

BEGIN  /*PROCEDURE BEGIN*/

create table #Table ( RowID int not null primary key identity(1,1), grpid nvarchar(max) )
create TABLE #OUTTABLE  ( [Device_DBID] int ,
    [device_Type_DBID] int ,
	[Device] nvarchar(150) ,
	[Resource_DBID] int ,
	[PlateNumber] nvarchar(10) ,
	[License] nvarchar(10) ,
	[Resource_Type_DBID] int ,
	[Resource_Type_EnDesc] nvarchar(100) ,
	[Resource_Type_ArDesc] nvarchar(100) ,
	[X_Coord] float ,
	[Y_Coord] float ,
	[Speed] int ,
	[Heading] float ,
	[Zone] nvarchar(150) ,
	[ZoneGeo] geometry ,
	[GroupsIDs] nvarchar(50) ,
	[Groups_en] nvarchar(150) ,
	[Groups_Ar] nvarchar(10) ,
	[FeedDateTime] datetime ,
	[Creation_Datetime] datetime,
	[Resource_Type_Image] nvarchar(150) ,
	[Resource_Type_Img_Top] nvarchar(150)  )



declare @RowsToProcess integer = 0,
@CurrentRow integer = 0,
@Grpcondition nvarchar(max)= '',
@grpid nvarchar(50),
@Curs_grpid nvarchar(50) ,
@QUERY NVARCHAR(MAX) ;

if @GroupIds is not null 

        Begin 
		INSERT #Table (grpid)
		SELECT * 
		FROM [dbo].[Split]( @GroupIds,',');-- SPLIT THE SEARCH STRING INTO WORDS
		SET @RowsToProcess=@@ROWCOUNT
		SET @CurrentRow=0
		
		WHILE @CurrentRow<@RowsToProcess     
				 begin 
				   SET @CurrentRow=@CurrentRow+1  
				   SELECT @grpid=grpid
					FROM #Table
					WHERE RowID=@CurrentRow ;
				   set @Grpcondition = @Grpcondition+' OR  ('+@grpid+' ) in ( select * from [dbo].[Split]( GroupsIDs,'','') ) '
				 end ;
		IF @Grpcondition is not null 
		begin
		 set @Grpcondition = ' And  '+substring(@Grpcondition,5,len(@Grpcondition))/*+' ) '*/;-- THIS CONDTION STRING WILL BE OR (..... AND ....) 		 
        end;
		else 
		begin
			select @Grpcondition = ' '		
		end;	
		End;  		 
 
   print @Grpcondition
   
   
 Begin 
 select @QUERY = N'SELECT [Device_DBID]  ,
    [device_Type_DBID],
	[Device]  ,
	[Resource_DBID]  ,
	[PlateNumber]  ,
	[License]  ,
	[Resource_Type_DBID]  ,
	[Resource_Type_EnDesc]  ,
	[Resource_Type_ArDesc]  ,
	[X_Coord]  ,
	[Y_Coord]  ,
	[Speed]  ,
	[Heading]  ,
	[Zone]  ,
	[ZoneGeo]  ,
	[GroupsIDs]  ,
	[Groups_en]  ,
	[Groups_Ar]  ,
	[FeedDateTime]  ,
	[Creation_Datetime] ,
	[Resource_Type_Image],
	[Resource_Type_Img_Top] 
FROM dbo.Tracking_Resource_LiveFeeds WITH(NOLOCK) 
WHERE 1=1  '
+@Grpcondition
 End;  
print @query

INSERT #OUTTABLE
EXEC sp_executeSQL @QUERY
  
select *
from #OUTTABLE  

return
End;

GO
/****** Object:  StoredProcedure [dbo].[SP_Get_Sensor_Configurations]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE Procedure [dbo].[SP_Get_Sensor_Configurations] 
(@DeviceId int = null ) 
AS 

BEGIN  /*PROCEDURE BEGIN*/

select Sensor_DateTime,Sensor_Value,SensorConfigDBID,Sensor_Configuration.Config_Text,Sensor_Configuration.Config_Text_Arabic,Sensor_Configuration.Icon,Sensor_Configuration.TextValue,Sensor_Configuration.MaxValue,Sensor_Configuration.MinValue, Sensors.Name_En, Sensors.Name_Ar
from Sensors_LiveFeeds

inner join Sensor_Configuration
on Sensors_LiveFeeds.SensorConfigDBID = Sensor_Configuration.SensorConfig_DBID
inner join Sensors
on Sensors.Sensor_DBID = Sensor_Configuration.Sensor_DBID

where  device_dbid = @DeviceId
and Sensor_DateTime in 
(
	--Select max datetime
	select max(Sensor_DateTime)
	from Sensors_LiveFeeds
	where  device_dbid = @DeviceId
)

return
End;
GO
/****** Object:  StoredProcedure [dbo].[Sp_GetAlertInfo]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[Sp_GetAlertInfo] ( @P_Device_Type_ID int )  
AS	
Begin 


Declare @OUTTABLE TABLE( Alert_DBID int,
Name_Ar nvarchar(100), 
Name_En nvarchar(100), 
Icon nvarchar(150),
Color nvarchar(50) 
 )
 

insert into @OUTTABLE 
select Alerts.Alert_DBID ,
Alerts.Name_Ar , 
Alerts.Name_En , 
Alerts.Icon ,
Alerts.Color 
from DeviceType_SensorsConfig , Alert_Configuration , Alerts 
where  DeviceType_SensorsConfig.SensorConfig_DBID =  Alert_Configuration.SensorConfig_DBID
and Alert_Configuration.Alert_DBID = Alerts.Alert_DBID
and DeviceType_SensorsConfig.DeviceType_DBID =  @P_Device_Type_ID
 
select *
from @OUTTABLE;
 
 end;
GO
/****** Object:  StoredProcedure [dbo].[sp_getAlertsByDeviceTypeID]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sp_getAlertsByDeviceTypeID]
	@deviceTypeID int 
	
AS
	select distinct a.Alert_DBID as ID, a.Color as Color, a.Icon as Icon, a.IsRetired as IsRetired, a.Name_Ar as NameAr, a.Name_En as NameEn
	
from Tracking_Device_Types as tdt
join Sensors as s
on s.DeviceType_DBID = tdt.DeviceType_DBID
join Sensor_Configuration as sc
on sc.Sensor_DBID = s.Sensor_DBID
join Alert_Configuration as ac
on ac.SensorConfig_DBID = sc.SensorConfig_DBID
join Alerts as a
on ac.Alert_DBID = a.Alert_DBID
where (tdt.IsRetired = 0 or tdt.IsRetired is null)
and
(s.IsRetired = 0 or s.IsRetired is null)
and
(sc.IsRetired = 0 or sc.IsRetired is null)
and
(ac.IsRetired = 0 or ac.IsRetired is null)
and
(a.IsRetired = 0 or a.IsRetired is null)

and tdt.DeviceType_DBID = @deviceTypeID
GO
/****** Object:  StoredProcedure [dbo].[Sp_GetGroupTree]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[Sp_GetGroupTree] ( @P_Group_ID int )  
AS	
Begin 


Declare @OUTTABLE TABLE( ParentResourceGroup_DBID INT, 
 ResourceGroup_DBID int ,
 EnName nvarchar(150) ,
 ArName nvarchar(150) ,
 VisibleforParent bit ,  
 DEPTH int )

Declare @ParentResourceGroup_DBID int,
@ResourceGroup_DBID int, 
@EnName nvarchar(150),
@ArName nvarchar(150),
@visibleforparent bit,
@DEPTH INT   

DECLARE GroupCursor CURSOR local forward_only static read_only 
FOR 
WITH Grouphierarchy (ParentResourceGroup_DBID, ResourceGroup_DBID, EnName, ArName,VisibleforParent, Level)
AS
(
-- Anchor member definition
    SELECT e.ParentResourceGroup_DBID, e.ResourceGroup_DBID , e.Description_En EnName, e.Description_Ar ArName,
        isnull(e.Visibleforparent,'True') ,0 AS Level
    FROM dbo.Tracking_Resource_Groups AS e
    WHERE ResourceGroup_DBID = @P_Group_ID

    UNION ALL
-- Recursive member definition
    SELECT e.ParentResourceGroup_DBID, e.ResourceGroup_DBID, e.Description_En EnName, e.Description_Ar ArName,
       isnull(e.Visibleforparent,'True') , Level + 1
    FROM dbo.Tracking_Resource_Groups AS e
    INNER JOIN Grouphierarchy AS d
        ON e.ParentResourceGroup_DBID = d.ResourceGroup_DBID
            
)Select ParentResourceGroup_DBID, ResourceGroup_DBID, EnName, ArName,visibleforparent, Level 
from Grouphierarchy 
WHERE Level  <>0 
;

OPEN GroupCursor   
FETCH NEXT FROM GroupCursor 
INTO @ParentResourceGroup_DBID, @ResourceGroup_DBID,@EnName, @ArName, @visibleforparent, @DEPTH   

WHILE @@FETCH_STATUS = 0   
BEGIN   
    INSERT INTO @OUTTABLE VALUES (@ParentResourceGroup_DBID, @ResourceGroup_DBID,@EnName, @ArName,@visibleforparent, @DEPTH)

    FETCH NEXT FROM GroupCursor INTO @ParentResourceGroup_DBID, @ResourceGroup_DBID,@EnName, @ArName,@visibleforparent, @DEPTH   
END   

CLOSE GroupCursor   
DEALLOCATE GroupCursor  

select *
from @OUTTABLE

--RETURN
end;
GO
/****** Object:  StoredProcedure [dbo].[sp_GetTrackingDevicesByUser]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Adham Elsharkawy>
-- Create date: <10/13/2014>
-- Description:	<Gets Tracking Devices accroding to active user or devices used in tracking resources>
-- =============================================
CREATE PROCEDURE [dbo].[sp_GetTrackingDevicesByUser] 
	-- Add the parameters for the stored procedure here
	@roleID decimal,
	@userID decimal
AS
BEGIN
	select distinct
	mtd.Device_DBID as ID, mtd.DeviceType_DBID as DeviceTypeID, mtd.Serial as Serial, mtd.SIM_Card_Number as SimCardNum, mtd.Created_By as CreatedBy,
 mtdt.DeviceType_Desc as DeviceType_Desc 
 from Tracking_Devices as mtd
 inner join Tracking_Device_Types mtdt
 on mtd.DeviceType_DBID = mtdt.DeviceType_DBID
 where (mtd.IsRetired = 0 or mtd.IsRetired is null) and
 (mtd.Created_By like @userID or mtd.Device_DBID in (select distinct 
tr.Device_DBID
from [Tracking_ResourceGroup_GeoRole] as fggr
inner join Tracking_Resource_Groups fg
on fg.ResourceGroup_DBID = fggr.ResourceGroup_DBID
inner join Tracking_Resource_ResGroup_Ass as fgrass
on fgrass.ResourceGroup_DBID = fg.ResourceGroup_DBID
inner join  Tracking_Resources as tr
on tr.Resource_DBID = fgrass.Resource_DBID
where fggr.GEO_RoleID = @roleID
and (fggr.IsRetired = 0 or fggr.IsRetired is null)
and (fg.IsRetired = 0 or fg.IsRetired is null)
and (fgrass.IsRetired = 0 or fgrass.IsRetired is null)
and (tr.IsRetired = 0 or tr.IsRetired is null)
))

END
GO
/****** Object:  StoredProcedure [dbo].[SP_GetTrackingReport_Alert]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create  proc [dbo].[SP_GetTrackingReport_Alert] @plateNumber nvarchar(10),@fromDate datetime,@toDate datetime 
as
select Device_DBID,Alert_DateTime,Zone,Device,AlertName_En,AlertName_Ar,PlateNumber,License,X_Coord,Y_Coord
from dbo.Alert_LiveFeedsHistory
where PlateNumber= @plateNumber
and Alert_DateTime between @fromDate  and @toDate
order by Alert_DateTime desc 
GO
/****** Object:  StoredProcedure [dbo].[SP_GetTrackingReport_Resource]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[SP_GetTrackingReport_Resource] @plateNumber nvarchar(10),@FromDate DateTime ,@ToDate DateTime
as
select  Device_DBID,PlateNumber,License,Device,Speed,Heading,X_Coord,Y_Coord,FeedDateTime
from dbo.Tracking_Resource_LFHistory
where PlateNumber=@plateNumber 
and
FeedDateTime between @FromDate and @ToDate
order by FeedDateTime desc 
GO
/****** Object:  StoredProcedure [dbo].[sp_GetTrackingResourceByRoleID]    Script Date: 12/8/2014 11:48:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Adham Elsharkawy>
-- Create date: <10/13/2014>
-- Description:	<Gets all Tracking resource according to available fleet groups which are determined by current role ID>
-- =============================================
CREATE PROCEDURE [dbo].[sp_GetTrackingResourceByRoleID]
	@roleID float 
AS
BEGIN 
select distinct
 tr.Resource_DBID as ID, tr.PlateNumber as PlateNumber, tr.License as Licence, tr.Device_DBID as DeviceID, 
 tdt.DeviceType_Desc as DeviceType_Desc
from [Tracking_ResourceGroup_GeoRole] as fggr
inner join Tracking_Resource_Groups fg
on fg.ResourceGroup_DBID = fggr.ResourceGroup_DBID
inner join Tracking_Resource_ResGroup_Ass as fgrass
on fgrass.ResourceGroup_DBID = fg.ResourceGroup_DBID
inner join  Tracking_Resources as tr
on tr.Resource_DBID = fgrass.Resource_DBID
inner join Tracking_Devices as td
on tr.Device_DBID = td.Device_DBID
inner join Tracking_Device_Types tdt
on td.DeviceType_DBID = tdt.DeviceType_DBID
where fggr.GEO_RoleID = @roleID
and (fggr.IsRetired = 0 or fggr.IsRetired is null)
and (fg.IsRetired = 0 or fg.IsRetired is null)
and (fgrass.IsRetired = 0 or fgrass.IsRetired is null)
and (tr.IsRetired = 0 or tr.IsRetired is null)
and (td.IsRetired = 0 or td.IsRetired is null)
and (tdt.IsRetired = 0 or tdt.IsRetired is null)
END
GO


USE [BetaTrackingDBV501]
GO

INSERT INTO SEQUENCE_STORE VALUES ('RESOURCE_LIVE_FEEDS', 0);
INSERT INTO SEQUENCE_STORE VALUES ('ALERT_LIVE_FEEDS', 0);
INSERT INTO SEQUENCE_STORE VALUES ('SENSOR_LIVE_FEEDS', 0);


SET IDENTITY_INSERT [dbo].[Tracking_Device_Types] ON 
INSERT INTO TRACKING_DEVICE_TYPES (DEVICETYPE_DESC, ISRETIRED) VALUES ('ENFORA 5002', 0);
INSERT [dbo].[Tracking_Device_Types] ([DeviceType_DBID], [DeviceType_Desc], [Creation_Date], [Created_By], [Modified_By], [Modification_Date], [IsRetired]) VALUES (4, N'Motorola 500', CAST(N'2014-10-26 14:51:54.000' AS DateTime), 195, 195, CAST(N'2014-11-10 13:26:00.000' AS DateTime), 0)
INSERT [dbo].[Tracking_Device_Types] ([DeviceType_DBID], [DeviceType_Desc], [Creation_Date], [Created_By], [Modified_By], [Modification_Date], [IsRetired]) VALUES (5, N'Enfora 200', CAST(N'2014-10-26 14:52:39.000' AS DateTime), 195, 195, CAST(N'2014-11-06 13:23:01.000' AS DateTime), 1)
SET IDENTITY_INSERT [dbo].[Tracking_Device_Types] OFF
SET IDENTITY_INSERT [dbo].[Alerts] ON 

--Alerts
INSERT INTO dbo.Alerts (name_en, devicetype_dbid, ISRETIRED) VALUES ('Oil Alert', 1,0);
INSERT INTO dbo.Alerts (name_en, devicetype_dbid, ISRETIRED) VALUES ('Temp Alert', 1,0);
INSERT INTO dbo.Alerts (name_en, devicetype_dbid, ISRETIRED) VALUES ('Air Alert', 1,1);
INSERT INTO dbo.Alerts (name_en, devicetype_dbid, ISRETIRED) VALUES ('Compound Alert', 1,0);
INSERT INTO dbo.Alerts (name_en, devicetype_dbid, ISRETIRED) VALUES ('Compound Alert 2', 1,0);
INSERT [dbo].[Alerts] ([Alert_DBID], [Name_Ar], [Name_En], [Icon], [Color], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [DeviceType_DBID]) VALUES (1, N'مشكله فى حزام الأمان', N'problem in seat belt', N'http://192.168.9.120/Images/Alerts/Fence.jpg', N'#FFC00000', 195, NULL, CAST(N'2014-10-27 09:07:46.000' AS DateTime), NULL, 0, 5)
INSERT [dbo].[Alerts] ([Alert_DBID], [Name_Ar], [Name_En], [Icon], [Color], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [DeviceType_DBID]) VALUES (2, N'كسر سرعه', N'High Speed', N'http://192.168.9.33/SharedFiles/Tracking/Alerts//High Speed Alert.png', NULL, NULL, 195, NULL, CAST(N'2014-11-09 12:59:00.000' AS DateTime), 0, 4)
INSERT [dbo].[Alerts] ([Alert_DBID], [Name_Ar], [Name_En], [Icon], [Color], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [DeviceType_DBID]) VALUES (5, N'حزام الامان', N'Seat Belt Off', N'http://192.168.9.33/SharedFiles/Tracking/Alerts//Off Belt Alert.png', NULL, NULL, 195, NULL, CAST(N'2014-11-06 13:52:55.000' AS DateTime), 0, 4)
INSERT [dbo].[Alerts] ([Alert_DBID], [Name_Ar], [Name_En], [Icon], [Color], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [DeviceType_DBID]) VALUES (6, N'حرارة عالية', N'High Temp', N'http://192.168.9.33/SharedFiles/Tracking/Alerts//HTemp2Alert.png', NULL, NULL, 195, NULL, CAST(N'2014-11-09 12:59:16.000' AS DateTime), 0, 4)
INSERT [dbo].[Alerts] ([Alert_DBID], [Name_Ar], [Name_En], [Icon], [Color], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [DeviceType_DBID]) VALUES (8, N'الوضع خطر', N'Dangerous Situation', N'http://192.168.9.33/SharedFiles/Tracking/Alerts//Alert.png', NULL, NULL, 195, NULL, CAST(N'2014-11-10 11:13:27.000' AS DateTime), 0, 4)
INSERT [dbo].[Alerts] ([Alert_DBID], [Name_Ar], [Name_En], [Icon], [Color], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [DeviceType_DBID]) VALUES (11, N'Fence Violation', N'Fence Violation', NULL, NULL, 195, NULL, CAST(N'2014-12-01 15:17:22.000' AS DateTime), NULL, 0, 4)
SET IDENTITY_INSERT [dbo].[Alerts] OFF
SET IDENTITY_INSERT [dbo].[Sensor_Types] ON 

INSERT [dbo].[Sensor_Types] ([Sensor_Type_DBID], [SensorType_Description]) VALUES (1, N'Ignition')
INSERT [dbo].[Sensor_Types] ([Sensor_Type_DBID], [SensorType_Description]) VALUES (2, N'GeoFence')
INSERT [dbo].[Sensor_Types] ([Sensor_Type_DBID], [SensorType_Description]) VALUES (3, N'RFID')
SET IDENTITY_INSERT [dbo].[Sensor_Types] OFF
SET IDENTITY_INSERT [dbo].[Sensors] ON 

INSERT INTO SENSORS (DEVICETYPE_DBID, NAME_EN, ISRETIRED) VALUES(1, 'OIL',0);
INSERT INTO SENSORS (DEVICETYPE_DBID, NAME_EN, ISRETIRED) VALUES(1, 'TEMP',0);
INSERT INTO SENSORS (DEVICETYPE_DBID, NAME_EN, ISRETIRED) VALUES(1, 'HEAT',1);
INSERT INTO SENSORS (DEVICETYPE_DBID, NAME_EN, ISRETIRED) VALUES(1, 'AIR',0);
INSERT [dbo].[Sensors] ([Sensor_DBID], [Sensor_Type_DBID], [DeviceType_DBID], [Name_Ar], [Name_En], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired]) VALUES (1, NULL, 4, N'سرعه', N'Speed', 195, 195, CAST(N'2014-10-27 08:58:22.000' AS DateTime), CAST(N'2014-11-06 08:08:49.000' AS DateTime), 0)
INSERT [dbo].[Sensors] ([Sensor_DBID], [Sensor_Type_DBID], [DeviceType_DBID], [Name_Ar], [Name_En], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired]) VALUES (2, NULL, 5, N'حزام الأمان', N'seat belt', 195, 195, CAST(N'2014-10-27 09:05:59.000' AS DateTime), CAST(N'2014-11-06 13:22:50.000' AS DateTime), 1)
INSERT [dbo].[Sensors] ([Sensor_DBID], [Sensor_Type_DBID], [DeviceType_DBID], [Name_Ar], [Name_En], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired]) VALUES (3, NULL, 4, N'درجة الحرارة', N'Temperature', 195, 195, CAST(N'2014-11-05 09:40:38.000' AS DateTime), CAST(N'2014-11-06 08:09:54.000' AS DateTime), 0)
INSERT [dbo].[Sensors] ([Sensor_DBID], [Sensor_Type_DBID], [DeviceType_DBID], [Name_Ar], [Name_En], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired]) VALUES (4, NULL, 4, N'حزام الامان', N'Seat Belt', 195, 195, CAST(N'2014-11-05 09:42:17.000' AS DateTime), CAST(N'2014-11-06 13:52:30.000' AS DateTime), 0)
INSERT [dbo].[Sensors] ([Sensor_DBID], [Sensor_Type_DBID], [DeviceType_DBID], [Name_Ar], [Name_En], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired]) VALUES (16, 2, 4, N'GepFence', N'GeoFence', 195, NULL, CAST(N'2014-12-01 15:16:06.000' AS DateTime), NULL, 0)
SET IDENTITY_INSERT [dbo].[Sensors] OFF
SET IDENTITY_INSERT [dbo].[Sensor_Configuration] ON 

--Temp Sensor Configurations
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, MAXVALUE,MINVALUE,CONFIG_TEXT, ISRETIRED) values (2, 43.13846153, 25.0, 'Low', 0);
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, MAXVALUE,MINVALUE,CONFIG_TEXT, ISRETIRED) values (2, 90.0, 43.13846153, 'Med', 0);
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, MAXVALUE,MINVALUE,CONFIG_TEXT, ISRETIRED) values (2, 100.0, 90.0, 'High', 0);
--Oil Sensor Configurations
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, TEXTVALUE, ISRETIRED) values (1, 'In',0);
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, TEXTVALUE, ISRETIRED) values (1, 'Out',0);
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, TEXTVALUE, ISRETIRED) values (1, 'On',1);
--Air Sensor Configurations
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, TEXTVALUE, ISRETIRED) values (1, 'Low',0);
INSERT [dbo].[Sensor_Configuration] ([SensorConfig_DBID], [Sensor_DBID], [MaxValue], [MinValue], [TextValue], [Icon], [Color], [Config_Text], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [ShowOnMap], [Map_Rep_Indicator_En], [Map_Rep_Indicator_Ar], [Config_Text_Arabic]) VALUES (1, 1, 60, 0, N'Low', N'http://192.168.9.33/SharedFiles/Tracking/Sensors//Low.png', NULL, N'Low Speed', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, N'سرعة منخفضه')
INSERT [dbo].[Sensor_Configuration] ([SensorConfig_DBID], [Sensor_DBID], [MaxValue], [MinValue], [TextValue], [Icon], [Color], [Config_Text], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [ShowOnMap], [Map_Rep_Indicator_En], [Map_Rep_Indicator_Ar], [Config_Text_Arabic]) VALUES (2, 1, 120, 60, N'Medium', N'http://192.168.9.33/SharedFiles/Tracking/Sensors/Med.png', NULL, N'Medium Speed', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, N'سرعه متوسطه')
INSERT [dbo].[Sensor_Configuration] ([SensorConfig_DBID], [Sensor_DBID], [MaxValue], [MinValue], [TextValue], [Icon], [Color], [Config_Text], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [ShowOnMap], [Map_Rep_Indicator_En], [Map_Rep_Indicator_Ar], [Config_Text_Arabic]) VALUES (3, 1, 200, 120, N'High', N'http://192.168.9.33/SharedFiles/Tracking/Sensors//High.png', NULL, N'High Speed', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, N'سرعه عاليه')
INSERT [dbo].[Sensor_Configuration] ([SensorConfig_DBID], [Sensor_DBID], [MaxValue], [MinValue], [TextValue], [Icon], [Color], [Config_Text], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [ShowOnMap], [Map_Rep_Indicator_En], [Map_Rep_Indicator_Ar], [Config_Text_Arabic]) VALUES (6, 3, 30, 0, N'Low', N'http://192.168.9.33/SharedFiles/Tracking/Sensors//LowTemp2.png', NULL, N'Low', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, N'منخفض')
INSERT [dbo].[Sensor_Configuration] ([SensorConfig_DBID], [Sensor_DBID], [MaxValue], [MinValue], [TextValue], [Icon], [Color], [Config_Text], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [ShowOnMap], [Map_Rep_Indicator_En], [Map_Rep_Indicator_Ar], [Config_Text_Arabic]) VALUES (7, 3, 200, 60, N'High', N'http://192.168.9.33/SharedFiles/Tracking/Sensors//SEN. TEMP 3.png', NULL, N'High', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, N'متوسط')
INSERT [dbo].[Sensor_Configuration] ([SensorConfig_DBID], [Sensor_DBID], [MaxValue], [MinValue], [TextValue], [Icon], [Color], [Config_Text], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [ShowOnMap], [Map_Rep_Indicator_En], [Map_Rep_Indicator_Ar], [Config_Text_Arabic]) VALUES (8, 3, 60, 30, N'Med', N'http://192.168.9.33/SharedFiles/Tracking/Sensors//LowTemp2.png', NULL, N'Med', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, N'عالي')
INSERT [dbo].[Sensor_Configuration] ([SensorConfig_DBID], [Sensor_DBID], [MaxValue], [MinValue], [TextValue], [Icon], [Color], [Config_Text], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [ShowOnMap], [Map_Rep_Indicator_En], [Map_Rep_Indicator_Ar], [Config_Text_Arabic]) VALUES (9, 4, NULL, NULL, N'On', N'http://192.168.9.33/SharedFiles/Tracking/Sensors//SeatBeltOn.png', NULL, N'Seat Belt On', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, N'الحزام مغلق')
INSERT [dbo].[Sensor_Configuration] ([SensorConfig_DBID], [Sensor_DBID], [MaxValue], [MinValue], [TextValue], [Icon], [Color], [Config_Text], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [ShowOnMap], [Map_Rep_Indicator_En], [Map_Rep_Indicator_Ar], [Config_Text_Arabic]) VALUES (10, 4, NULL, NULL, N'Off', N'http://192.168.9.33/SharedFiles/Tracking/Sensors//SeatBeltOff.png', NULL, N'Seat Belt Off', NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, N'الحزام مفتوح')
INSERT [dbo].[Sensor_Configuration] ([SensorConfig_DBID], [Sensor_DBID], [MaxValue], [MinValue], [TextValue], [Icon], [Color], [Config_Text], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [ShowOnMap], [Map_Rep_Indicator_En], [Map_Rep_Indicator_Ar], [Config_Text_Arabic]) VALUES (22, 16, NULL, NULL, N'in', NULL, NULL, N'Fence In', 195, NULL, CAST(N'2014-12-01 15:16:06.000' AS DateTime), NULL, 0, NULL, NULL, NULL, N'Fence In')
INSERT [dbo].[Sensor_Configuration] ([SensorConfig_DBID], [Sensor_DBID], [MaxValue], [MinValue], [TextValue], [Icon], [Color], [Config_Text], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [ShowOnMap], [Map_Rep_Indicator_En], [Map_Rep_Indicator_Ar], [Config_Text_Arabic]) VALUES (23, 16, NULL, NULL, N'out', NULL, NULL, N'Fence Out', 195, NULL, CAST(N'2014-12-01 15:16:06.000' AS DateTime), NULL, 0, NULL, NULL, NULL, N'Fence Out')
SET IDENTITY_INSERT [dbo].[Sensor_Configuration] OFF
SET IDENTITY_INSERT [dbo].[Alert_Configuration] ON 

--Temp Alert Configurations
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, ISRETIRED ) values (2, 1, 0);
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, ISRETIRED ) values (2, 2, 0);
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, ISRETIRED ) values (2, 3, 1);
--Oil Alert Configurations
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, ISRETIRED ) values (1, 4, 0); --in 
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, ISRETIRED ) values (1, 5, 0); --out
--Coumpound Alert Configurations
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, ISRETIRED ) values (4, 2, 0); --Med Temp rule
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, ISRETIRED ) values (4, 4, 0); --In Oil rule
--Coumpound 2 Alert Configurations
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, ISRETIRED ) values (5, 2, 0); --Med Temp rule
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, ISRETIRED ) values (5, 5, 0); --Out Oil rule

INSERT [dbo].[Alert_Configuration] ([AlertConfig_DBID], [Alert_DBID], [SensorConfig_DBID], [Comments], [Modified_By], [Created_By], [Creation_Date], [Modification_Date], [IsRetired]) VALUES (2, 2, 3, NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Alert_Configuration] ([AlertConfig_DBID], [Alert_DBID], [SensorConfig_DBID], [Comments], [Modified_By], [Created_By], [Creation_Date], [Modification_Date], [IsRetired]) VALUES (4, 5, 10, NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Alert_Configuration] ([AlertConfig_DBID], [Alert_DBID], [SensorConfig_DBID], [Comments], [Modified_By], [Created_By], [Creation_Date], [Modification_Date], [IsRetired]) VALUES (6, 6, 7, NULL, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Alert_Configuration] ([AlertConfig_DBID], [Alert_DBID], [SensorConfig_DBID], [Comments], [Modified_By], [Created_By], [Creation_Date], [Modification_Date], [IsRetired]) VALUES (8, 8, 10, NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Alert_Configuration] ([AlertConfig_DBID], [Alert_DBID], [SensorConfig_DBID], [Comments], [Modified_By], [Created_By], [Creation_Date], [Modification_Date], [IsRetired]) VALUES (9, 8, 1, NULL, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Alert_Configuration] ([AlertConfig_DBID], [Alert_DBID], [SensorConfig_DBID], [Comments], [Modified_By], [Created_By], [Creation_Date], [Modification_Date], [IsRetired]) VALUES (10, 6, 6, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Alert_Configuration] ([AlertConfig_DBID], [Alert_DBID], [SensorConfig_DBID], [Comments], [Modified_By], [Created_By], [Creation_Date], [Modification_Date], [IsRetired]) VALUES (13, 11, 23, NULL, NULL, 195, CAST(N'2014-12-01 15:17:22.000' AS DateTime), NULL, 0)
SET IDENTITY_INSERT [dbo].[Alert_Configuration] OFF
SET IDENTITY_INSERT [dbo].[Tracking_Devices] ON 

INSERT [dbo].[Tracking_Devices] ([Device_DBID], [DeviceType_DBID], [SIM_Card_Number], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [Serial], [IsRetired]) VALUES (1, 4, N'PO40274640_6343', NULL, NULL, 195, NULL, N'1', 0)
INSERT [dbo].[Tracking_Devices] ([Device_DBID], [DeviceType_DBID], [SIM_Card_Number], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [Serial], [IsRetired]) VALUES (2, 4, N'PO16538688_4861', NULL, NULL, 195, NULL, N'2', 0)
INSERT [dbo].[Tracking_Devices] ([Device_DBID], [DeviceType_DBID], [SIM_Card_Number], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [Serial], [IsRetired]) VALUES (3, 4, N'PO25938838_3991', NULL, NULL, 195, NULL, N'3', 0)
INSERT [dbo].[Tracking_Devices] ([Device_DBID], [DeviceType_DBID], [SIM_Card_Number], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [Serial], [IsRetired]) VALUES (4, 4, N'PO07826824_6464', NULL, NULL, 195, NULL, N'4', 0)
INSERT [dbo].[Tracking_Devices] ([Device_DBID], [DeviceType_DBID], [SIM_Card_Number], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [Serial], [IsRetired]) VALUES (5, 4, N'PO48740766_4175', NULL, NULL, 195, NULL, N'5', 0)
INSERT [dbo].[Tracking_Devices] ([Device_DBID], [DeviceType_DBID], [SIM_Card_Number], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [Serial], [IsRetired]) VALUES (6, 4, N'PO77204421_0300', NULL, NULL, 195, NULL, N'6', 0)
INSERT [dbo].[Tracking_Devices] ([Device_DBID], [DeviceType_DBID], [SIM_Card_Number], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [Serial], [IsRetired]) VALUES (7, 4, N'PO87383098_0826', NULL, NULL, 195, NULL, N'7', 0)
INSERT [dbo].[Tracking_Devices] ([Device_DBID], [DeviceType_DBID], [SIM_Card_Number], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [Serial], [IsRetired]) VALUES (8, 4, N'PO81912721_2431', NULL, NULL, 195, NULL, N'8', 0)
INSERT [dbo].[Tracking_Devices] ([Device_DBID], [DeviceType_DBID], [SIM_Card_Number], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [Serial], [IsRetired]) VALUES (9, 4, N'PO28038164_0443', NULL, NULL, 195, NULL, N'9', 0)
INSERT [dbo].[Tracking_Devices] ([Device_DBID], [DeviceType_DBID], [SIM_Card_Number], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [Serial], [IsRetired]) VALUES (10, 4, N'PO87981500_6026', NULL, NULL, 195, NULL, N'10', 0)
INSERT [dbo].[Tracking_Devices] ([Device_DBID], [DeviceType_DBID], [SIM_Card_Number], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [Serial], [IsRetired]) VALUES (11, 4, N'PO86713975_3390', NULL, CAST(N'2014-11-11 15:17:27.000' AS DateTime), 195, 195, N'11', 0)
SET IDENTITY_INSERT [dbo].[Tracking_Devices] OFF
SET IDENTITY_INSERT [dbo].[Tracking_Resource_Types] ON 

INSERT [dbo].[Tracking_Resource_Types] ([Resource_Type_DBID], [Name_Ar], [Name_En], [Tracking_Res_Image], [Modified_By], [Created_By], [Creation_Date], [Modification_date], [Tracking_Res_Image_Top]) VALUES (1, N'نقليات', N'Pickup', N'Van.png', NULL, NULL, NULL, NULL, N'VanTop.png')
INSERT [dbo].[Tracking_Resource_Types] ([Resource_Type_DBID], [Name_Ar], [Name_En], [Tracking_Res_Image], [Modified_By], [Created_By], [Creation_Date], [Modification_date], [Tracking_Res_Image_Top]) VALUES (2, N'حافلة', N'Bus', N'Bus.png', NULL, NULL, NULL, NULL, N'BusTop.png')
INSERT [dbo].[Tracking_Resource_Types] ([Resource_Type_DBID], [Name_Ar], [Name_En], [Tracking_Res_Image], [Modified_By], [Created_By], [Creation_Date], [Modification_date], [Tracking_Res_Image_Top]) VALUES (3, N'سيارة', N'Sedan', N'Car.png', NULL, NULL, NULL, NULL, N'CarTop.png')
INSERT [dbo].[Tracking_Resource_Types] ([Resource_Type_DBID], [Name_Ar], [Name_En], [Tracking_Res_Image], [Modified_By], [Created_By], [Creation_Date], [Modification_date], [Tracking_Res_Image_Top]) VALUES (4, N'دراجة', N'Bicycle', N'Bicycle.png', NULL, NULL, NULL, NULL, N'BicycleTop.png')
INSERT [dbo].[Tracking_Resource_Types] ([Resource_Type_DBID], [Name_Ar], [Name_En], [Tracking_Res_Image], [Modified_By], [Created_By], [Creation_Date], [Modification_date], [Tracking_Res_Image_Top]) VALUES (5, N'دراجة بخارية', N'Motorcycle', N'Motor.png', NULL, NULL, NULL, NULL, N'MotorTop.png')
SET IDENTITY_INSERT [dbo].[Tracking_Resource_Types] OFF
SET IDENTITY_INSERT [dbo].[Tracking_Resources] ON 

INSERT [dbo].[Tracking_Resources] ([Resource_DBID], [Device_DBID], [Resource_Type_DBID], [Resource_Desc], [PlateNumber], [License], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [Description_Ar], [Description_En]) VALUES (7, 2, 1, NULL, N'S906828', N'9401918081', 195, 195, CAST(N'2014-10-27 08:15:21.000' AS DateTime), CAST(N'2014-11-10 08:45:07.000' AS DateTime), 0, NULL, NULL)
INSERT [dbo].[Tracking_Resources] ([Resource_DBID], [Device_DBID], [Resource_Type_DBID], [Resource_Desc], [PlateNumber], [License], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [Description_Ar], [Description_En]) VALUES (8, 3, 2, NULL, N'B455003', N'6470856190', 195, 195, CAST(N'2014-10-27 08:16:25.000' AS DateTime), CAST(N'2014-11-06 06:53:21.000' AS DateTime), 0, NULL, NULL)
INSERT [dbo].[Tracking_Resources] ([Resource_DBID], [Device_DBID], [Resource_Type_DBID], [Resource_Desc], [PlateNumber], [License], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [Description_Ar], [Description_En]) VALUES (9, 4, 2, NULL, N'B285260', N'0199369184', 195, 195, CAST(N'2014-10-27 08:17:27.000' AS DateTime), CAST(N'2014-11-06 11:46:11.000' AS DateTime), 0, NULL, NULL)
INSERT [dbo].[Tracking_Resources] ([Resource_DBID], [Device_DBID], [Resource_Type_DBID], [Resource_Desc], [PlateNumber], [License], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [Description_Ar], [Description_En]) VALUES (10, 5, 2, NULL, N'B455547', N'8048515902', 195, 195, CAST(N'2014-10-27 08:17:59.000' AS DateTime), CAST(N'2014-11-06 06:56:32.000' AS DateTime), 0, NULL, NULL)
INSERT [dbo].[Tracking_Resources] ([Resource_DBID], [Device_DBID], [Resource_Type_DBID], [Resource_Desc], [PlateNumber], [License], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [Description_Ar], [Description_En]) VALUES (11, 6, 2, NULL, N'B694290', N'3372734100', 195, 195, CAST(N'2014-10-27 08:18:43.000' AS DateTime), CAST(N'2014-11-06 06:57:25.000' AS DateTime), 0, NULL, NULL)
INSERT [dbo].[Tracking_Resources] ([Resource_DBID], [Device_DBID], [Resource_Type_DBID], [Resource_Desc], [PlateNumber], [License], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [Description_Ar], [Description_En]) VALUES (12, 7, 2, NULL, N'B549597', N'5688188217', 195, 195, CAST(N'2014-10-27 08:19:35.000' AS DateTime), CAST(N'2014-11-06 06:58:14.000' AS DateTime), 0, NULL, NULL)
INSERT [dbo].[Tracking_Resources] ([Resource_DBID], [Device_DBID], [Resource_Type_DBID], [Resource_Desc], [PlateNumber], [License], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [Description_Ar], [Description_En]) VALUES (13, 8, 3, NULL, N'T894743', N'2854395157', 195, 195, CAST(N'2014-10-27 08:20:16.000' AS DateTime), CAST(N'2014-11-06 06:59:19.000' AS DateTime), 0, NULL, NULL)
INSERT [dbo].[Tracking_Resources] ([Resource_DBID], [Device_DBID], [Resource_Type_DBID], [Resource_Desc], [PlateNumber], [License], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [Description_Ar], [Description_En]) VALUES (14, 9, 3, NULL, N'T5115011', N'1468846384', 195, 195, CAST(N'2014-10-27 08:33:23.000' AS DateTime), CAST(N'2014-11-26 12:27:49.000' AS DateTime), 0, NULL, NULL)
INSERT [dbo].[Tracking_Resources] ([Resource_DBID], [Device_DBID], [Resource_Type_DBID], [Resource_Desc], [PlateNumber], [License], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [Description_Ar], [Description_En]) VALUES (15, 10, 3, NULL, N'T014045', N'3661428676', 195, 195, CAST(N'2014-10-27 08:34:03.000' AS DateTime), CAST(N'2014-11-06 07:01:19.000' AS DateTime), 0, NULL, NULL)
INSERT [dbo].[Tracking_Resources] ([Resource_DBID], [Device_DBID], [Resource_Type_DBID], [Resource_Desc], [PlateNumber], [License], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [Description_Ar], [Description_En]) VALUES (17, 1, 1, NULL, N'S320739', N'0082365231', 195, 195, CAST(N'2014-10-27 08:35:34.000' AS DateTime), CAST(N'2014-11-10 08:45:23.000' AS DateTime), 0, NULL, NULL)
INSERT [dbo].[Tracking_Resources] ([Resource_DBID], [Device_DBID], [Resource_Type_DBID], [Resource_Desc], [PlateNumber], [License], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [Description_Ar], [Description_En]) VALUES (21, 11, 2, NULL, N'BS765468', N'86738763', 195, NULL, CAST(N'2014-11-06 13:21:18.000' AS DateTime), NULL, 0, NULL, NULL)
INSERT [dbo].[Tracking_Resources] ([Resource_DBID], [Device_DBID], [Resource_Type_DBID], [Resource_Desc], [PlateNumber], [License], [Created_By], [Modified_By], [Creation_Date], [Modification_Date], [IsRetired], [Description_Ar], [Description_En]) VALUES (23, 11, 1, NULL, N'*&^', N'*&^', 195, NULL, CAST(N'2014-12-07 12:09:24.000' AS DateTime), NULL, 1, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Tracking_Resources] OFF
SET IDENTITY_INSERT [dbo].[Tracking_Crew] ON 

INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (2, N'عاى', N'121s3', N'Ali                                                                                                                                                   ', 195, CAST(N'2014-10-27 11:21:07.000' AS DateTime), NULL, NULL, N'0101111217', N'Egyptian', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (3, N'Arvind', N'399099978', N'Arvind                                                                                                                                                ', 195, CAST(N'2014-11-05 22:37:22.000' AS DateTime), NULL, NULL, NULL, N'Hindi', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (4, N'Sofi', NULL, N'Sofi                                                                                                                                                  ', 195, CAST(N'2014-11-05 22:38:15.000' AS DateTime), NULL, NULL, NULL, N'Egyptian', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (5, N'Arvind', N'5476565PE', N'Arvind                                                                                                                                                ', 195, CAST(N'2014-11-05 23:19:01.000' AS DateTime), NULL, NULL, N'54677778', N'Hindi', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (6, N'Nour', NULL, N'Nour                                                                                                                                                  ', 195, CAST(N'2014-11-05 23:19:01.000' AS DateTime), NULL, NULL, N'4456667', N'Egyptian', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (7, N'Ali', N'674856748', N'Ali                                                                                                                                                   ', 195, CAST(N'2014-11-06 06:53:21.000' AS DateTime), NULL, NULL, N'7765657', N'Hindi', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (8, N'Fahd', N'5876589PD', N'Fahd                                                                                                                                                  ', 195, CAST(N'2014-11-06 06:54:52.000' AS DateTime), NULL, NULL, N'7786543', N'Pakistani', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (9, N'Mourad', NULL, N'Mourad                                                                                                                                                ', 195, CAST(N'2014-11-06 06:54:53.000' AS DateTime), NULL, NULL, N'5644568', N'Egyptian', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (10, N'Mori', N'576435KM', N'Mori                                                                                                                                                  ', 195, CAST(N'2014-11-06 06:56:31.000' AS DateTime), NULL, NULL, N'654554', N'Filipino', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (11, N'Samir', N'543789PO', N'Samir                                                                                                                                                 ', 195, CAST(N'2014-11-06 06:57:24.000' AS DateTime), NULL, NULL, N'456734', N'Pakistani', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (12, N'Tomas', N'344355LK', N'Tomas                                                                                                                                                 ', 195, CAST(N'2014-11-06 06:58:13.000' AS DateTime), NULL, NULL, N'445678', N'Hindi', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (13, N'Nader', N'543234RF', N'Nader                                                                                                                                                 ', 195, CAST(N'2014-11-06 06:59:18.000' AS DateTime), NULL, NULL, N'556456', N'Egyptian', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (14, N'Ravi', N'345466UK', N'Ravi                                                                                                                                                  ', 195, CAST(N'2014-11-06 07:00:11.000' AS DateTime), NULL, NULL, N'556789', N'Hindi', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (15, N'Samih', N'678543LK', N'Samih                                                                                                                                                 ', 195, CAST(N'2014-11-06 07:01:18.000' AS DateTime), NULL, NULL, N'778999', N'Iraqi', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (16, N'Wael', N'565654MN', N'Wael                                                                                                                                                  ', 195, CAST(N'2014-11-06 07:02:34.000' AS DateTime), NULL, NULL, N'778654', N'Egyptian', 0)
INSERT [dbo].[Tracking_Crew] ([Crew_DBID], [Crew_Name_Ar], [DriverLicense], [Crew_Name_En], [Created_By], [Creation_Date], [Modified_By], [Modification_Date], [Phone_Number], [Nationality], [Gender]) VALUES (17, N'Manal', N'74564786JM', N'Manal                                                                                                                                                 ', 195, CAST(N'2014-11-06 13:21:17.000' AS DateTime), NULL, NULL, N'6654873', N'Egyptian', 1)
SET IDENTITY_INSERT [dbo].[Tracking_Crew] OFF
SET IDENTITY_INSERT [dbo].[Tracking_Resource_Crew] ON 

INSERT [dbo].[Tracking_Resource_Crew] ([Resource_Crew_DBID], [Resource_DBID], [Crew_DBID], [Is_Driver], [Create_By], [Creation_Date], [Modified_By], [Modification_Date], [IsRetired]) VALUES (4, 8, 4, 0, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Tracking_Resource_Crew] ([Resource_Crew_DBID], [Resource_DBID], [Crew_DBID], [Is_Driver], [Create_By], [Creation_Date], [Modified_By], [Modification_Date], [IsRetired]) VALUES (5, 7, 5, 1, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Tracking_Resource_Crew] ([Resource_Crew_DBID], [Resource_DBID], [Crew_DBID], [Is_Driver], [Create_By], [Creation_Date], [Modified_By], [Modification_Date], [IsRetired]) VALUES (6, 7, 6, 0, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Tracking_Resource_Crew] ([Resource_Crew_DBID], [Resource_DBID], [Crew_DBID], [Is_Driver], [Create_By], [Creation_Date], [Modified_By], [Modification_Date], [IsRetired]) VALUES (7, 8, 7, 1, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Tracking_Resource_Crew] ([Resource_Crew_DBID], [Resource_DBID], [Crew_DBID], [Is_Driver], [Create_By], [Creation_Date], [Modified_By], [Modification_Date], [IsRetired]) VALUES (8, 9, 8, 1, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Tracking_Resource_Crew] ([Resource_Crew_DBID], [Resource_DBID], [Crew_DBID], [Is_Driver], [Create_By], [Creation_Date], [Modified_By], [Modification_Date], [IsRetired]) VALUES (9, 9, 9, 0, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Tracking_Resource_Crew] ([Resource_Crew_DBID], [Resource_DBID], [Crew_DBID], [Is_Driver], [Create_By], [Creation_Date], [Modified_By], [Modification_Date], [IsRetired]) VALUES (10, 10, 10, 1, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Tracking_Resource_Crew] ([Resource_Crew_DBID], [Resource_DBID], [Crew_DBID], [Is_Driver], [Create_By], [Creation_Date], [Modified_By], [Modification_Date], [IsRetired]) VALUES (11, 11, 11, 1, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Tracking_Resource_Crew] ([Resource_Crew_DBID], [Resource_DBID], [Crew_DBID], [Is_Driver], [Create_By], [Creation_Date], [Modified_By], [Modification_Date], [IsRetired]) VALUES (12, 12, 12, 1, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Tracking_Resource_Crew] ([Resource_Crew_DBID], [Resource_DBID], [Crew_DBID], [Is_Driver], [Create_By], [Creation_Date], [Modified_By], [Modification_Date], [IsRetired]) VALUES (13, 13, 13, 1, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Tracking_Resource_Crew] ([Resource_Crew_DBID], [Resource_DBID], [Crew_DBID], [Is_Driver], [Create_By], [Creation_Date], [Modified_By], [Modification_Date], [IsRetired]) VALUES (14, 14, 14, 1, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Tracking_Resource_Crew] ([Resource_Crew_DBID], [Resource_DBID], [Crew_DBID], [Is_Driver], [Create_By], [Creation_Date], [Modified_By], [Modification_Date], [IsRetired]) VALUES (15, 15, 15, 1, NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[Tracking_Resource_Crew] ([Resource_Crew_DBID], [Resource_DBID], [Crew_DBID], [Is_Driver], [Create_By], [Creation_Date], [Modified_By], [Modification_Date], [IsRetired]) VALUES (16, 17, 16, 1, NULL, NULL, NULL, NULL, 0)
SET IDENTITY_INSERT [dbo].[Tracking_Resource_Crew] OFF
SET IDENTITY_INSERT [dbo].[Tracking_Fence_Layers] ON 

INSERT [dbo].[Tracking_Fence_Layers] ([FenceLayer_DBID], [Layer_Name], [Layer_URL], [Created_By], [Modified_By], [Creation_Date], [Modification_Date]) VALUES (1, N'TestLayer', N'http://192.168.9.59:6080/arcgis/rest/services/US_LA/USA_LA_Operational_Map_Calls/FeatureServer/3', NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Tracking_Fence_Layers] OFF
SET IDENTITY_INSERT [dbo].[Tracking_Resource_Groups] ON 

INSERT [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID], [ParentResourceGroup_DBID], [FenceLayer_DBID], [Description_En], [Description_Ar], [Creation_Date], [Modification_Date], [Modified_By], [Created_By], [Res_Group_Image], [Name_En], [Name_Ar], [VisibleForParent], [IsRetired]) VALUES (1, NULL, NULL, N'Mowasalat Co.', N'شركة كروة', CAST(N'2014-10-26 13:47:59.000' AS DateTime), CAST(N'2014-11-06 11:15:38.000' AS DateTime), 195, 195, N'http://192.168.9.59/IdentifyFiles/Tracking//logo.png', N'Mowasalat Co.', N'شركة كروة', NULL, 0)
INSERT [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID], [ParentResourceGroup_DBID], [FenceLayer_DBID], [Description_En], [Description_Ar], [Creation_Date], [Modification_Date], [Modified_By], [Created_By], [Res_Group_Image], [Name_En], [Name_Ar], [VisibleForParent], [IsRetired]) VALUES (2, 1, NULL, N'Karwa Buses', N'حافلات كروة', CAST(N'2014-10-26 13:49:25.000' AS DateTime), CAST(N'2014-11-06 13:31:59.000' AS DateTime), 195, 195, N'http://192.168.9.33/sharedFiles/Tracking//Bus3.png', N'Karwa Buses', N'حافلات كروة', NULL, 0)
INSERT [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID], [ParentResourceGroup_DBID], [FenceLayer_DBID], [Description_En], [Description_Ar], [Creation_Date], [Modification_Date], [Modified_By], [Created_By], [Res_Group_Image], [Name_En], [Name_Ar], [VisibleForParent], [IsRetired]) VALUES (3, 1, NULL, N'Karwa Taxi', N'تاكسى كروة', CAST(N'2014-10-26 13:49:55.000' AS DateTime), CAST(N'2014-11-09 10:56:27.000' AS DateTime), 195, 195, N'http://192.168.9.59/IdentifyFiles/Tracking//Taxi.png', N'Karwa Taxi', N'تاكسى كروة', NULL, 0)
INSERT [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID], [ParentResourceGroup_DBID], [FenceLayer_DBID], [Description_En], [Description_Ar], [Creation_Date], [Modification_Date], [Modified_By], [Created_By], [Res_Group_Image], [Name_En], [Name_Ar], [VisibleForParent], [IsRetired]) VALUES (5, 2, NULL, N'Sightseeing', N'سياحة', CAST(N'2014-10-27 14:20:12.000' AS DateTime), CAST(N'2014-11-06 13:25:30.000' AS DateTime), 195, 196, N'http://192.168.9.33/sharedFiles/Tracking//HopOn.png', N'Sightseeing', N'سياحة', NULL, 0)
INSERT [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID], [ParentResourceGroup_DBID], [FenceLayer_DBID], [Description_En], [Description_Ar], [Creation_Date], [Modification_Date], [Modified_By], [Created_By], [Res_Group_Image], [Name_En], [Name_Ar], [VisibleForParent], [IsRetired]) VALUES (8, 3, NULL, NULL, NULL, CAST(N'2014-11-05 16:05:32.000' AS DateTime), CAST(N'2014-11-05 16:05:53.000' AS DateTime), 195, 195, NULL, N' eee', N'eeeee', NULL, 1)
INSERT [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID], [ParentResourceGroup_DBID], [FenceLayer_DBID], [Description_En], [Description_Ar], [Creation_Date], [Modification_Date], [Modified_By], [Created_By], [Res_Group_Image], [Name_En], [Name_Ar], [VisibleForParent], [IsRetired]) VALUES (9, 1, NULL, NULL, NULL, CAST(N'2014-11-06 09:43:42.000' AS DateTime), CAST(N'2014-11-06 10:26:20.000' AS DateTime), 195, 195, N'http://192.168.9.120/Images/Alerts/1.jpg', N'Van Track', N'van', NULL, 1)
INSERT [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID], [ParentResourceGroup_DBID], [FenceLayer_DBID], [Description_En], [Description_Ar], [Creation_Date], [Modification_Date], [Modified_By], [Created_By], [Res_Group_Image], [Name_En], [Name_Ar], [VisibleForParent], [IsRetired]) VALUES (10, 1, NULL, NULL, NULL, CAST(N'2014-11-09 10:54:26.000' AS DateTime), CAST(N'2014-11-09 11:12:39.000' AS DateTime), 195, 195, NULL, N'test', N'test', NULL, 1)
INSERT [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID], [ParentResourceGroup_DBID], [FenceLayer_DBID], [Description_En], [Description_Ar], [Creation_Date], [Modification_Date], [Modified_By], [Created_By], [Res_Group_Image], [Name_En], [Name_Ar], [VisibleForParent], [IsRetired]) VALUES (11, 1, NULL, NULL, NULL, CAST(N'2014-11-09 11:15:41.000' AS DateTime), CAST(N'2014-11-09 11:15:48.000' AS DateTime), 195, 195, NULL, N'test', N'test', NULL, 1)
INSERT [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID], [ParentResourceGroup_DBID], [FenceLayer_DBID], [Description_En], [Description_Ar], [Creation_Date], [Modification_Date], [Modified_By], [Created_By], [Res_Group_Image], [Name_En], [Name_Ar], [VisibleForParent], [IsRetired]) VALUES (12, 1, NULL, NULL, NULL, CAST(N'2014-11-09 11:16:11.000' AS DateTime), CAST(N'2014-11-09 11:17:38.000' AS DateTime), 195, 195, NULL, N'test1', N'test1', NULL, 1)
INSERT [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID], [ParentResourceGroup_DBID], [FenceLayer_DBID], [Description_En], [Description_Ar], [Creation_Date], [Modification_Date], [Modified_By], [Created_By], [Res_Group_Image], [Name_En], [Name_Ar], [VisibleForParent], [IsRetired]) VALUES (13, 2, NULL, NULL, NULL, CAST(N'2014-11-09 11:17:59.000' AS DateTime), CAST(N'2014-11-09 11:18:52.000' AS DateTime), 195, 195, NULL, N'test1', N'test1', NULL, 1)
INSERT [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID], [ParentResourceGroup_DBID], [FenceLayer_DBID], [Description_En], [Description_Ar], [Creation_Date], [Modification_Date], [Modified_By], [Created_By], [Res_Group_Image], [Name_En], [Name_Ar], [VisibleForParent], [IsRetired]) VALUES (14, 1, NULL, NULL, NULL, CAST(N'2014-11-09 12:02:07.000' AS DateTime), CAST(N'2014-11-09 12:10:57.000' AS DateTime), 195, 195, NULL, N'test1', N'test1', NULL, 1)
INSERT [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID], [ParentResourceGroup_DBID], [FenceLayer_DBID], [Description_En], [Description_Ar], [Creation_Date], [Modification_Date], [Modified_By], [Created_By], [Res_Group_Image], [Name_En], [Name_Ar], [VisibleForParent], [IsRetired]) VALUES (15, 3, NULL, N'test', N'test', CAST(N'2014-11-10 13:10:04.000' AS DateTime), CAST(N'2014-11-11 15:15:50.000' AS DateTime), 195, 195, NULL, N'Test', N'test', NULL, 1)
INSERT [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID], [ParentResourceGroup_DBID], [FenceLayer_DBID], [Description_En], [Description_Ar], [Creation_Date], [Modification_Date], [Modified_By], [Created_By], [Res_Group_Image], [Name_En], [Name_Ar], [VisibleForParent], [IsRetired]) VALUES (16, 3, NULL, N'1', N'1', CAST(N'2014-11-13 10:37:47.000' AS DateTime), CAST(N'2014-11-13 10:42:50.000' AS DateTime), 195, 195, NULL, N'T1', N'1', NULL, 1)
INSERT [dbo].[Tracking_Resource_Groups] ([ResourceGroup_DBID], [ParentResourceGroup_DBID], [FenceLayer_DBID], [Description_En], [Description_Ar], [Creation_Date], [Modification_Date], [Modified_By], [Created_By], [Res_Group_Image], [Name_En], [Name_Ar], [VisibleForParent], [IsRetired]) VALUES (17, 3, NULL, N'aaa', N'a', CAST(N'2014-11-26 12:13:53.000' AS DateTime), CAST(N'2014-11-26 12:14:01.000' AS DateTime), 195, 195, NULL, N'a', N'a', NULL, 1)
SET IDENTITY_INSERT [dbo].[Tracking_Resource_Groups] OFF
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (4, 7, 1, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (5, 7, 2, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (6, 8, 1, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (7, 8, 2, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (8, 9, 1, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (9, 9, 2, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (10, 10, 1, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (11, 10, 2, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (12, 11, 1, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (13, 11, 2, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (14, 12, 1, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (15, 12, 2, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (16, 13, 1, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (17, 13, 2, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (18, 14, 1, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (19, 14, 2, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (20, 15, 1, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (21, 15, 2, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (24, 17, 1, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (25, 17, 3, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (30, 8, 2, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (31, 13, 3, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (32, 14, 3, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (33, 15, 3, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (36, 21, 5, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (38, 14, 2, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (39, 14, 3, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Tracking_Resource_ResGroup_Ass] ([Track_Resource_ResGrp_DBID], [Resource_DBID], [ResourceGroup_DBID], [Creation_Date], [Created_By], [Modification_Date], [Modified_By], [IsRetired]) VALUES (40, 23, 1, CAST(N'2014-12-07 12:09:24.000' AS DateTime), 195, NULL, NULL, 0)
SET IDENTITY_INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ON 

INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (1, 225, 1, CAST(N'2014-10-26 13:47:59.000' AS DateTime), NULL, 195, NULL, 0, 1)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (2, 225, 2, CAST(N'2014-10-26 13:49:25.000' AS DateTime), NULL, 195, NULL, 0, 1)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (3, 225, 3, CAST(N'2014-10-26 13:49:55.000' AS DateTime), NULL, 195, NULL, 0, 1)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (5, 227, 2, CAST(N'2014-10-27 14:14:13.000' AS DateTime), NULL, 195, NULL, 0, 0)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (6, 229, 3, CAST(N'2014-10-27 14:14:22.000' AS DateTime), CAST(N'2014-11-16 16:44:14.000' AS DateTime), 195, 195, 1, 0)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (7, 227, 5, CAST(N'2014-10-27 14:20:12.000' AS DateTime), NULL, 196, NULL, 0, 1)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (10, 225, 8, CAST(N'2014-11-05 16:05:32.000' AS DateTime), CAST(N'2014-11-05 16:05:53.000' AS DateTime), 195, 195, 1, 1)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (11, 225, 9, CAST(N'2014-11-06 09:43:42.000' AS DateTime), CAST(N'2014-11-06 10:26:20.000' AS DateTime), 195, 195, 1, 1)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (12, 227, 9, CAST(N'2014-11-06 09:43:57.000' AS DateTime), CAST(N'2014-11-06 10:26:20.000' AS DateTime), 195, 195, 1, 0)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (13, 229, 9, CAST(N'2014-11-06 09:52:07.000' AS DateTime), CAST(N'2014-11-06 10:26:20.000' AS DateTime), 195, 195, 1, 0)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (14, 225, 10, CAST(N'2014-11-09 10:54:26.000' AS DateTime), CAST(N'2014-11-09 11:12:39.000' AS DateTime), 195, 195, 1, 1)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (15, 227, 10, NULL, CAST(N'2014-11-09 11:12:39.000' AS DateTime), NULL, 195, 1, 0)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (16, 229, 10, CAST(N'2014-11-09 10:55:45.000' AS DateTime), CAST(N'2014-11-09 11:12:39.000' AS DateTime), 195, 195, 1, 0)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (17, 225, 11, CAST(N'2014-11-09 11:15:41.000' AS DateTime), CAST(N'2014-11-09 11:15:48.000' AS DateTime), 195, 195, 1, 1)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (18, 225, 12, CAST(N'2014-11-09 11:16:11.000' AS DateTime), CAST(N'2014-11-09 11:17:38.000' AS DateTime), 195, 195, 1, 1)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (19, 225, 13, CAST(N'2014-11-09 11:17:59.000' AS DateTime), CAST(N'2014-11-09 11:18:52.000' AS DateTime), 195, 195, 1, 1)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (20, 227, 13, CAST(N'2014-11-09 11:18:10.000' AS DateTime), CAST(N'2014-11-09 11:18:52.000' AS DateTime), 195, 195, 1, 0)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (21, 225, 14, CAST(N'2014-11-09 12:02:07.000' AS DateTime), CAST(N'2014-11-09 12:10:57.000' AS DateTime), 195, 195, 1, 1)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (22, 225, 15, CAST(N'2014-11-10 13:10:04.000' AS DateTime), CAST(N'2014-11-11 15:15:50.000' AS DateTime), 195, 195, 1, 1)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (23, 225, 16, CAST(N'2014-11-13 10:37:47.000' AS DateTime), CAST(N'2014-11-13 10:42:50.000' AS DateTime), 195, 195, 1, 1)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (24, 229, 16, NULL, CAST(N'2014-11-13 10:42:50.000' AS DateTime), NULL, 195, 1, 0)
INSERT [dbo].[Tracking_ResourceGroup_GeoRole] ([Tracking_ResGrp_GeoRole_DBID], [GEO_RoleID], [ResourceGroup_DBID], [Creation_Date], [Modification_Date], [Created_By], [Modified_By], [IsRetired], [IsOwner]) VALUES (25, 225, 17, CAST(N'2014-11-26 12:13:53.000' AS DateTime), CAST(N'2014-11-26 12:14:01.000' AS DateTime), 195, 195, 1, 1)
SET IDENTITY_INSERT [dbo].[Tracking_ResourceGroup_GeoRole] OFF

--Exclude HEAT Sensor
SET IDENTITY_INSERT [dbo].[RESOURCE_EXECLUDED_SENSORS] ON 
INSERT INTO RESOURCE_EXECLUDED_SENSORS (RESOURCE_DBID, SENSOR_DBID) VALUES(1, 3);
SET IDENTITY_INSERT [dbo].[RESOURCE_EXECLUDED_SENSORS] OFF

--Add fence layer ref
update Tracking_Resource_Groups set FenceLayer_DBID = 1 where ResourceGroup_DBID = 1;

update Tracking_Resource_ResGroup_Ass set IsRetired = 0 WHERE Resource_DBID = 7;
update Tracking_Resource_Groups set FenceLayer_DBID = 1 where ResourceGroup_DBID = 1;
insert  Tracking_ResGroup_Fences_Ass(ResourceGroup_DBID, Fence_ID,IsRetired, GeoFenceRule) VALUES (1,650, 0,'In');
insert  Tracking_ResGroup_Fences_Ass(ResourceGroup_DBID, Fence_ID,IsRetired, GeoFenceRule) VALUES (1,651, 0,'Out');