package com.idea.adapters.weather.yahoo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="boundingBox")
public class BoundingBox {
	@XmlElement
	private SouthWest southWest;
	
	@XmlElement
	private NorthEast northEast;

	public BoundingBox() {
	}

	

	public SouthWest getSouthWest() {
		return southWest;
	}



	public void setSouthWest(SouthWest southWest) {
		this.southWest = southWest;
	}



	public NorthEast getNorthEast() {
		return northEast;
	}



	public void setNorthEast(NorthEast northEast) {
		this.northEast = northEast;
	}



	@Override
	public String toString() {
		return "BoundingBox [southWest=" + southWest + ", northEast=" + northEast + "]";
	}

}
