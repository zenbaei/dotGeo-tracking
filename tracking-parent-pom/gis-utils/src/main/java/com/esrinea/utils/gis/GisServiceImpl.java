package com.esrinea.utils.gis;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.esri.arcgis.datasourcesGDB.AccessWorkspaceFactory;
import com.esri.arcgis.datasourcesGDB.FileGDBWorkspaceFactory;
import com.esri.arcgis.datasourcesGDB.SdeWorkspaceFactory;
import com.esri.arcgis.datasourcesfile.ArcInfoWorkspaceFactory;
import com.esri.arcgis.datasourcesfile.ShapefileWorkspaceFactory;
import com.esri.arcgis.geodatabase.FeatureClass;
import com.esri.arcgis.geodatabase.FeatureDatasetName;
import com.esri.arcgis.geodatabase.IDataset;
import com.esri.arcgis.geodatabase.IDatasetName;
import com.esri.arcgis.geodatabase.IEnumDataset;
import com.esri.arcgis.geodatabase.IEnumDatasetName;
import com.esri.arcgis.geodatabase.IFeature;
import com.esri.arcgis.geodatabase.IFeatureClass;
import com.esri.arcgis.geodatabase.IFeatureClassName;
import com.esri.arcgis.geodatabase.IFeatureCursor;
import com.esri.arcgis.geodatabase.IFields;
import com.esri.arcgis.geodatabase.IQueryFilter;
import com.esri.arcgis.geodatabase.QueryFilter;
import com.esri.arcgis.geodatabase.Workspace;
import com.esri.arcgis.geodatabase.WorkspaceFactory;
import com.esri.arcgis.geodatabase.WorkspaceName;
import com.esri.arcgis.geodatabase.esriDatasetType;
import com.esri.arcgis.geometry.IGeometry;
import com.esri.arcgis.geometry.IPoint;
import com.esri.arcgis.geometry.IRelationalOperator;
import com.esri.arcgis.geometry.ITopologicalOperator;
import com.esri.arcgis.geometry.Point;
import com.esri.arcgis.geometry.esriGeometryDimension;
import com.esri.arcgis.geometry.esriGeometryType;
import com.esri.arcgis.interop.AutomationException;
import com.esri.arcgis.system.AoInitialize;
import com.esri.arcgis.system.EngineInitializer;
import com.esri.arcgis.system.esriLicenseProductCode;
import com.esri.arcgis.system.esriLicenseStatus;

@Service
public class GisServiceImpl implements GisService {
	private final Logger LOG = Logger.getLogger(GisServiceImpl.class);
	private Workspace workspace;
	private WorkspaceFactory workspaceFactory;
	private Map<String, IFeatureClass> featureClasses = new HashMap<String, IFeatureClass>();

