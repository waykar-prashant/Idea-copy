package com.idea.adapters.weather.yahoo.service;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;

public class YahooWeatherApiService {

	/*
	 * public String baseUrl = "http://weather.yahooapis.com/forecastrss";
	 * public String woeidParameter = "w"; public String degreeParameter = "u";
	 */
	public static void main(String[] args) throws IOException, JAXBException {
		
		YahooWeatherService yahooService = new YahooWeatherService();
		// write a class that resolves the city to its corresponding woeid.
		
		Channel channel= yahooService.getForecast("2502265", DegreeUnit.CELSIUS);
		
	}
	

}
