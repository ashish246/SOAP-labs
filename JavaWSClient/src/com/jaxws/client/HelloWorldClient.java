package com.jaxws.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.jaxws.service.HelloWorldBare;
import com.jaxws.service.HelloWorldDocumentBare;
import com.jaxws.service.HelloWorldDocumentOverloaded;
import com.jaxws.service.HelloWorldDocumentWrapped;
import com.jaxws.service.HelloWorldOverloaded;
import com.jaxws.service.HelloWorldWrapped;

/**
 * Without tool, you can create a Java web service client like this
 * 
 * @author Administrator
 *
 */
public class HelloWorldClient {

	public static void main(String[] args) throws Exception {

		// clientForWSRPCStyleBare();

		// clientForWSRPCStyleWrapped();

		/*
		 * When calling RPC overloaded method:
		 * 
		 * javax.xml.ws.soap.SOAPFaultException: Cannot find dispatch method for
		 * Request=[SOAPAction=
		 * "http://service.jaxws.com/HelloWorldOverloaded/getHelloWorldAsStringRequest"
		 * ,Payload={http://service.jaxws.com/}getHelloWorldAsString]
		 */
		 clientForWSRPCStyleOverloaded();

		// clientForWSDocumentStyleBare();

		// clientForWSDocumentStyleWrapped();

		//clientForWSDocumentStyleOverloaded();
	}

	private static void clientForWSRPCStyleBare() throws MalformedURLException {

		URL url = new URL("http://localhost:8888/ws/bare/hello?wsdl");

		// 1st argument is service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://service.jaxws.com/",
				"HelloWorldBareImplService");

		Service service = Service.create(url, qname);

		HelloWorldBare hello = service.getPort(HelloWorldBare.class);

		System.out.println(hello
				.getHelloWorldAsString("Ashish Tripathi RPC Style Bare"));
	}

	private static void clientForWSRPCStyleWrapped()
			throws MalformedURLException {

		URL url = new URL("http://localhost:8888/ws/wrapped/hello?wsdl");

		// 1st argument is service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://service.jaxws.com/",
				"HelloWorldWrappedImplService");

		Service service = Service.create(url, qname);

		HelloWorldWrapped hello = service.getPort(HelloWorldWrapped.class);

		System.out.println(hello.getHelloWorldAsString(
				"Ashish Tripathi RPC Style Wrapped", " sdlmvdsvmd;"));
	}

	private static void clientForWSRPCStyleOverloaded()
			throws MalformedURLException {

		URL url = new URL("http://localhost:8888/ws/overloaded/hello?wsdl");

		// 1st argument is service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://service.jaxws.com/",
				"HelloWorldOverloadedImplService");

		Service service = Service.create(url, qname);

		HelloWorldOverloaded hello = service
				.getPort(HelloWorldOverloaded.class);

		System.out
				.println(hello
						.getHelloWorldOLAsString("Ashish Tripathi RPC Style Overloaded 1"));

		System.out.println(hello.getHelloWorldOLAsString(
				"Ashish RPC Style Overloaded", "Tripathi Overloaded 2"));
	}

	private static void clientForWSDocumentStyleBare()
			throws MalformedURLException {

		URL url = new URL("http://localhost:8888/ws/bare/helloDocument?wsdl");

		// 1st argument is service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://service.jaxws.com/",
				"HelloWorldDocumentBareImplService");

		Service service = Service.create(url, qname);

		HelloWorldDocumentBare hello = service
				.getPort(HelloWorldDocumentBare.class);

		System.out.println(hello.getHelloWorldDocumentAsString(
				"Ashish Tripathi Document Style Bare", " vkdnvdslvndslvkn"));
	}

	private static void clientForWSDocumentStyleWrapped()
			throws MalformedURLException {

		URL url = new URL("http://localhost:8888/ws/wrapped/helloDocument?wsdl");

		// 1st argument is service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://service.jaxws.com/",
				"HelloWorldDocumentWrappedImplService");

		Service service = Service.create(url, qname);

		HelloWorldDocumentWrapped hello = service
				.getPort(HelloWorldDocumentWrapped.class);

		System.out.println(hello.getHelloWorldDocumentAsString(
				"Ashish Tripathi Document Style wrapped", " vvnkvndslvnlv"));
	}

	private static void clientForWSDocumentStyleOverloaded()
			throws MalformedURLException {

		URL url = new URL(
				"http://localhost:8888/ws/overloaded/helloDocument?wsdl");

		// 1st argument is service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://service.jaxws.com/",
				"HelloWorldDocumentOverloadedImplService");

		Service service = Service.create(url, qname);

		HelloWorldDocumentOverloaded hello = service
				.getPort(HelloWorldDocumentOverloaded.class);

		System.out
				.println(hello
						.getHelloWorldDocumentOLAsString("Ashish Tripathi Document Style Overloaded"));

		System.out.println(hello.getHelloWorldDocumentOLAsString(
				"Ashish Tripathi Document Style Overloaded",
				" sklvsdvdslsl +++ "));
	}

}
