package com.idea.adapters.weather.yahoo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class BoundingBox {
	@XmlElement
	private Coordinate southWest;
	
	@XmlElement
	private Coordinate northEast;

	public BoundingBox() {
	}

	public Coordinate getSouthWest() {
		return southWest;
	}

	public void setSouthWest(Coordinate southWest) {
		this.southWest = southWest;
	}

	public Coordinate getNorthEast() {
		return northEast;
	}

	public void setNorthEast(Coordinate northEast) {
		this.northEast = northEast;
	}

	@Override
	public String toString() {
		return "BoundingBox [southWest=" + southWest + ", northEast=" + northEast + "]";
	}

}
