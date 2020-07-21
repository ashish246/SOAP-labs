package com.jaxws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

/**
 * The following steps showing how to use JAX-WS to create a RPC style web
 * service endpoint.
 * 
 * RPC/LITERAL/WRAPPED style web service request and response structure. The
 * following is a sample Java SEI (Service Endpoint Interface) to create a RPC
 * web service.
 * 
 * @author Administrator
 *
 */
@WebService(name = "MyJaxWSHello", targetNamespace = "http://ashishtripathi.com", wsdlLocation = "http://ashishtripathi.com/ws/MyJaxWS?wsdl")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface HelloWorldWrapped {

	@WebMethod(operationName = "getGreetingRequest")
	@WebResult(targetNamespace = "http://ashishtripathi.com/ws/types", name = "GreetingResponse")
	String getHelloWorldAsString(
			@WebParam(targetNamespace = "http://ashishtripathi.com/ws/types", name = "name", mode = Mode.IN) String name, String lastName);

}