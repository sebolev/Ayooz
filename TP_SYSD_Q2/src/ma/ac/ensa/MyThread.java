package ma.ac.ensa;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MyThread implements Runnable{

private Socket socketduserveur;

public MyThread(Socket s){
	socketduserveur = s;
	}
public void run(){
	
	PrintWriter p;
	try {
		p=new PrintWriter(socketduserveur.getOutputStream());
		p.println("HELLO");
		p.flush();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
