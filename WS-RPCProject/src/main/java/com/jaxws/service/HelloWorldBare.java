package com.jaxws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

/**
 * annotated with @SOAPBinding is optional, because the default style is
 * document.
 * 
 * In JAX-WS development, convert from �RPC style� to �Document style� is very
 * easy, just change the @SOAPBinding style option.
 * 
 * Using BARE will give below exception:
 * 
 * com.sun.xml.internal.ws.model.RuntimeModelerException: Incorrect usage of
 * Annotation @javax.jws.soap.SOAPBinding(style=RPC, use=LITERAL,
 * parameterStyle=BARE) on interface com.jaxws.service.HelloWorldBare,
 * ParameterStyle can only be WRAPPED with RPC Style Web service.
 * 
 * @author Administrator
 *
 */
@WebService
@SOAPBinding(style = Style.RPC, use = Use.LITERAL, parameterStyle = ParameterStyle.BARE)
// optional
public interface HelloWorldBare {

	@WebMethod
	String getHelloWorldAsString(String name);

}
