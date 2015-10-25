package com.idea.adapters.weather.yahoo.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Channel {

	@XmlElement
	public String title;

	@XmlElement
	public String link;

	@XmlElement
	public String description;

	@XmlElement
	public String language;

	@XmlElement
	public Date lastBuildDate;

	@XmlElement
	public long ttyl;

	@XmlElement
	public Location location;

	@XmlElement
	public Units units;

	@XmlElement
	public Wind wind;

	@XmlElement
	public Atmosphere atmosphere;

	@XmlElement
	public Astronomy astronomy;

	@XmlElement
	public Image image;

	@XmlElement
	public Item item;

	public Channel() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getLastBuildDate() {
		return lastBuildDate;
	}

	public void setLastBuildDate(Date lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	public long getTtyl() {
		return ttyl;
	}

	public void setTtyl(long ttyl) {
		this.ttyl = ttyl;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Units getUnits() {
		return units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Atmosphere getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(Atmosphere atmosphere) {
		this.atmosphere = atmosphere;
	}

	public Astronomy getAstronomy() {
		return astronomy;
	}

	public void setAstronomy(Astronomy astronomy) {
		this.astronomy = astronomy;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Channel [title=" + title + ", link=" + link + ", description=" + description + ", language=" + language
				+ ", lastBuildDate=" + lastBuildDate + ", ttyl=" + ttyl + ", location=" + location + ", units=" + units
				+ ", wind=" + wind + ", atmosphere=" + atmosphere + ", astronomy=" + astronomy + ", image=" + image
				+ ", item=" + item + "]";
	}

}
