package com.idea.adapters.weather.forecastio.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ForecastIOService {

	public static final String API_KEY = "338ca7cbf5989fdad923f81b998255d3";
	public static final String BASE_URL = "https://api.forecast.io/forecast/";
	public static final String REQUEST_TYPE = "GET";

	protected static String urlStringBuilder(double latitude, double longitude) {
		StringBuilder urlString = new StringBuilder(BASE_URL);
		urlString.append(API_KEY).append("/").append(latitude).append(",").append(longitude);
		return urlString.toString();

	}

	protected static HttpURLConnection connectionBuilder(String urlString) throws IOException {
		URL url = new URL(urlString);
		return (HttpURLConnection) url.openConnection();
	}

	protected static String getRequestedCode(HttpURLConnection con) throws IOException {
		InputStream is = con.getInputStream();
		BufferedReader urlReader = new BufferedReader(new InputStreamReader(is));
		StringWriter writer = new StringWriter();
		String s = "";
		while ((s = urlReader.readLine()) != null) {
			writer.write(s);
		}
		writer.close();
		is.close();
		return writer.toString();
	}

	public static void main(String[] args) throws IOException {
		String weather = "";
		double latitude = 37.8267;
		double longitude = -122.423;
		/*
		 * Sample url
		 * https://api.forecast.io/forecast/338ca7cbf5989fdad923f81b998255d3/37.
		 * 8267,-122.423
		 */

		String Response = getRequestedCode(connectionBuilder(urlStringBuilder(latitude, longitude)));
		System.out.println(Response);
	}
}
