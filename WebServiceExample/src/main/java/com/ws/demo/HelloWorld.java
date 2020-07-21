package com.ws.demo;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Create a web service deployment descriptor, named sun-jaxws.xml.
 * 
 * In the standard web.xml,
 * 
 * Defines “com.sun.xml.ws.transport.http.servlet.WSServletContextListener” as
 * listener class. Defines “com.sun.xml.ws.transport.http.servlet.WSServlet” as
 * your web service (hello) servlet.
 * 
 * @author Administrator
 *
 */
@WebService
public class HelloWorld {

	@WebMethod(operationName = "getHelloWorld")
	public String getHelloWorld(String name) {
		return "Hello World JAX-WS " + name;
	}

}