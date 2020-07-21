package com.jaxws.attachment.client;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.jaxws.service.ImageServer;

public class ImageClient {

	public static void main(String[] args) throws Exception {

		URL url = new URL("http://localhost:9999/ws/image?wsdl");
		QName qname = new QName("http://service.jaxws.com/",
				"ImageServerImplService");

		Service service = Service.create(url, qname);
		ImageServer imageServer = service.getPort(ImageServer.class);

		/************ test download ***************/
		//download(imageServer);

		upload(imageServer);

	}

	private static void download(ImageServer imageServer) {
		Image image = imageServer.downloadImage("1.png");

		// display it in frame
		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		JLabel label = new JLabel(new ImageIcon(image));
		frame.add(label);
		frame.setVisible(true);

		System.out
				.println("imageServer.downloadImage() : Download Successful!");
	}

	/**
	 * Enable client to send attachment via MTOM to server is required some
	 * extra efforts, see following example :
	 * 
	 * @param imageServer
	 * @throws IOException
	 */
	private static void upload(ImageServer imageServer) throws IOException {

		// codes enable MTOM in client
		BindingProvider bp = (BindingProvider) imageServer;
		SOAPBinding binding = (SOAPBinding) bp.getBinding();
		binding.setMTOMEnabled(true);

		Image imgUpload = ImageIO
				.read(new FileInputStream("d://Interstellar-Infographic.jpg"));

		imageServer.uploadImage(imgUpload);

		System.out.println("imageServer.uploadImage() : Upload Successful!");
	}

}