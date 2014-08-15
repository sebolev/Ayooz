package ma.ac.ensa;

import java.io.IOException;
/**
 * 
 * @author Zouhir OUFTOU
 *
 */
public class AppClient {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		Client client1=new Client(1);
		client1.showMessage();
		Client client2=new Client(2);
		client2.showMessage();
		Client client3=new Client(3);
		client3.showMessage();
		Client client4=new Client(4);
		client4.showMessage();
	}

}
