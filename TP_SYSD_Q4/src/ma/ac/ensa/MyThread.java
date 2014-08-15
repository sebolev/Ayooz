package ma.ac.ensa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyThread implements Runnable{

private Socket socket;

public MyThread(Socket s){
	
	socket = s;
	}
public void run(){
	
	PrintWriter p;
	BufferedReader b;
	String tempLangue;
	String s;
	try {
		
		//Reception de la langue de client
		b=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		tempLangue=b.readLine();
		System.out.println("Reception de la langue :"+tempLangue);
		tempLangue=b.readLine();
		System.out.println("Reception de la langue cible :"+tempLangue);
		
		//Création d'un traducteur
		Traduction t=new Traduction("EN",tempLangue);
		
		//tant que je recoi un message
		while((s=b.readLine())!=null){
			//Envoie de message correspendant
			p=new PrintWriter(socket.getOutputStream());
			p.println(t.getMessageTraduit(s));
			p.flush();
		}
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}

}
