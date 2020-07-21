package com.soap.handler.client;

import com.soap.service.ServerInfo;
import com.soap.service.ServerInfoService;

/**
 * Uses wsimport command to parse the published service WSDL file
 * (http://localhost:8888/ws/server?wsdl) and generate all required files to
 * access the service.
 * 
 * C:\>wsimport -keep -verbose http://localhost:8888/ws/server?wsdl parsing
 * WSDL...
 * 
 * generating code... com\mkyong\ws\GetServerName.java
 * com\mkyong\ws\GetServerNameResponse.java com\mkyong\ws\ObjectFactory.java
 * com\mkyong\ws\ServerInfo.java com\mkyong\ws\ServerInfoService.java
 * com\mkyong\ws\package-info.java
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class WsClient {

	public static void main(String[] args) throws Exception {

		// A client to access the published service.
		ServerInfoService sis = new ServerInfoService();
		ServerInfo si = sis.getServerInfoPort();

		System.out.println(si.getServerName());

	}

}
