package ma.ac.ensa;

public class Jeu {
	
	private int MAX;
	private int n;
	
	public Jeu() {
		super();
	}
	public Jeu(int MAX) {
		super();
		this.MAX = MAX;
	}
	public Jeu(int n,int MAX) {
		super();
		this.n = n;
		this.MAX = MAX;
	}
	public void start(){
		this.n = 0;
	}
	public boolean isFinish(){
		
		if(n==MAX){
			return true;
		}else {
			return false;
		}
			
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	
}
