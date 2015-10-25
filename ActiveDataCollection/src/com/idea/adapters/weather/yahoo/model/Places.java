package com.idea.adapters.weather.yahoo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Places {
	
	@XmlElement
	protected String places;
	
	public Places() {
	}

	public String getPlace() {
		return places;
	}

	public void setPlace(String place) {
		this.places = place;
	}
	
	
}
