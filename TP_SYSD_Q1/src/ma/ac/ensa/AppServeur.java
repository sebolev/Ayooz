package ma.ac.ensa;

import java.io.IOException;
/**
 * @author Zouhir OUFTOU
 *	Classe de test et lancement de serveur
 */
public class AppServeur {
	public static void main(String[] args) {
		
		try {
			Serveur serveur=new Serveur();
			serveur.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
