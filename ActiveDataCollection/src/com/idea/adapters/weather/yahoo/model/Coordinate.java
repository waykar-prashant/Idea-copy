package com.idea.adapters.weather.yahoo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Coordinate {

	@XmlElement
	protected Float longitude;

	@XmlElement
	protected Float latitude;

	public Coordinate() {

	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "Coordinate [longitude=" + longitude + ", latitude=" + latitude + "]";
	}

}
