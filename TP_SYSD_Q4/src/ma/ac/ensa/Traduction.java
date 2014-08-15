package ma.ac.ensa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Traduction {

	private String langueSource;
	private String langueCible;
	
	public Traduction(String langueSource, String langueCible) {
		super();
		this.langueSource = langueSource;
		this.langueCible = langueCible;
	}
	public String getMessageTraduit(String message){
        Scanner sc = null;
        String s;
			try {
				sc = new Scanner(new File(langueSource+"-"+langueCible+".txt"));
				while((s=sc.next())!=null){
					if(s.equalsIgnoreCase(message)){
					return sc.next();
					}
				}
			} catch (FileNotFoundException e) {
				try {
					sc = new Scanner(new File(langueCible+"-"+langueSource+".txt"));
					while((s=sc.next())!=null){
						if(sc.next().equalsIgnoreCase(message)){
						return s;
						}
					} 
				}catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}finally{
				sc.close();
			}
			return null;
	}		
		
	public String getLangueSource() {
		return langueSource;
	}
	public void setLangueSource(String langueSource) {
		this.langueSource = langueSource;
	}
	public String getLangueCible() {
		return langueCible;
	}
	public void setLangueCible(String langueCible) {
		this.langueCible = langueCible;
	}
	
}
