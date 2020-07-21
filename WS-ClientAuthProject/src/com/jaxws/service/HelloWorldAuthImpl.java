package com.jaxws.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

//Service Implementation Bean
@WebService(endpointInterface = "com.jaxws.service.HelloWorldAuth")
public class HelloWorldAuthImpl implements HelloWorldAuth {

	@Resource
	WebServiceContext wsctx;

	@Override
	public String getHelloWorldAsString() {

		MessageContext mctx = wsctx.getMessageContext();

		// get detail from request headers
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List) http_headers.get("Username");
		List passList = (List) http_headers.get("Password");

		String username = "";
		String password = "";

		if (userList != null) {
			// get username
			username = userList.get(0).toString();
		}

		if (passList != null) {
			// get password
			password = passList.get(0).toString();
		}

		// Should validate username and password with database
		if (username.equals("ashish") && password.equals("17291729")) {
			return "Hello World JAX-WS - Valid User!";
		} else {
			return "Unknown User!";
		}

	}
}