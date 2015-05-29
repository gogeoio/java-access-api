package io.gogeo.models.documents;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

public class Geom {
	@Expose
	private String type;
	@Expose
	private List<Float> coordinates = new ArrayList<Float>();

	public Geom() {
	}

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return The coordinates
	 */
	public List<Float> getCoordinates() {
		return coordinates;
	}

	/**
	 * 
	 * @param coordinates
	 *            The coordinates
	 */
	public void setCoordinates(List<Float> coordinates) {
		this.coordinates = coordinates;
	}
}
