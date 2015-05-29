package io.gogeo.services;

import io.gogeo.models.collections.Collection;
import io.gogeo.models.databases.Database;
import io.gogeo.models.documents.Document;
import io.gogeo.models.documents.DocumentInsert;
import io.gogeo.models.documents.DocumentInsertResponse;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface GogeoService {
	/**
	 * Create a database
	 * 
	 * @param database
	 * @return
	 */
	@POST("/databases")
	Database createDatabase(@Body Database database);

	/**
	 * List databases
	 * 
	 * @return
	 */
	@GET("/databases")
	List<Database> listDatabases();

	/**
	 * Get a database
	 * 
	 * @return
	 */
	@GET("/databases/{database}")
	Database getDatabase();

	/**
	 * Create a new collection
	 * 
	 * @param database
	 * @param collection
	 * @return
	 */
	@POST("/databases/{database}/collections")
	Collection createCollection(@Path("database") String database, @Body Collection collection);
	
	/**
	 * List collections
	 * 
	 * @param database
	 * @return
	 */
	@GET("/databases/{database}/collections")
	List<Collection> listCollections(@Path("database") String database);

	/**
	 * Get a collection
	 * 
	 * @param database
	 * @param collection
	 * @return
	 */
	@GET("/databases/{database}/collections/{collection}")
	Collection getCollection(@Path("database") String database,
			@Path("collection") String collection);

	/**
	 * Insert a document
	 * 
	 * @param database
	 * @param collection
	 * @param document
	 * @return
	 */
	@POST("/databases/{database}/collections/{collection}/documents.json")
	DocumentInsertResponse insertDocument(@Path("database") String database,
			@Path("collection") String collection, @Body DocumentInsert document);
	
	@GET("/databases/{database}/collections/{collection}/documents")
	List<Document> listDocuments(@Path("database") String database,
			@Path("collection") String collection);

}
