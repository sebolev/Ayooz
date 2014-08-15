package ma.ac.ensa;

import java.io.IOException;
import java.net.UnknownHostException;

public class Noeud {
	
	private String name;

	private ThreadServeur serveur;
	private ThreadClient client;
	
	public static String message="";

	public Noeud() {
		super();
	}
	public Noeud(int portServeur,int portClient) throws IOException {
		
		serveur= new ThreadServeur(portServeur);
		if(portClient!=0){
			client= new ThreadClient(portClient);
		}
	}
	public void start() throws IOException{
		
		System.out.println(" "+name+" <<Server start>>");
		serveur.start();
	}
	public void connect() throws UnknownHostException, IOException{
		
		System.out.println(" "+name+" <<connect to Server>>");
		client.start();
	}
	public void send(String message) throws IOException{
		serveur.send(message);
	}
	public String receive() throws IOException{
		return client.receive();
	}
	public void initjeu(Jeu j) throws IOException{
		
		System.out.println("Jeu Start");
		j.start();
		send(""+0);
	}
	public void jouer(Jeu j) throws IOException{
		
		int valeurN;
		String s=null;
		while((s=receive())!=null){
			valeurN = Integer.parseInt(s);
			j.setN(valeurN);
			System.out.println("Le scort est :"+s);
			System.out.println("Envoie de  :"+(Integer.parseInt(s)+1));
			send(""+(Integer.parseInt(s)+1));
			if(j.isFinish()){
				System.out.println("Le Noeud  :"+name+" est gagnant !!!!!");
				break;
			}
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ThreadClient getClient() {
		return client;
	}
	public void setClient(ThreadClient client) {
		this.client = client;
	}
	
}
