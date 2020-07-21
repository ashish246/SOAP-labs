package com.jaxws.service;

import javax.jws.WebService;

//Service Implementation Bean
@WebService(endpointInterface = "com.jaxws.service.UserProfile")
public class UserProfileImpl implements UserProfile {

	public String getUserName() {
		return "getUserName() : returned value";
	}

}