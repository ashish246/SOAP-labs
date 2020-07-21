package com.jaxws.service;

import javax.jws.WebService;

@WebService(endpointInterface = "com.jaxws.service.HelloWorldDocumentWrapped")
public class HelloWorldDocumentWrappedImpl implements HelloWorldDocumentWrapped {

	@Override
	public String getHelloWorldDocumentAsString(String name, String lastName) {
		return "Hello World JAX-WS " + name + " " + lastName;
	}

}