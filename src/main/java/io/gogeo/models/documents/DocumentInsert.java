package io.gogeo.models.documents;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class DocumentInsert {

@Expose
private List<JSON> json = new ArrayList<JSON>();

/**
* 
* @return
* The json
*/
public List<JSON> getJson() {
return json;
}

/**
* 
* @param json
* The json
*/
public void setJson(List<JSON> json) {
this.json = json;
}

}