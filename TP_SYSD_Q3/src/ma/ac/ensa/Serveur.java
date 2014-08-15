package ma.ac.ensa;

import java.io.IOException;
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
	while(true){
		System.out.println(".....................");
		connexion=serveur.accept();
		System.out.println("Nouvelle connexion");
		Thread t = new Thread(new MyThread(connexion));
		t.start();
		showParameters(connexion);
	}
}
public void showParameters(Socket connexion) {
	
	System.out.println("Les parametres de connexion : PORT:"+connexion.getLocalPort()+" Adresse :"+connexion.getInetAddress().getHostAddress());
}
public void showAllClient() {
	
	System.out.println("Le nombre des clients ");
}

}
