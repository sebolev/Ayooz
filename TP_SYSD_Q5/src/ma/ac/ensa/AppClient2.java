package ma.ac.ensa;

import java.io.IOException;

public class AppClient2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Client c2=new Client("client2");
		c2.start();
	}

}
