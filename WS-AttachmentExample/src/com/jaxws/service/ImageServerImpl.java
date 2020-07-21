package com.jaxws.service;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

/**
 * @author Administrator
 *
 */
@MTOM
@WebService(endpointInterface = "com.jaxws.service.ImageServer")
public class ImageServerImpl implements ImageServer {

	@Override
	public Image downloadImage(String name) {

		try {

			File image = new File("d:\\uploaded\\" + name);
			return ImageIO.read(image);

		} catch (IOException e) {

			e.printStackTrace();
			return null;

		}
	}

	@Override
	public String uploadImage(Image data) {

		if (data != null) {
			// store somewhere
			return "Upload Successful";
		}

		throw new WebServiceException("Upload Failed!");

	}

}
