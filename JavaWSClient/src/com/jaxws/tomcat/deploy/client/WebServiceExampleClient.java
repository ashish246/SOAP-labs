package com.jaxws.tomcat.deploy.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.ws.demo.HelloWorld;

/**
 * Need to generate the SEI (service end-point interface) to access the
 * published web service
 * 
 * wsimport -keep -verbose http://localhost:8080/WebServiceExample/hello?wsdl
 * 
 * @author Administrator
 *
 */
public class WebServiceExampleClient {

	public static void main(String[] args) throws Exception {

		/*
		 * By making below entry in server.xml file of Tomcat current deployment
		 * directory:
		 * 
		 * <Connector port="8443" protocol="HTTP/1.1" SSLEnabled="true"
		 * maxThreads="150" scheme="https" secure="true" clientAuth="false"
		 * sslProtocol="TLS" keystoreFile="c:\your keystore file"
		 * keystorePass="your keystore password" />
		 */
		URL url = new URL("https://localhost:8443/WebServiceExample/hello?wsdl");

		// 1st argument is service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://demo.ws.com/", "HelloWorldService");

		Service service = Service.create(url, qname);

		HelloWorld hello = service.getPort(HelloWorld.class);

		System.out.println(hello
				.getHelloWorld("Webservice Tomcat deploy example."));
	}

}
