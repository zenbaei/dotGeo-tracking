--SEQUENCE_STORE Table is used by the Java application
CREATE TABLE dbo.SEQUENCE_STORE(SEQ_NAME VARCHAR(255) PRIMARY KEY, SEQ_VALUE BIGINT NOT NULL);
ALTER TABLE dbo.alerts add DeviceType_DBID int REFERENCES tracking_device_types(DeviceType_DBID);
ALTER TABLE dbo.tracking_resource_livefeeds ADD Resource_livefeeds_DBID int NOT NULL;
SET IDENTITY_INSERT dbo.sensors_liveFeeds OFF;
ALTER TABLE dbo.sensors_liveFeeds ADD Sensor_LiveFeeds_ID INT;--TEMP UNTIL IDENTITY IS REMOVED FROM SENSOR_LIVEFEEDS_ID
ALTER TABLE dbo.alert_LiveFeeds ADD Alert_LiveFeeds_ID INT; --TEMP UNTIL IDENTITY IS REMOVED FROM ALERT_LIVEFEEDS_ID
INSERT INTO SEQUENCE_STORE VALUES ('RESOURCE_LIVE_FEEDS', 0);
INSERT INTO SEQUENCE_STORE VALUES ('ALERT_LIVE_FEEDS', 0);
INSERT INTO SEQUENCE_STORE VALUES ('SENSOR_LIVE_FEEDS', 0);




INSERT INTO TRACKING_DEVICE_TYPES (DEVICETYPE_DESC, ISRETIRED) VALUES ('ENFORA 5002', 0);

INSERT INTO TRACKING_DEVICES (DEVICETYPE_DBID, ISRETIRED) VALUES (1,0);

INSERT INTO TRACKING_RESOURCES (DEVICE_DBID, ISRETIRED) VALUES(1,0);

INSERT INTO SENSORS (DEVICETYPE_DBID, NAME_EN, ISRETIRED) VALUES(1, 'OIL',0);
INSERT INTO SENSORS (DEVICETYPE_DBID, NAME_EN, ISRETIRED) VALUES(1, 'TEMP',0);
INSERT INTO SENSORS (DEVICETYPE_DBID, NAME_EN, ISRETIRED) VALUES(1, 'HEAT',1);
INSERT INTO SENSORS (DEVICETYPE_DBID, NAME_EN, ISRETIRED) VALUES(1, 'AIR',0);

--Exclude HEAT Sensor
INSERT INTO RESOURCE_EXECLUDED_SENSORS (RESOURCE_DBID, SENSOR_DBID) VALUES(1, 3);

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

--Alerts
INSERT INTO dbo.Alerts (name_en, devicetype_dbid, ISRETIRED) VALUES ('Oil Alert', 1,0);
INSERT INTO dbo.Alerts (name_en, devicetype_dbid, ISRETIRED) VALUES ('Temp Alert', 1,0);
INSERT INTO dbo.Alerts (name_en, devicetype_dbid, ISRETIRED) VALUES ('Air Alert', 1,1);
INSERT INTO dbo.Alerts (name_en, devicetype_dbid, ISRETIRED) VALUES ('Compound Alert', 1,0);
INSERT INTO dbo.Alerts (name_en, devicetype_dbid, ISRETIRED) VALUES ('Compound Alert 2', 1,0);


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

--Exclude Oil Alert
--INSERT INTO dbo.RESOURCE_EXECLUDED_ALERTS(RESOURCE_DBID, ALERT_DBID) VALUES (1, 1);


/*
SELECT * FROM TRACKINGFINALV1.dbo.alert_configuration;
SELECT * FROM dbo.Alerts;
SELECT * FROM dbo.Alert_Configuration;
SELECT * FROM dbo.Sensors;
SELECT * FROM dbo.Sensor_Configuration;
DELETE FROM dbo.Alert_Configuration;
SELECT * FROM TrackingFinalV1.dbo.sensor_configuration;
SELECT * FROM sensor_configuration;
SELECT * FROM TrackingFinalV1.dbo.sensors_liveFeeds;
SELECT * FROM dbo.Resource_Execluded_Alerts;
*/
