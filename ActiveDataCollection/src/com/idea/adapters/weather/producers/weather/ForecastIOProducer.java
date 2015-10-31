package com.idea.adapters.weather.producers.weather;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import com.idea.adapters.weather.forecastio.service.ForecastIOService;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class ForecastIOProducer {
	// 192.168.184.135
	public static String getForecastIO(String address) throws Exception {
		ForecastIOService forecastIOObject = new ForecastIOService();
		return forecastIOObject.getWeatherForecast(address);
	}

	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		props.put("metadata.broker.list", "serverHost1:9092");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("request.required.acks", "1");
		ProducerConfig config = new ProducerConfig(props);
		Producer<String, String> producer = new Producer<String, String>(config);
		String forecast = getForecastIO("1600 Amphitheatre Parkway, Mountain View, CA");
		KeyedMessage<String, String> data = new KeyedMessage<String, String>("newtest", forecast);
		producer.send(data);
		producer.close();
	}

}
