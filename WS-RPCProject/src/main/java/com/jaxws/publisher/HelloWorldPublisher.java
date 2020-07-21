package com.jaxws.publisher;

import javax.xml.ws.Endpoint;

import com.jaxws.service.HelloWorldBareImpl;
import com.jaxws.service.HelloWorldOverloadedImpl;
import com.jaxws.service.HelloWorldWrappedImpl;

/**
 * Endpoint publisher
 * 
 * @author Administrator
 *
 */
public class HelloWorldPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/ws/wrapped/hello",
				new HelloWorldWrappedImpl());

		/*
		 * Can not have BARE style with RPC
		 */

		/*
		 * Endpoint.publish("http://localhost:9999/ws/bare/hello", new
		 * HelloWorldBareImpl());
		 */

		Endpoint.publish("http://localhost:9999/ws/overloaded/hello",
				new HelloWorldOverloadedImpl());
	}

}
