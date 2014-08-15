package ma.ac.ensa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * @author Zouhir OUFTOU
 * Classe Client
 */
public class Client {
	//Le numero de client.
	private int numclient;
	//Sokcet de connexion de client.
	private Socket socket;
	//Objet pour la lecture de message envoyé per le serveur.
	private BufferedReader response;
	
	//Constructeur de client.
	public Client(int numc) {
		numclient=numc;
	}
	//Afficher message
	public void showMessage() throws IOException{
		try {
			//Connextion au serveur et récupération de la socket.
			socket=new Socket(InetAddress.getLocalHost(),2001);
			//Récupération de flux d'échange à partir de la socket.
			response=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//Affichage de message reçu. 
			System.out.println("Message reçu : "+response.readLine()+" Client "+numclient);
			//Fermeture de flux.
			response.close();
			//Fermeture de la connexion.
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
