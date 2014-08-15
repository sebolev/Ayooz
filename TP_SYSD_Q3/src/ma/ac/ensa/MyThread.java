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
	try {
		
		//Reception de la langue de client
		b=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		tempLangue=b.readLine();
		System.out.println("Reception de la langue :"+tempLangue);

		//Envoie de message correspendant
		p=new PrintWriter(socket.getOutputStream());
		p.println(getMessage(tempLangue));
		p.flush();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}
private String getMessage(String langue) {
	
	if(langue.equals("FR")){
		
		return "Bonjour";
	}else if(langue.equals("EN")){
		
		return "Hello";
	}else if(langue.equals("AM")){
		
		return "Azul";
	}else if(langue.equals("AR")){
		
		return "مرحبا";
	}else{
		
		return "La langue est inconnue";
	}
}
}
