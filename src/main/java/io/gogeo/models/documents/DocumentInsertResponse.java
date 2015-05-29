package io.gogeo.models.documents;

import java.util.List;

public class DocumentInsertResponse {
	private String msg;
	private String format;
	private List<JSON> json;

	public DocumentInsertResponse() {
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public List<JSON> getJson() {
		return json;
	}

	public void setJson(List<JSON> json) {
		this.json = json;
	}
}
