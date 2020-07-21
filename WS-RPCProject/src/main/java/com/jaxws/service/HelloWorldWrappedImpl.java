package com.jaxws.service;

import javax.jws.WebService;

/**
 * @author Administrator
 *
 */
@WebService(endpointInterface = "com.jaxws.service.HelloWorldWrapped")
public class HelloWorldWrappedImpl implements HelloWorldWrapped {

	@Override
	public String getHelloWorldAsString(String name, String lastName) {
		return "Hello World JAX-WS " + name + " " + lastName;
	}

}
