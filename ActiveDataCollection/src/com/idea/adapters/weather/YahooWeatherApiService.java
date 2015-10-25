package com.idea.adapters.weather;

public class YahooWeatherApiService {

	/*
	 * public String baseUrl = "http://weather.yahooapis.com/forecastrss";
	 * public String woeidParameter = "w"; public String degreeParameter = "u";
	 */
	public static void main(String[] args) {
		String baseUrl = "http://weather.yahooapis.com/forecastrss";
		String woeidParameter = "w";
		String degreeParameter = "u";

		/*
		 * Sample Url to ping yahoo weather
		 * https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%
		 * 20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%
		 * 20geo.places(1)%20where%20text%3D%22nome%2C%20ak%22)&format=json&env=
		 * store%3A%2F%2Fdatatables.org%2Falltableswithkeys
		 */
		StringBuilder url = new StringBuilder(baseUrl);
		url.append("?").append(woeidParameter).append("=").append("2502265").append("&").append(degreeParameter)
				.append("=").append("c");
		System.out.println(url);
	}

}
