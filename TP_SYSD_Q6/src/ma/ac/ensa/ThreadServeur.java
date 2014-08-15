package ma.ac.ensa;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServeur extends Thread{

	//Serveur
	private ServerSocket serveur;
	private Socket socketduserveur;
	private PrintWriter pw;

	public ThreadServeur(int portServeur) throws IOException{

		this.serveur=new ServerSocket(portServeur);
		}
	public void run(){
		
		try {
			while(true){
				//Attente de connexion de client
				System.out.println(".....................");
				socketduserveur=serveur.accept();
				showParameters(socketduserveur);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void showParameters(Socket connexion) {
		
		//affichage des parametres de la connexion
		System.out.println("Connexion | PORT :"+connexion.getLocalPort()
				+"| Adresse :"+connexion.getInetAddress().getHostAddress());
	}
	public void send(String message) throws IOException{
		
		//Envoie de message au suivant
		pw=new PrintWriter(socketduserveur.getOutputStream());
		pw.println(message);
		pw.flush();
	}
}
