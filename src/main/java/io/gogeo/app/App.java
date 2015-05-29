package io.gogeo.app;

import io.gogeo.models.collections.Collection;
import io.gogeo.models.databases.Database;
import io.gogeo.models.documents.Document;
import io.gogeo.models.documents.DocumentInsert;
import io.gogeo.models.documents.Geom;
import io.gogeo.models.documents.JSON;
import io.gogeo.models.documents.Properties;
import io.gogeo.services.GogeoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class App {
	private final static String APIKEY = "123";
	private final static String ENDPOINT = "http://api.gogeo.io/1.0";
	private final static String DATABASENAME = "db_test";
	private final static String COLLECTIONNAME = "coll_test2";

	private final RequestInterceptor requestInterceptor;
	private final RestAdapter restAdapter;
	private final GogeoService service;

	/**
	 * This works just in Java 7 or high. If you are using a lower version
	 * comment this method
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getJava7NativeAuthorization() {
		final String userAndPassword = APIKEY + ":";
		String encoded = DatatypeConverter.printBase64Binary(userAndPassword
				.getBytes());
		return "Basic " + encoded;
	}

	/**
	 * This method is the same proposal of 'getJava7NativeAuthorization', but
	 * your performance is 4 times slower. This works with apache commoms codec.
	 * 
	 * @return
	 */
	private String getApacheAuthorization() {
		final String userAndPassword = APIKEY + ":";
		String encoded = Base64.encodeBase64String(userAndPassword.getBytes());
		return "Basic " + encoded;
	}

	public App() {
		requestInterceptor = new RequestInterceptor() {
			public void intercept(RequestFacade request) {
				request.addHeader("Authorization", getApacheAuthorization());
			}
		};

		// Creating a Rest adapter to do request and add the interceptor to it
		restAdapter = new RestAdapter.Builder().setEndpoint(ENDPOINT)
				.setRequestInterceptor(requestInterceptor).build();

		// Adding gogeo services defined in GogeoService class to the rest
		// Client (retrofit)
		service = restAdapter.create(GogeoService.class);

		execute();
	}

	public void list() {
		List<Document> docs = service.listDocuments(DATABASENAME,
				COLLECTIONNAME);
		System.out.println("[");
		for (Document d : docs) {
			System.out.println("{");
			for (Entry<String, Object> en : d.entrySet()) {
				System.out.println(en.getKey() + " : " + en.getValue());
			}
			System.out.println("}");
		}
		System.out.println("]");
	}
	
	public DocumentInsert generateDocumentToInsert() {
		Geom geom = new Geom();
		ArrayList<Float> coordinates = new ArrayList<Float>();
		coordinates.add(new Float(-118.14));
		coordinates.add(new Float(-34.18));
		geom.setCoordinates(coordinates);
		geom.setType("Point");

		Properties props = new Properties();
		props.put("code_text", "123456");
		props.put("name_text", "Roberto Rodrigues Junior");
		props.put("employees_int", 500);
		props.put("revenue_long", 25);

		JSON json = new JSON();
		json.setGeom(geom);
		json.setProperties(props);

		List<JSON> jsonDocs = new ArrayList<JSON>(1);
		jsonDocs.add(json);

		DocumentInsert document = new DocumentInsert();
		document.setJson(jsonDocs);
		
		return document;
	}

	public static void main(String[] args) {
		new App();
	}

	/**
	 * The Execution of a simple sample of gogeo usage in JAVA.
	 */
	public void execute() {
		// Define the interceptor, add authentication headers. All request will
		// pass by 'intercept' method.

		// Try to create the database, if it exist an error is printed on screem
		// with Error Code 400
		try {
			Database database = new Database();
			database.setDatabaseName(DATABASENAME);
			service.createDatabase(database);
		} catch (Exception e) {
			System.err.println("Error in create database: " + e.getMessage());
		}

		// List the Databases of the user.
		List<Database> databases = service.listDatabases();
		for (Database db : databases) {
			System.out.println("\t" + db.getId() + " --> "
					+ db.getDatabaseName());
		}

		// Try to create the collection, if it exist an error is printed on
		// screem with Error Code 400
		try {
			Collection collection = new Collection();
			collection.setCollectionName(COLLECTIONNAME);
			service.createCollection(DATABASENAME, collection);
		} catch (Exception e) {
			System.err.println("Error in create collection: " + e.getMessage());
		}

		// List the Collections in the Database.
		List<Collection> collections = service.listCollections(DATABASENAME);
		System.out.println("Collections in database: " + DATABASENAME);
		for (Collection coll : collections) {
			System.out.println("\t" + coll.getId() + " --> "
					+ coll.getCollectionName() + ": " + coll.getItems());
		}
		System.out.println();

		try {
			service.insertDocument(DATABASENAME, COLLECTIONNAME, generateDocumentToInsert());
			list();
		} catch (Exception e) {
			System.err.println("Error in insert document: " + e.getMessage());
			e.printStackTrace();
		}
	}
}