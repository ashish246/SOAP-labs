package com.jaxws.service;

import javax.jws.WebService;

@WebService(endpointInterface = "com.jaxws.service.HelloWorldDocumentBare")
public class HelloWorldDocumentBareImpl implements HelloWorldDocumentBare {

	@Override
	public String getHelloWorldDocumentAsString(String name, String lastName) {
		return "Hello World JAX-WS " + name + " " + lastName;
	}

}