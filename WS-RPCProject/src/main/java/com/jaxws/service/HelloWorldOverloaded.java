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
 * For overloaded mathod, we get this WARNING, whether or not defined as
 * @WebMethod:
 * 
 * WARNING: Non unique body parts! In a port, as per BP 1.1 R2710 operations
 * must have unique operation signature on the wire for successful dispatch.
 * Methods [getHelloWorldAsString, getHelloWorldAsString] have the same request
 * body block {http://service.jaxws.com/}getHelloWorldAsString. Method
 * dispatching may fail, runtime will try to dispatch using SOAPAction. Another
 * option is to enable AddressingFeature to enabled runtime to uniquely identify
 * WSDL operation using wsa:Action header.
 * 
 * @author Administrator
 *
 */
@WebService
@SOAPBinding(style = Style.RPC, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
// optional
public interface HelloWorldOverloaded {

	@WebMethod
	String getHelloWorldOLAsString(String name);

	//@WebMethod
	String getHelloWorldOLAsString(String name, String lastName);

}
