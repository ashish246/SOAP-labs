package com.jaxws.service;

import javax.jws.WebService;

@WebService(endpointInterface = "com.jaxws.service.HelloWorldDocumentOverloaded")
public class HelloWorldDocumentOverloadedImpl implements
		HelloWorldDocumentOverloaded {

	@Override
	public String getHelloWorldDocumentOLAsString(String name) {
		return "Hello World JAX-WS " + name;
	}

	@Override
	public String getHelloWorldDocumentOLAsString(String name, String lastName) {
		return "Hello World JAX-WS " + name + lastName;
	}

}