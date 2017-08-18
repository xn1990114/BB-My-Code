package design_StockSystem;

public class Quote {
	Side side;
	int price;
	String symbol;
	public Quote(Side s,int price,String name){
		this.side=s;
		this.price=price;
		this.symbol=name;
	}
	
}
