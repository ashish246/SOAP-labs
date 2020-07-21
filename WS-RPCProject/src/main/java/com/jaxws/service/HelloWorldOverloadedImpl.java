package com.jaxws.service;

import javax.jws.WebService;

@WebService(endpointInterface = "com.jaxws.service.HelloWorldOverloaded")
public class HelloWorldOverloadedImpl implements HelloWorldOverloaded {

	@Override
	public String getHelloWorldOLAsString(String name) {
		return "Hello World JAX-WS " + name;
	}

	@Override
	public String getHelloWorldOLAsString(String name, String lastName) {
		return "Hello World JAX-WS " + name + lastName;
	}

}