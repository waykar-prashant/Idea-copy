package com.github.kafka.mqtt.bridge;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.kairosdb.client.Client;
import org.kairosdb.client.HttpClient;
import org.kairosdb.client.builder.MetricBuilder;
import org.kairosdb.client.builder.QueryBuilder;
import org.kairosdb.client.response.GetResponse;
import org.kairosdb.client.response.QueryResponse;
import org.kairosdb.client.response.Response;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.kairosdb.client.util.Preconditions.checkNotNullOrEmpty;

public class KairosDBClient implements Client{

	private String url;
	//get the config of the kairosdb on initialization
	
	protected KairosDBClient(String url) throws MalformedURLException {
		super();
		this.url = url;
	}

	public int getRetryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void shutdown() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public GetResponse getMetricNames() throws IOException {
		HttpClient client = new HttpClient(url);
		GetResponse response = client.getMetricNames();
		client.shutdown();
		return response;
	}

	public GetResponse getTagNames() throws IOException {
		HttpClient client = new HttpClient(url);
		GetResponse response = client.getTagNames();
		client.shutdown();
		return response;
	}

	public GetResponse getTagValues() throws IOException {
		HttpClient client = new HttpClient(url);
		GetResponse response = client.getTagValues();
		client.shutdown();
		return response;
	}

	public QueryResponse query(QueryBuilder builder) throws URISyntaxException, IOException {
		//checkNotNull(builder);
		
		return new QueryResponse();
	}

	public Response pushMetrics(MetricBuilder builder) throws URISyntaxException, IOException {
		checkNotNull(builder);
		HttpClient client = new HttpClient(url);
		Response response = client.pushMetrics(builder);
		client.shutdown();
		return response;
	}

	public Response deleteMetric(String name) throws IOException {
		checkNotNullOrEmpty(name);
		HttpClient client = new HttpClient(url);
		Response response = client.deleteMetric(name);
		client.shutdown();
		return response;
	}

	public Response delete(QueryBuilder builder) throws URISyntaxException, IOException {
		checkNotNull(builder);
		HttpClient client = new HttpClient(url);
		Response response = client.delete(builder);
		client.shutdown();
		return response;
	}

	public void registerCustomDataType(String groupType, Class dataPointValueClass) {
		// TODO Auto-generated method stub
		
	}

	public Class getDataPointValueClass(String groupType) {
		// TODO Auto-generated method stub
		return null;
	}

}
