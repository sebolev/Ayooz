package ma.ac.ensa;

import java.io.IOException;

public class AppServeur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Serveur serveur=new Serveur();
			serveur.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
