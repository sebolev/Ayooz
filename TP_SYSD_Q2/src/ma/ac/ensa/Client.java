package ma.ac.ensa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

private int numclient;
private Socket socket;
private BufferedReader response;

public Client(int numc) {
	
	numclient=numc;
}
public void showMessage() throws IOException{
	
	try {
		socket=new Socket(InetAddress.getLocalHost(),2001);
		response=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println("Message reçu : "+response.readLine()+" Client "+numclient);
		response.close();
		socket.close();
	} catch (UnknownHostException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
