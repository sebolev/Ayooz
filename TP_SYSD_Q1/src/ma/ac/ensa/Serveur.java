package ma.ac.ensa;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	
private int PORT=2001;
private ServerSocket serveur;

public Serveur() throws IOException {
	
	serveur=new ServerSocket(PORT);
}
public void start() throws IOException{
	
	Socket connexion;
	PrintWriter p;
	while(true){
		System.out.println("..............................");
		connexion=serveur.accept();
		System.out.println("Nouvelle connexion");
	     System.out.println("Les parametres de connexion : PORT:"+connexion.getPort()+" Adresse :"+connexion.getInetAddress().getHostAddress());
		p=new PrintWriter(connexion.getOutputStream());
		p.println("HELLO");
		p.flush();
		connexion.close();
	}
}
}