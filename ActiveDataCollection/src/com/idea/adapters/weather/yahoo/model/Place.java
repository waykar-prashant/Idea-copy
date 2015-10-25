package com.idea.adapters.weather.yahoo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="place")
public class Place {

	/*
	 * <woeid>28717584</woeid> <placeTypeName code="20">Point of
	 * Interest</placeTypeName> <name>Sydney Opera House</name> <country
	 * type="Country" code="AU" woeid="23424748">Australia</country> <admin1
	 * type="State" code="AU-NSW" woeid="2344700">New South Wales</admin1>
	 * <admin2/> <admin3/> <locality1 type="Town"
	 * woeid="1105779">Sydney</locality1> <locality2/> <postal type=
	 * "Postal Code" woeid="12706662">2000</postal>
	 */
	@XmlElement
	protected int woeid;
	@XmlElement
	protected String placeTypeName;
	@XmlElement
	protected String name;
	@XmlElement
	protected String country;
	@XmlElement
	protected String admin1;
	@XmlElement
	protected String admin2;
	@XmlElement
	protected String admin3;
	@XmlElement
	protected String locality1;
	@XmlElement
	protected String locality2;
	@XmlElement
	protected String postal;
	@XmlElement
	protected Centroid centroid;
	@XmlElement
	protected BoundingBox boundingBox;
	@XmlElement
	protected int areaRank;
	@XmlElement
	protected int popRank;
	@XmlElement
	protected String timezone;

	public Place() {

	}

	public int getWoeid() {
		return woeid;
	}

	public void setWoeid(int woeid) {
		this.woeid = woeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAdmin1() {
		return admin1;
	}

	public void setAdmin1(String admin1) {
		this.admin1 = admin1;
	}

	public String getAdmin2() {
		return admin2;
	}

	public void setAdmin2(String admin2) {
		this.admin2 = admin2;
	}

	public String getAdmin3() {
		return admin3;
	}

	public void setAdmin3(String admin3) {
		this.admin3 = admin3;
	}

	public String getPlaceTypeName() {
		return placeTypeName;
	}

	public void setPlaceTypeName(String placeTypeName) {
		this.placeTypeName = placeTypeName;
	}


	public String getLocality1() {
		return locality1;
	}

	public void setLocality1(String locality1) {
		this.locality1 = locality1;
	}

	public String getLocality2() {
		return locality2;
	}

	public void setLocality2(String locality2) {
		this.locality2 = locality2;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	
	public Centroid getCentroid() {
		return centroid;
	}

	public void setCentroid(Centroid centroid) {
		this.centroid = centroid;
	}

	public BoundingBox getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}

	public int getAreaRank() {
		return areaRank;
	}

	public void setAreaRank(int areaRank) {
		this.areaRank = areaRank;
	}

	public int getPopRank() {
		return popRank;
	}

	public void setPopRank(int popRank) {
		this.popRank = popRank;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	@Override
	public String toString() {
		return "Place [woeid=" + woeid + ", placeTypeName=" + placeTypeName + ", name=" + name + ", country=" + country
				+ ", admin1=" + admin1 + ", admin2=" + admin2 + ", admin3=" + admin3 + ", locality1=" + locality1
				+ ", locality2=" + locality2 + ", postal=" + postal + ", centroid=" + centroid + ", boundingBox="
				+ boundingBox + ", areaRank=" + areaRank + ", popRank=" + popRank + ", timezone=" + timezone + "]";
	}

}
