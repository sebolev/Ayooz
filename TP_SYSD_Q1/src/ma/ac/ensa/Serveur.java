package ma.ac.ensa;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Zouhir OUFTOU
 * Classe Serveur
 */
public class Serveur {
	//Le port de serveur
	private int PORT=2001;
	//Socket principale de serveur
	private ServerSocket serveur;
	
	//Constructeur de serveur 
	public Serveur() throws IOException {
		serveur=new ServerSocket(PORT);
	}
	//Méthode pour lancer le serveur
	public void start() throws IOException{
		//Socket de connexion de client
		Socket connexion;
		//Objet pour écrire sur un flux de communication
		PrintWriter p;
		while(true){
			//Attente de connexion de client
			System.out.println("..............................");
			connexion=serveur.accept();
			System.out.println("Nouvelle connexion");
		    System.out.println("Les parametres de connexion : PORT:"+connexion.getPort()+" Adresse :"+connexion.getInetAddress().getHostAddress());
		    p=new PrintWriter(connexion.getOutputStream());
		    //Envoie de message HELLO au client connecté
			p.println("HELLO");
			p.flush();
			//Fermeture de la connexion de client
			connexion.close();
		}
	}
}