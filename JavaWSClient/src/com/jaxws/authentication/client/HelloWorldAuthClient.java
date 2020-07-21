package com.jaxws.authentication.client;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import com.jaxws.service.HelloWorldAuth;

public class HelloWorldAuthClient {
	private static final String WS_URL = "http://localhost:9999/ws/auth/hello?wsdl";

	public static void main(String[] args) throws Exception {

		URL url = new URL(WS_URL);
		QName qname = new QName("http://service.jaxws.com/",
				"HelloWorldAuthImplService");

		Service service = Service.create(url, qname);
		HelloWorldAuth hello = service.getPort(HelloWorldAuth.class);

		/******************* UserName & Password ******************************/
		Map<String, Object> req_ctx = ((BindingProvider) hello)
				.getRequestContext();
		req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("Username", Collections.singletonList("ashish"));
		headers.put("Password", Collections.singletonList("17291s729"));
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		/**********************************************************************/

		System.out.println(hello.getHelloWorldAsString());

	}

}
