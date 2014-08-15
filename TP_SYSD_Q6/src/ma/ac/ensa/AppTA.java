package ma.ac.ensa;

import java.io.IOException;

public class AppTA {

	/**
	 * @param args
	 * @throws IOException 
	 */	
	public static void main(String[] args) throws IOException {

		Noeud n1=new Noeud(2001,0);
		n1.setName("noeud1");
		n1.start();
		
		Noeud n2=new Noeud(2002,2001);
		n2.setName("noeud2");
		n2.connect();
		n2.start();
		
		Noeud n3=new Noeud(2003,2002);
		n3.setName("noeud3");
		n3.connect();
		n3.start();
		
		Noeud n4=new Noeud(2004,2003);
		n4.setName("noeud4");
		n4.connect();
		n4.start();
		
		Noeud n5=new Noeud(2005,2004);
		n5.setName("noeud5");
		n5.connect();
		n5.start();
		
		n1.setClient(new ThreadClient(2005));
		n1.connect();
		
		Jeu j=new Jeu(101);
		n1.initjeu(j);
		n2.jouer(j);
		n3.jouer(j);
		n4.jouer(j);
		n5.jouer(j);
		n1.jouer(j);
//		n1.send("Bonjour");
//		n2.send("Bonjour");
//		n3.send("Bonjour");
//		n4.send("Bonjour");
		
//		System.out.println("Message recu : "+n2.receive());
//		System.out.println("Message recu : "+n3.receive());
//		System.out.println("Message recu : "+n4.receive());
//		System.out.println("Message recu : "+n5.receive());
//		System.out.println("Message recu : "+n1.receive());
	}

}
