package com.jaxws.client;

import com.jaxws.service.HelloWorld;
import com.jaxws.service.HelloWorldImplService;

/**
 * you can use “wsimport” tool to parse the published wsdl file, and generate
 * necessary client files (stub) to access the published web service.
 * 
 * Where is wsimport? This wsimport tool is bundle with the JDK, you can find it
 * at “JDK_PATH/bin” folder. Issue “wsimport” command.
 * 
 * wsimport -keep http://localhost:9999/ws/hello?wsdl
 * 
 * @author Administrator
 *
 */
public class HelloWorldClient {

	public static void main(String[] args) {

		HelloWorldImplService helloService = new HelloWorldImplService();
		HelloWorld hello = helloService.getHelloWorldImplPort();

		System.out.println(hello.getHelloWorldAsString("Ashish T"));

	}

}
