package com.jaxws.container.auth.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import com.jaxws.service.UserProfile;

/**
 * For successful parsing of the WSDL file following namespaces needs to be
 * defined:
 * 
 * xmlns="http://schemas.xmlsoap.org/wsdl/"
 * xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
 * xmlns:tns="http://service.jaxws.com/"
 * 
 * @author Administrator
 *
 */
public class ContainerAuthClient {

	// can't parse wsdl "http://localhost:8080/WebServiceExample/user.wsdl"
	// directly because of the authentication
	// save it as local file, and parse it
	private static final String WS_URL = "file:E:/Projects/My_Projects/Shared/TechStuff/AT/WS_Tomcat/JavaWSClient/src/WS-ContainerAuth.wsdl";

	public static void main(String[] args) throws Exception {

		URL url = new URL(WS_URL);
		QName qname = new QName("http://service.jaxws.com/",
				"UserProfileImplService");

		Service service = Service.create(url, qname);
		UserProfile port = service.getPort(UserProfile.class);

		// add username and password for container authentication
		BindingProvider bp = (BindingProvider) port;
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "ashish");
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,
				"17291729");

		System.out.println(port.getUserName());

	}

}
