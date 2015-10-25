package com.idea.adapters.weather.yahoo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBException;

import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.util.URIUtil;

import com.idea.adapters.weather.yahoo.model.Places;

public class WoeidResolver {

	public static final String APPLICATION_ID = "dj0yJmk9MGVlOTZNcnZhYVlIJmQ9WVdrOU0yY3hVMjlSTm04bWNHbzlNQS0tJnM9Y29uc3VtZXJzZWNyZXQmeD0wZA--";
	public static final String BASE_URL = "http://where.yahooapis.com/v1/";

	public static Places findWOEID(String place) throws IOException, JAXBException {
		/*
		 * Find the WOEID of a significant landmark:
		 * http://where.yahooapis.com/v1/places.q('sydney%20opera%20house')?appid=[yourappidhere]
		 */

		StringBuilder urlString = new StringBuilder(BASE_URL);
		urlString.append("places.q").append("('" + URIUtil.encodeQuery(place) + "')").append("?").append("appid=")
				.append(APPLICATION_ID);
		
		URL url = new URL(urlString.toString());
		System.out.println(url.toString());
		URLConnection connection = url.openConnection();
		InputStream is = connection.getInputStream();
		BufferedReader urlReader = new BufferedReader(new InputStreamReader(is));
		StringWriter writer = new StringWriter();
		String s="";
		while ((s = urlReader.readLine()) != null) {
		    writer.write(s);
		}
		//copy(reader, writer);
		writer.close();
		is.close();
		XMLParser parser = new XMLParser();
		Places places= parser.parser(writer.toString());
		return places;
	}

	public static void main(String args[]) throws IOException, JAXBException {
		Places place= findWOEID("Sydney Opera House");
	}
}
