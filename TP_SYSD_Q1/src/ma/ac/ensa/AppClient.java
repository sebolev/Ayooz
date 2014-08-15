package ma.ac.ensa;

import java.io.IOException;

/**
 *
 * @author Zouhir OUFTOU
 */
public class AppClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Client client1=new Client(1);
		Client client2=new Client(2);
		Client client3=new Client(3);
		Client client4=new Client(4);
		try {
			client1.showMessage();
			client2.showMessage();
			client3.showMessage();
			client4.showMessage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
