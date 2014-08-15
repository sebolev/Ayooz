package ma.ac.ensa;

import java.io.IOException;

public class AppClient1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Client c1=new Client("client1");
		c1.start();
	}

}
