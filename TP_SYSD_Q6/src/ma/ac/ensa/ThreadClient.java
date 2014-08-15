package ma.ac.ensa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ThreadClient extends Thread{

	//Client
	private Socket socketduclient;
	private BufferedReader br;

	public ThreadClient(int portClient) throws UnknownHostException, IOException{
		
		this.socketduclient=new Socket(InetAddress.getLocalHost(),portClient);
		}
	public void run(){
		
		System.out.println("client start");
	}
	public String receive() {
		
		//Reception de message 
		try {
			br=new BufferedReader(new InputStreamReader(socketduclient.getInputStream()));
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
