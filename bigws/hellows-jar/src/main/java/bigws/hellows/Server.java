package bigws.hellows;

import javax.xml.ws.Endpoint;

public class Server {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/helloWorld", new HelloWebService());
	}

}
