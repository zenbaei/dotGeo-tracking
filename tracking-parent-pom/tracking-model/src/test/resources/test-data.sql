INSERT INTO TRACKING_DEVICE_TYPES (DEVICETYPE_DESC, ISRETIRED) VALUES ('ENFORA 5002', 0);

INSERT INTO TRACKING_DEVICES (DEVICETYPE_DBID, ISRETIRED) VALUES (1,0);

INSERT INTO TRACKING_RESOURCES (DEVICE_DBID, ISRETIRED) VALUES(1,0);

INSERT INTO SENSORS (DEVICETYPE_DBID, NAME_EN, ISRETIRED) VALUES(1, 'OIL',0);
INSERT INTO SENSORS (DEVICETYPE_DBID, NAME_EN, ISRETIRED) VALUES(1, 'TEMP',0);
INSERT INTO SENSORS (DEVICETYPE_DBID, NAME_EN, ISRETIRED) VALUES(1, 'HEAT',0); --will be execluded

--Exclude HEAT Sensor
INSERT INTO RESOURCE_EXECLUDED_SENSORS (RESOURCE_DBID, SENSOR_DBID) VALUES(1, 3);

--Temp Sensor Configurations
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, MAXVALUE,MINVALUE,CONFIG_TEXT, ISRETIRED) values (2, 43.13846153, 25.0, 'Low', 0);
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, MAXVALUE,MINVALUE,CONFIG_TEXT, ISRETIRED) values (2, 90.0, 43.13846153, 'Med', 0);
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, MAXVALUE,MINVALUE,CONFIG_TEXT, ISRETIRED) values (2, 100.0, 90.0, 'High', 0);
--Oil Sensor Configurations
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, TEXTVALUE, ISRETIRED) values (1, 'In',0);
INSERT INTO SENSOR_CONFIGURATION(SENSOR_DBID, TEXTVALUE, ISRETIRED) values (1, 'Out',0);

--Alerts
INSERT INTO dbo.Alerts (name_en, devicetype_dbid, ISRETIRED) VALUES ('Oil Alert', 1,0);
INSERT INTO dbo.Alerts (name_en, devicetype_dbid, ISRETIRED) VALUES ('Temp Alert', 1,0);

--Temp Alert Configurations
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, ISRETIRED ) values (2, 1, 0);
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, ISRETIRED ) values (2, 2, 0);
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, ISRETIRED ) values (2, 3, 1);
--Oil Alert Configurations
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, ISRETIRED ) values (1, 4, 0);
INSERT INTO dbo.Alert_Configuration  (alert_dbid, sensorconfig_dbid, ISRETIRED ) values (1, 5, 0);

--Exclude Oil Alert
INSERT INTO dbo.RESOURCE_EXECLUDED_ALERTS(RESOURCE_DBID, ALERT_DBID) VALUES (1, 1);


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
