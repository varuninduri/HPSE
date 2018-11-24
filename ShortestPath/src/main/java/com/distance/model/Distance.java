package com.distance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Validated
@Document
public class Distance {
	

	@Id
	private String Id;
	@JsonProperty("nodes")
	private String nodes;
	@JsonProperty("filepath")
	private String filepath;
	@JsonProperty("output")
	private String output;
	public String getId() {
		return Id;
	}
	public void setId(String  id) {
		Id = id;
	}
	public String getNodes() {
		return nodes;
	}
	public void setNodes(String nodes) {
		this.nodes = nodes;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
}
