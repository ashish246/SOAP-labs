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
 * If used BARE, will get the exception:
 * 
 * com.sun.xml.internal.ws.model.RuntimeModelerException: runtime modeler error:
 * SEI com.jaxws.service.HelloWorldDocumentOverloadedImpl has method
 * getHelloWorldDocumentAsString annotated as BARE but it has more than one
 * parameter bound to body. This is invalid. Please annotate the method with
 * annotation: @SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
 * 
 * If used WRAPPED, will get the exception:
 * 
 * javax.xml.bind.JAXBException: arg1 is not a valid property on class
 * com.jaxws.service.jaxws.GetHelloWorldDocumentAsString
 * 
 * @author Administrator
 *
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
// optional
public interface HelloWorldDocumentOverloaded {

	@WebMethod
	String getHelloWorldDocumentOLAsString(String name);

	//@WebMethod
	String getHelloWorldDocumentOLAsString(String name, String lastName);

}
