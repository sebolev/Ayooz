package ma.ac.ensa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

private int numclient;
private String langue;
private Socket socket;
private BufferedReader response;
private PrintWriter request;

public Client(int numc,String lang) {
	
	numclient=numc;
	langue=lang;
}
public void showMessage() throws IOException{
	
	try {
		socket=new Socket(InetAddress.getLocalHost(),2001);
		
		request=new PrintWriter(socket.getOutputStream());
		request.println(langue);
		request.flush();
		
		response=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println("Message reçu : "+response.readLine()+" Client "+numclient+" "+langue);
		response.close();
		
		socket.close();
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
