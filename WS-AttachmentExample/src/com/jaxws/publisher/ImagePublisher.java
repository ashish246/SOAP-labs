package com.jaxws.publisher;

import javax.xml.ws.Endpoint;

import com.jaxws.service.ImageServerImpl;

//Endpoint publisher
public class ImagePublisher {

	public static void main(String[] args) {

		Endpoint.publish("http://localhost:9999/ws/image",
				new ImageServerImpl());

		System.out.println("Image Server is published!");

	}

}	