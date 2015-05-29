package io.gogeo.models.collections;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Collection {

	@SerializedName("database_id")
	@Expose
	private String databaseId;
	@Expose
	private String description;
	@Expose
	private int items;
	@Expose
	private Object metadata;
	@Expose
	private Object origin;
	@SerializedName("public")
	@Expose
	private boolean _public;
	@SerializedName("user_id")
	@Expose
	private Object userId;
	@Expose
	private String username;
	@Expose
	private String id;
	@SerializedName("collection_name")
	@Expose
	private String collectionName;

	/**
	 * 
	 * @return The databaseId
	 */
	public String getDatabaseId() {
		return databaseId;
	}

	/**
	 * 
	 * @param databaseId
	 *            The database_id
	 */
	public void setDatabaseId(String databaseId) {
		this.databaseId = databaseId;
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
	 * @return The items
	 */
	public int getItems() {
		return items;
	}

	/**
	 * 
	 * @param items
	 *            The items
	 */
	public void setItems(int items) {
		this.items = items;
	}

	/**
	 * 
	 * @return The metadata
	 */
	public Object getMetadata() {
		return metadata;
	}

	/**
	 * 
	 * @param metadata
	 *            The metadata
	 */
	public void setMetadata(Object metadata) {
		this.metadata = metadata;
	}

	/**
	 * 
	 * @return The origin
	 */
	public Object getOrigin() {
		return origin;
	}

	/**
	 * 
	 * @param origin
	 *            The origin
	 */
	public void setOrigin(Object origin) {
		this.origin = origin;
	}

	/**
	 * 
	 * @return The _public
	 */
	public boolean isPublic() {
		return _public;
	}

	/**
	 * 
	 * @param _public
	 *            The public
	 */
	public void setPublic(boolean _public) {
		this._public = _public;
	}

	/**
	 * 
	 * @return The userId
	 */
	public Object getUserId() {
		return userId;
	}

	/**
	 * 
	 * @param userId
	 *            The user_id
	 */
	public void setUserId(Object userId) {
		this.userId = userId;
	}

	/**
	 * 
	 * @return The username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 *            The username
	 */
	public void setUsername(String username) {
		this.username = username;
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

	/**
	 * 
	 * @return The collectionName
	 */
	public String getCollectionName() {
		return collectionName;
	}

	/**
	 * 
	 * @param collectionName
	 *            The collection_name
	 */
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
}