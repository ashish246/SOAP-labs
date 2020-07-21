package com.jaxws.publisher;

import javax.xml.ws.Endpoint;

import com.jaxws.service.HelloWorldAuthImpl;

//Endpoint publisher
public class HelloWorldAuthPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/auth/hello",
				new HelloWorldAuthImpl());
	}

}