	/**
	 * For test
	 * 
	 * @param args
	 */
	public void initalize() {
		try {
			// Initialize engine console application
			EngineInitializer.initializeEngine();

			// Initialize ArcGIS license
			AoInitialize aoInit = new AoInitialize();
			initializeArcGISLicenses(aoInit);

			// Ensure any ESRI libraries are unloaded in the correct order
			aoInit.shutdown();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println("Sample failed.  Exiting...");
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Checks to see if an ArcGIS Engine Runtime license or an Basic License is available. If so, then the appropriate ArcGIS License is initialized.
	 * 
	 * @param aoInit
	 *            The AoInitialize object instantiated in the main method.
	 */
	private void initializeArcGISLicenses(AoInitialize aoInit) {
		try {
			if (aoInit.isProductCodeAvailable(esriLicenseProductCode.esriLicenseProductCodeArcServer) == esriLicenseStatus.esriLicenseAvailable) {
				aoInit.initialize(esriLicenseProductCode.esriLicenseProductCodeArcServer);
			} else if (aoInit.isProductCodeAvailable(esriLicenseProductCode.esriLicenseProductCodeEngine) == esriLicenseStatus.esriLicenseAvailable)
				aoInit.initialize(esriLicenseProductCode.esriLicenseProductCodeEngine);
			else if (aoInit.isProductCodeAvailable(esriLicenseProductCode.esriLicenseProductCodeStandard) == esriLicenseStatus.esriLicenseAvailable)
				aoInit.initialize(esriLicenseProductCode.esriLicenseProductCodeStandard);
			else {
				System.err.println("Could not initialize an Engine or Standerd License. Exiting application.");
				System.exit(-1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a workspace based on datatype
	 * 
	 * @param Type
	 *            - datatype {Shape|Access|ArcInfo|SDE}
	 * @param Input
	 *            - a directory path on disk where the data exists or the filepath
	 * @throws IOException
	 *             if couldn't browse data
	 */
	public void browse(String dataType, String inputPath) throws IOException {
		try {
			String fileName = null;
			WorkspaceFactory workspaceFactory = null;

			// Determine what type of workspace factory to instantiate
			if (dataType.equalsIgnoreCase("Access")) {
				// Access - use the common dialog to browse for .mdb file
				fileName = inputPath;

				if (fileName.lastIndexOf(".mdb") < 0) {
					return;
				}

				workspaceFactory = new WorkspaceFactory(new AccessWorkspaceFactory());
			} else if (dataType.equalsIgnoreCase("ArcInfo")) {
				// ArcInfo - use the OpenWorkspace form
				fileName = inputPath;

				workspaceFactory = new WorkspaceFactory(new ArcInfoWorkspaceFactory());
			} else if (dataType.equalsIgnoreCase("SDE")) {
				// SDE - use the common dialog to browse for SDE connection files
				fileName = inputPath;

				if (fileName.lastIndexOf(".sde") < 0) {
					return;
				}

				workspaceFactory = new WorkspaceFactory(new SdeWorkspaceFactory());
			} else if (dataType.equalsIgnoreCase("Shapefile")) {
				// Shapefile - use the OpenWorkspace formfiles
				fileName = inputPath;

				workspaceFactory = new WorkspaceFactory(new ShapefileWorkspaceFactory());
			} else if (dataType.equalsIgnoreCase("geodatabase")) {
				fileName = inputPath;
				workspaceFactory = new WorkspaceFactory(new FileGDBWorkspaceFactory());
			}

			System.out.println("Workspace type: " + workspaceFactory.getWorkspaceDescription(false));

			// Get the workspace
			Workspace workspace = new Workspace(workspaceFactory.openFromFile(fileName, 0));

			IDatasetName datasetName = null;
			IEnumDatasetName datasetNames = null;

			if (workspaceFactory.getWorkspaceDescription(false).equalsIgnoreCase("Shapefiles")) {
				// Shapefiles are not within a feature dataset
				datasetNames = workspace.getDatasetNames(esriDatasetType.esriDTFeatureClass);

				// Get the first dataset name
				datasetName = datasetNames.next();
				while (datasetName != null) {
					System.out.print("\tFeatureClass: " + datasetName.getName());
					listFeatureClasses(workspaceFactory, workspace, datasetName.getName(), datasetName.getName());

					datasetName = datasetNames.next();
				}
			} else {
				datasetNames = workspace.getDatasetNames(esriDatasetType.esriDTFeatureDataset);

				// Get the first dataset name
				datasetName = datasetNames.next();
				while (datasetName != null) {
					System.out.print("\tDataset: " + datasetName.getName());
					listDatasets(workspaceFactory, workspace, datasetName.getName());

					datasetName = datasetNames.next();
				}
			}
		} catch (IOException e) {
			throw e;
		}
	}

	/**
	 * List Feature classes in the dataset
	 * 
	 * @param workspaceFactory
	 * @param workspace
	 * @param featureClasses
	 * @param datasetNameString
	 * @throws IOException
	 */
	private void listFeatureClasses(WorkspaceFactory workspaceFactory, Workspace workspace, String featureClasses, String datasetNameString) throws IOException {
		try {
			FeatureClass featureClass = null;

			if (workspaceFactory.getWorkspaceDescription(false).equalsIgnoreCase("ArcInfo Workspace")) {
				String featureClassNameString = datasetNameString + ":" + featureClasses;

				featureClass = new FeatureClass(workspace.openFeatureClass(featureClassNameString));
			} else {
				featureClass = new FeatureClass(workspace.openFeatureClass(featureClasses));
			}

			String shp = null;

			switch (featureClass.getShapeType()) {
			case esriGeometryType.esriGeometryBezier3Curve:
				shp = "Bezier Curve";
				break;

			case esriGeometryType.esriGeometryCircularArc:
				shp = "Circular Arc";
				break;

			case esriGeometryType.esriGeometryEnvelope:
				shp = "Envelope";
				break;

			case esriGeometryType.esriGeometryLine:
				shp = "Line";
				break;

			case esriGeometryType.esriGeometryMultiPatch:
				shp = "MultiPatch";
				break;

			case esriGeometryType.esriGeometryMultipoint:
				shp = "MultiPoint";
				break;

			case esriGeometryType.esriGeometryNull:
				shp = "Null Geometry";
				break;

			case esriGeometryType.esriGeometryPath:
				shp = "Path";
				break;

			case esriGeometryType.esriGeometryPoint:
				shp = "Point";
				break;

			case esriGeometryType.esriGeometryPolygon:
				shp = "Polygon";
				break;

			case esriGeometryType.esriGeometryPolyline:
				shp = "Polyline";
				break;

			case esriGeometryType.esriGeometryRay:
				shp = "Ray";
				break;

			case esriGeometryType.esriGeometryRing:
				shp = "Ring";
				break;

			case esriGeometryType.esriGeometrySphere:
				shp = "Sphere";
				break;

			case esriGeometryType.esriGeometryTriangleFan:
				shp = "Triangle Fan";
				break;

			default:
				System.out.println("shpType: " + featureClass.getShapeType());
				shp = "unsupported";
				break;
			}

			System.out.println("\tShapetype: " + shp);
		} catch (IOException ex) {
			throw ex;
		}
	}

	/**
	 * List datasets in the workspace
	 * 
	 * @param workspaceFactory
	 * @param workspace
	 * @param datasetName
	 * @throws IOException
	 */
	private void listDatasets(WorkspaceFactory workspaceFactory, Workspace workspace, String datasetName) throws IOException {
		try {
			// Create FeatureDataset name object and Dataset name object
			FeatureDatasetName localDatasetName = new FeatureDatasetName();

			// Set the workspace name reference to the workspace name
			localDatasetName.setWorkspaceNameByRef((WorkspaceName) workspace.getFullName());
			localDatasetName.setName(datasetName);

			// Get feature class names in the dataset
			// DatasetNames featureClassNames = (DatasetNames) localDatasetName.getFeatureClassNames();

			IEnumDatasetName featureClassNames = localDatasetName.getFeatureClassNames();

			IFeatureClassName featureClassName = null;
			IDatasetName anotherDatasetName = featureClassNames.next();
			if (anotherDatasetName != null) {
				featureClassName = (IFeatureClassName) anotherDatasetName;
			} else {
				featureClassName = null;
			}

			IDatasetName datasetNameOnFeatureClassName = null;
			while (featureClassName != null) {
				datasetNameOnFeatureClassName = (IDatasetName) featureClassName;
				// TODD: code that loads what feature classes are in dataset name
				System.out.println("Feature Classes: " + datasetNameOnFeatureClassName.getName());
				listFeatureClasses(workspaceFactory, workspace, datasetNameOnFeatureClassName.getName(), datasetName);

				anotherDatasetName = featureClassNames.next();
				if (anotherDatasetName != null) {
					featureClassName = (IFeatureClassName) anotherDatasetName;
				} else {
					featureClassName = null;
				}
			}
		} catch (IOException ex) {
			throw ex;
		}
	}

	public void cacheGdbDataSource(String gdbDatasource) throws UnknownHostException, IOException {
		LOG.info("Caching GDB Datasource.");
		// TODO: Make sure file is opened only once and its content is cached.
		// Initialize engine console application
		EngineInitializer.initializeServer(esriLicenseProductCode.esriLicenseProductCodeArcServer);

		// Initialize ArcGIS license
		AoInitialize aoInit = new AoInitialize();
		initializeArcGISLicenses(aoInit);

		workspaceFactory = new WorkspaceFactory(new FileGDBWorkspaceFactory());
		// Get the workspace
		workspace = new Workspace(workspaceFactory.openFromFile(gdbDatasource, 0));
		// TODO: handle whether a gdb has datasets or feature class directly
		IEnumDatasetName enumDatasetName = workspace.getDatasetNames(esriDatasetType.esriDTFeatureDataset);
		IDatasetName datasetName = enumDatasetName.next();
		if (datasetName != null) {
			while (datasetName != null) {
				IFeatureClass feature = workspace.openFeatureClass(datasetName.getName());
				featureClasses.put(datasetName.getName(), feature);
				LOG.info(String.format("Dataset with name %s has been cached.", datasetName.getName()));
				datasetName = enumDatasetName.next();
			}
		} else {
			LOG.info(String.format("GDB Datasource with name %s doesn't contain datasets.", gdbDatasource));
			IEnumDataset datasets = workspace.getSubsets();
			IDataset dataset = datasets.next();
			LOG.info(String.format("DataSubSet Name: %s", dataset.getName()));
			IFeatureClass featureClass = workspace.openFeatureClass(dataset.getName());
			featureClasses.put(dataset.getName(), featureClass);
			LOG.info(String.format("DataSubSet with name %s has been cached.", dataset.getName()));
		}
		aoInit.shutdown();

	}

	public boolean isInFence(String gdbDatasource, String datasetName, String queryByField, int id, double xCoord, double yCoord) throws UnknownHostException, IOException, IllegalStateException {
		LOG.debug(String.format("isInFence called with parameters, GDBDatasource %s, queryByField %s, ID %s, Xcoord %s, Ycoord %s", gdbDatasource, queryByField, id, xCoord, yCoord));

		if (!featureClasses.containsKey(datasetName)) {
			cacheGdbDataSource(gdbDatasource);
		}

		IFeature feature = queryFeature(featureClasses.get(datasetName), queryByField, id);
		if (feature == null) {
			String msg = String.format("No Feature found with criteria of %s= %s.", queryByField, id);
			LOG.info(msg);
			throw new IllegalStateException(msg);
		}
		boolean contains = contains(feature, xCoord, yCoord);
		if (contains) {
			LOG.debug("Point is within fence");
		} else {
			LOG.debug("Point is out of fence");
		}
		return contains;
	}

	public IFeature queryFeature(IFeatureClass featureClass, String fieldName, int id) throws UnknownHostException, IOException {
		LOG.debug(String.format("queryFeature with criteria of %s= %s", fieldName, id));
		IFeature feature = null;
		IQueryFilter filter = new QueryFilter();
		filter.setWhereClause(fieldName + "=" + id);
		IFeatureCursor cursor = featureClass.search(filter, true);
		feature = cursor.nextFeature();
		return feature;
	}

	public void listFields(IFeatureClass featureClass) throws AutomationException, IOException {
		IFields iFields = featureClass.getFields();
		for (int i = 0; i < iFields.getFieldCount(); i++) {
			System.out.println("Field: " + iFields.getField(i).getName());
		}
	}

	public boolean contains(IFeature feature, double xCoord, double yCoord) throws UnknownHostException, IOException {
		LOG.debug(String.format("Creating Point with X %s and Y %s and intersecting it with feature.", xCoord, yCoord));
		IPoint point = new Point();
		point.setX(xCoord);
		point.setY(yCoord);
		point.setSpatialReferenceByRef(feature.getExtent().getSpatialReference());
		boolean contains = ((IRelationalOperator) feature.getShape()).contains(point);
		LOG.debug(String.format("Point is %s feature.", contains ? "with" : "out of"));
		return contains;
	}

	public IGeometry intersect(IFeature feature, double xCoord, double yCoord) throws UnknownHostException, IOException {
		IPoint point = new Point();
		point.setX(xCoord);
		point.setY(yCoord);
		point.setSpatialReferenceByRef(feature.getExtent().getSpatialReference());
		return ((ITopologicalOperator) feature.getShape()).intersect(point, esriGeometryDimension.esriGeometry0Dimension);
	}

	@Override
	public String getAddress(String gdbDatasource, String datasetName, String fieldName, double xCoord, double yCoord) throws UnknownHostException, IOException {
		if (!featureClasses.containsKey(datasetName)) {
			cacheGdbDataSource(gdbDatasource);
		}
		if (featureClasses.get(datasetName) == null) {
			LOG.info(String.format("DataSet with name %s is not found in GDB Datasource %s.", datasetName, gdbDatasource));
			return "";
		}
		IFeatureCursor cursor = featureClasses.get(datasetName).search(null, true);
		IFeature feature = cursor.nextFeature();
		while (feature != null) {
			IGeometry geometry = intersect(feature, xCoord, yCoord);
			if (geometry != null) {
				break;
			}
			feature = cursor.nextFeature();
		}
		String address = (String) feature.getValue(feature.getFields().findField(fieldName));
		LOG.debug(String.format("Point's %s and %s address is %s.", xCoord, yCoord, address));
		return address;
	}
}
