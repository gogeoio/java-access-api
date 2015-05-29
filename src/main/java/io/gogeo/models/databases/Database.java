package io.gogeo.models.databases;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Database {

	@SerializedName("database_name")
	@Expose
	private String databaseName;
	@Expose
	private String description;
	@SerializedName("user_id")
	@Expose
	private String userId;
	@Expose
	private String id;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The databaseName
	 */
	public String getDatabaseName() {
		return databaseName;
	}

	/**
	 * 
	 * @param databaseName
	 *            The database_nametools/total
	 */
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	/**
	 * 
	 * @return The description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 *            The description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return The userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 
	 * @param userId
	 *            The user_id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}