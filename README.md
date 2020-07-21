Authenticating-WebServices
==========================================================================

####WS-ClientAuthProject####
- User/Pwd is passed by the client to the SOAP request
- Access is validated at the web service end, when request is received at the published service.

####WS-ContainerAuthProject####
- User/Pwd is passed by the client to the SOAP request
- Add user at the server container's end
 `<role rolename="tomcat"/>
  <role rolename="operator"/>
  <user username="tomcat" password="tomcat" roles="tomcat"/>
  <user username="ashish" password="17291729" roles="tomcat,operator"/>
  <user username="role1" password="tomcat" roles="role1"/>`
- Authentication is done at the servlet container end before SOAP request is received at published service end.

####WebServiceExample####
- Enable SSL verification at the servlet container's end (`server.xml`).
 `<Connector port="8443" protocol="HTTP/1.1" SSLEnabled="true" 
               maxThreads="150" scheme="https" secure="true"
               clientAuth="false" sslProtocol="TLS" 
	       keystoreFile="C:\Users\Administrator.Ebsi-HP4540-07\my-release-key.keystore"
	       keystorePass="172911989198" />`
		   
-------------------------------------------------------------------------

SOAP Type: Document/Literal/BARE  
=========================================================================

- Always Generate the STUB at client side rather than providing project dependency. This way, you will be able to figure out if the method and service classes are unique.
- Can be used with the overloaded service operations as message is not wrapped with service operation name. See element `getHelloWorldDocumentAsString`.
- You can finally validate this message with any XML validator. Everything within the `soap:body` is defined in a schema.
- Weakness: The operation name in the SOAP message is lost. Without the name, dispatching can be difficult, and sometimes impossible.
- If method has multiple args of same Type, annotate it with `@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)` as xml schema can not have elements with same names.

######REQUEST:  
`<?xml version="1.0"?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
  <S:Body>
    <getHelloWorldDocumentAsString xmlns="http://service.jaxws.com/">
    Ashish Tripathi Document Style
    Bare</getHelloWorldDocumentAsString>
  </S:Body>
</S:Envelope>`

###### Request with multiple arguments after wrapping at method level

`<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	<S:Body>
		<ns2:getHelloWorldDocumentAsString xmlns:ns2="http://service.jaxws.com/">
			<arg0>Ashish Tripathi Document Style Bare</arg0>
			<arg1> vkdnvdslvndslvkn</arg1>
		</ns2:getHelloWorldDocumentAsString>
	</S:Body>
</S:Envelope>`

######RESPONSE:
`<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	<S:Body>
		<getHelloWorldDocumentAsStringResponse xmlns="http://service.jaxws.com/">Hello World JAX-WS Ashish Tripathi Document Style Bare</getHelloWorldDocumentAsStringResponse>
	</S:Body>
</S:Envelope>`

SOAP Type: Document/Literal/WRAPPED
==============================================================================

- Default and best style
- Can not be used with the overloaded service operations as two wrapper elements in the xml schema can not have the same name. See `getHelloWorldDocumentAsString` & `arg0`.
- You can finally validate this message with any XML validator. Everything within the `soap:body` is defined in a schema.
- This SOAP message looks remarkably like the RPC/literal. but there's a subtle difference. In the RPC/literal SOAP message, the `<myMethod>` child of `<soap:body>` was the name of the operation. In the document/literal wrapped SOAP message, the `<myMethod>` clause is the name of the wrapper element which the single input message's part refers to. It just so happens that one of the characteristics of the wrapped pattern is that the name of the input element is the same as the name of the operation. This pattern is a sly way of putting the operation name back into the SOAP message.
- In WSDL, the input message has a single part. The part is an element. The element has the same name as the operation.

######REQUEST: 
`<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	<S:Body>
		<ns2:getHelloWorldDocumentAsString xmlns:ns2="http://service.jaxws.com/">
			<arg0>Ashish Tripathi Document Style wrapped</arg0>
		</ns2:getHelloWorldDocumentAsString>
	</S:Body>
</S:Envelope>`

#####Request with multiple arguments

`<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	<S:Body>
		<ns2:getHelloWorldDocumentAsString xmlns:ns2="http://service.jaxws.com/">
			<arg0>Ashish Tripathi Document Style wrapped</arg0>
			<arg1> vvnkvndslvnlv</arg1>
		</ns2:getHelloWorldDocumentAsString>
	</S:Body>
</S:Envelope>`

######RESPONSE:

`<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	<S:Body>
		<ns2:getHelloWorldDocumentAsStringResponse xmlns:ns2="http://service.jaxws.com/">
			<return>Hello World JAX-WS Ashish Tripathi Document Style wrapped</return>
		</ns2:getHelloWorldDocumentAsStringResponse>
	</S:Body>
</S:Envelope>`

----------------------------------------------------------------------------

SOAP Type: Document/Literal/Overloaded
============================================================================

**Error**:  
*Mar 16, 2015 8:00:34 PM com.sun.xml.internal.ws.wsdl.PayloadQNameBasedOperationFinder <init>
WARNING: Non unique body parts! In a port, as per BP 1.1 R2710 operations must have unique operation signature on the wire for successful dispatch. Methods [getHelloWorldDocumentAsString, getHelloWorldDocumentAsString] have the same request body block {http://service.jaxws.com/}getHelloWorldDocumentAsString. Method dispatching may fail, runtime will try to dispatch using SOAPAction. Another option is to enable AddressingFeature to enabled runtime to uniquely identify WSDL operation using wsa:Action header.*

-----------------------------------------------------------------------------

SOAP Type: RPC/Literal/BARE
=============================================================================
####Can not have BARE style with RPC in JAX-WS 2.0

-----------------------------------------------------------------------------

SOAP Type: RPC/Literal/WRAPPED
=============================================================================

- The operation name still appears in the message. The type encoding info is eliminated.
- You still cannot easily validate this message as there is no schema defined.
- Since the document/literal, nonwrapped style doesn't provide the operation name, there are below case where you'll need to use one of the RPC styles:
`public void myMethod(int x, float y);`  
`public void myMethod(int x);`  
`public void someOtherMethod(int x, float y);`  

######REQUEST:  
`<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	<S:Body>
		<ns2:getGreetingRequest xmlns:ns2="http://ashishtripathi.com">
			<name>Ashish Tripathi RPC Style Wrapped</name>
			<arg1> sdlmvdsvmd;</arg1>
		</ns2:getGreetingRequest>
	</S:Body>
</S:Envelope>`

######RESPONSE:
`<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	<S:Body>
		<ns2:getGreetingRequestResponse xmlns:ns2="http://ashishtripathi.com">
			<GreetingResponse>Hello World JAX-WS Ashish Tripathi RPC Style Wrapped</GreetingResponse>
		</ns2:getGreetingRequestResponse>
	</S:Body>
</S:Envelope>`

----------------------------------------------------------------------------

SOAP Type: RPC/Literal/Overloaded
============================================================================
**Error**:  
*Mar 16, 2015 6:22:22 PM com.sun.xml.internal.ws.wsdl.PayloadQNameBasedOperationFinder <init>
WARNING: Non unique body parts! In a port, as per BP 1.1 R2710 operations must have unique operation signature on the wire for successful dispatch. Methods [getHelloWorldAsString, getHelloWorldAsString] have the same request body block {http://service.jaxws.com/}getHelloWorldAsString. Method dispatching may fail, runtime will try to dispatch using SOAPAction. Another option is to enable AddressingFeature to enabled runtime to uniquely identify WSDL operation using wsa:Action header.*  


