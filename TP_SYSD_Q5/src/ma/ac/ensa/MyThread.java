package ma.ac.ensa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyThread implements Runnable{

private Socket socket;
private String nomClient;

public MyThread(Socket s){
	socket = s;
	}
public void run(){
	
	PrintWriter pr;
	BufferedReader b;
	try {
		
		//Reception de nom de client
		b=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		nomClient=b.readLine();
		
		//Affichage de profil de client
		showParameters(socket);
		
		//Envoie de message  OK correspendant
		pr=new PrintWriter(socket.getOutputStream());
		pr.println("OK");
		pr.flush();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public void showParameters(Socket connexion) {
	
	System.out.println("| Name "+nomClient+"| Port "+connexion.getLocalPort()+"| Adresse "+connexion.getInetAddress().getHostAddress());
}
public String getNomClient() {
	return nomClient;
}
public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}
public void send(int n) throws IOException{
	PrintWriter p;
	//Envoie de l'entier n 
	p=new PrintWriter(socket.getOutputStream());
	p.println(n);
	p.flush();
}
public String recev() throws IOException{
	BufferedReader b;
	b=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	return(b.readLine());
}
}
