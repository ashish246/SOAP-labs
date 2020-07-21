package com.jaxws.service;

import java.awt.Image;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * to show how to use Message Transmission Optimization Mechanism (MTOM) and
 * XML-Binary Optimized Packaging (XOP) technique to send a binary attachment
 * (image) from server to client and vice verse.
 * 
 * Enable server to send attachment via MTOM is very easy, just annotate the web
 * service implementation class with javax.xml.ws.soap.MTOM.
 * 
 * @author Administrator
 *
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface ImageServer {

	// download a image from server
	@WebMethod
	Image downloadImage(String name);

	// update image to server
	@WebMethod
	String uploadImage(Image data);

}