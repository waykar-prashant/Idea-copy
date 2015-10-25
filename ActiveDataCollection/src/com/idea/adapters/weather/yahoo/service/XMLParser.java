package com.idea.adapters.weather.yahoo.service;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.idea.adapters.weather.yahoo.model.Places;

public class XMLParser {
	protected Unmarshaller unmarshaller;

	public XMLParser() throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Places.class);
		unmarshaller = context.createUnmarshaller();
	}

	public Places parser(String xml) throws JAXBException {

		return (Places) unmarshaller.unmarshal(new StringReader(xml));

	}

}
