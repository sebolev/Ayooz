package ma.ac.ensa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

private String nom;
private Socket socket;
private BufferedReader response;
private PrintWriter request;

public Client(String nom) {
	
	this.nom=nom;
}
public void start() throws IOException{
	
	try {
		
		socket=new Socket(InetAddress.getLocalHost(),2001);
		
		//Envoie de nom de client vers le serveur
		request=new PrintWriter(socket.getOutputStream());
		request.println(nom);
		request.flush();
		
		System.out.println(nom+" envoie son nom vers le serveur ");
		
		//Reception de la repense de serveur
		response=new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		if(response.readLine().equals("OK")){
			String s=null;
			System.out.println("Reception de OK");
			
			while((s=response.readLine())!=null){
				
				System.out.println("La valeur de n recu :"+s);
				//Envoie de s+1 vers le serveur
				System.out.println("Envoie de  :"+(Integer.parseInt(s)+1));
				request.println(Integer.parseInt(s)+1);
				request.flush();
			}
		}
		socket.close();
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
