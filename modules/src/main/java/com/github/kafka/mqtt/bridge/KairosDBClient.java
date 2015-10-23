package com.github.kafka.mqtt.bridge;

import java.io.IOException;
import java.net.MalformedURLException;

import org.kairosdb.client.AbstractClient;
import org.kairosdb.client.ClientResponse;

public class KairosDBClient extends AbstractClient {

	protected KairosDBClient(String url) throws MalformedURLException {
		super(url);
		// TODO Auto-generated constructor stub
	}

	public int getRetryCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void shutdown() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ClientResponse postData(String json, String url) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ClientResponse queryData(String url) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ClientResponse delete(String url) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
