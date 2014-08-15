package ma.ac.ensa;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Serveur {
	
private int PORT=2001;
private ServerSocket serveur;
private List<MyThread> mesThreads;
private int MAX_CLIENT=5;

public Serveur() throws IOException {
	
	serveur=new ServerSocket(PORT);
}
public void start() throws IOException{
	
	Socket connexion;
	mesThreads=new ArrayList<MyThread>();
	while(true){
		
		System.out.println(".....................");
		//Attente de connexion de client
		connexion=serveur.accept();
		System.out.println(" Nouvelle connexion");
		
		//Création de Thread pour le client
		if(mesThreads.size()<=MAX_CLIENT){
			
			MyThread t = new MyThread(connexion);
			mesThreads.add(t);
			mesThreads.get(mesThreads.size()-1).run();
		}
		if(mesThreads.size()==MAX_CLIENT){
			System.out.println("Jeu Start");
			Jeu j=new Jeu(101);
			j.start();
			Random r=new Random();
			int numClient;
			int valeurN;
			
			while(true){
				
				numClient=r.nextInt(5);
				System.out.println("Valeur aleéatoire : "+(numClient+1));
				
				mesThreads.get(numClient).send(j.getN());
				valeurN = Integer.parseInt(mesThreads.get(numClient).recev());
				System.out.println("Le client numero :"+(numClient+1)+" m'envoie : n ="+valeurN);
				j.setN(valeurN);
				System.out.println("Le scort est :"+j.getN());
				if(j.isFinish()){
					System.out.println("Le client numero :"+(numClient+1)+" est gagnant !!!!!");
					break;
				}
			}

			
		}
	}
}

public void showAllClient() {
	
	System.out.println("Le nombre des clients ");
}

}
