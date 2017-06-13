package com.taotao.rest.pojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @JsonProperty 此注解用于属性上，作用是把该属性的名称序列化为另外一个名称，
 * 如把trueName属性序列化为name，@JsonProperty(value="name")。
 * 
 * @author Arqea
 */
public class CatNode {

	@JsonProperty("n")
	private String name;
	@JsonProperty("u")
	private String url;
	@JsonProperty("i")
	private List<?> item;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<?> getItem() {
		return item;
	}
	public void setItem(List<?> item) {
		this.item = item;
	}
	
}