package com.soap.service;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * To attach above SOAP handler to web service ServerInfo.java, just annotate
 * with @HandlerChain and specify the SOAP handler file name inside.
 * 
 * 
 * @author Administrator
 *
 */
@WebService
@HandlerChain(file = "handler-chain.xml")
public class ServerInfo {

	@WebMethod
	public String getServerName() {

		return "Ashish server";

	}

}
