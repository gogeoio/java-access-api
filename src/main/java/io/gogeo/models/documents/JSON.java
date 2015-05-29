package io.gogeo.models.documents;

public class JSON {
	private Geom geom;
	private Properties properties;

	public JSON() {
		
	}
	
	public Geom getGeom() {
		return geom;
	}

	public void setGeom(Geom geom) {
		this.geom = geom;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}
