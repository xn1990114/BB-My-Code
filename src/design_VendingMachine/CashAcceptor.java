package design_VendingMachine;

public class CashAcceptor {
	int remaining;
	int max;
	public CashAcceptor(int remaining,int max){
		this.remaining=remaining;
		this.max=max;
	}
	public boolean dispenseCash(int amount){
		if(this.remaining<amount){
			return false;
		}
		System.out.println("Acceptor is giving: "+amount+" cents");
		return true;
	}
	public boolean addCash(int amount){
		if(this.remaining+amount>max){
			return false;
		}
		System.out.println("Acceptor is receiving: "+amount+" cents");
		return true;
	}
}
