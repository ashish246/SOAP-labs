package com.jaxws.publisher;

import javax.xml.ws.Endpoint;

import com.jaxws.service.HelloWorldDocumentBareImpl;
import com.jaxws.service.HelloWorldDocumentOverloadedImpl;
import com.jaxws.service.HelloWorldDocumentWrappedImpl;

//Endpoint publisher
public class HelloWorldDocumentPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/wrapped/helloDocument",
				new HelloWorldDocumentWrappedImpl());

		Endpoint.publish("http://localhost:9999/ws/bare/helloDocument",
				new HelloWorldDocumentBareImpl());

		Endpoint.publish("http://localhost:9999/ws/overloaded/helloDocument",
				new HelloWorldDocumentOverloadedImpl());
	}

}
