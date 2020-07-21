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
 * In JAX-WS development, convert from “RPC style” to “Document style” is very
 * easy, just change the @SOAPBinding style option.
 * 
 * @author Administrator
 *
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
// optional
public interface HelloWorldDocumentWrapped {

	@WebMethod
	String getHelloWorldDocumentAsString(String name, String lastName);

}
