package ma.ac.ensa;

import java.io.IOException;

public class AppClient {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Client client1=new Client(1,"EN");
		client1.showMessage();
	}
}
