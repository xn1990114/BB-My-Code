package design_VendingMachine;

public class CashDispenser {
	int remaining;
	int max;
	public CashDispenser(int remaining,int max){
		this.remaining=remaining;
		this.max=max;
	}
	public boolean dispenseCash(int amount){
		if(this.remaining<amount){
			return false;
		}
		System.out.println("Dispenser is giving: "+amount+" cents");
		return true;
	}
	public boolean addCash(int amount){
		if(this.remaining+amount>max){
			return false;
		}
		System.out.println("Dispenser is receiving: "+amount+" cents");
		return true;
	}
}
