package com.jaxws.service;

import javax.jws.WebService;

@WebService(endpointInterface = "com.jaxws.service.HelloWorldBare")
public class HelloWorldBareImpl implements HelloWorldBare {

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}

}