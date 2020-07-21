package com.jaxws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * we show you how to implement container authentication with JAX-WS. In this
 * way, the authentication is declarative rather than programmatic like
 * (application level authentication in JAX-WS) client provides “username” and
 * “password”, attached it in SOAP request header and send to server. And Tomcat
 * implement the container authentication via security realm.
 * 
 * For realm: http://tomcat.apache.org/tomcat-6.0-doc/realm-howto.html
 * 
 * @author Administrator
 *
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface UserProfile {

	@WebMethod
	String getUserName();

}