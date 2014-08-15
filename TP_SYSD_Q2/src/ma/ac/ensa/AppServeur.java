package ma.ac.ensa;

import java.io.IOException;

public class AppServeur {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Serveur serveur=new Serveur();
		serveur.start();
	}

}
