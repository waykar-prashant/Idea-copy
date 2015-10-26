package com.idea.adapters.weather.forecastio.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ForecastIOService {

	public static final String API_KEY = "338ca7cbf5989fdad923f81b998255d3/";
	public static final String BASE_URL = "https://api.forecast.io/forecast/";

	public static void main (String[] args) throws IOException {
		String weather = "";
		/*
		 * Sample url
		 * https://api.forecast.io/forecast/338ca7cbf5989fdad923f81b998255d3/37.8267,-122.423
		 */
		StringBuilder urlString = new StringBuilder(BASE_URL);
		urlString.append(API_KEY).append("37.8267,-122.423");
		URL url = new URL(urlString.toString());
		System.out.println(url.toString());
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		//URLConnection connection = url.openConnection();
		InputStream is = con.getInputStream();
		BufferedReader urlReader = new BufferedReader(new InputStreamReader(is));
		StringWriter writer = new StringWriter();
		String s="";
		while ((s = urlReader.readLine()) != null) {
		    writer.write(s);
		}
		//copy(reader, writer);
		writer.close();
		is.close();
		System.out.println(writer.toString());
		
		
	}
}
