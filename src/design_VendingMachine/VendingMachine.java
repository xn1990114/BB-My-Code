package design_VendingMachine;
import java.util.*;
/*
 * vending machine，里面有零钱，有产品，要求实现1.display()//显示产品信息， 2.addcoin//塞钱， 
 * 3.deliverProductAndReturnChange//給东西， 4.cancel, 5. reset。
 */
public class VendingMachine {
	Screen screen;
	CashAcceptor cashAcc;
	CashDispenser cashDis;
	Item currSelected;
	int currPaid;
	Map<Item,Integer> Stock;
	Item[][] shelf;
	public VendingMachine(){
		this.screen=new Screen();
		this.cashAcc=new CashAcceptor(0,0);
		this.cashDis=new CashDispenser(0,0);
		this.currSelected=null;
		this.currPaid=0;
		this.Stock=new HashMap<Item,Integer>();
		this.shelf=new Item[5][5];
	}
	public boolean addCoinToAcc(int amount){
		return this.cashAcc.addCash(amount);
	}
	public boolean addCoinToDis(int amount){
		return this.cashDis.addCash(amount);
	}
	public void dispenseChange(int amount){
		if(this.cashDis.remaining<amount){
			amount=amount-this.cashDis.remaining;
			this.cashDis.dispenseCash(this.cashDis.remaining);
			this.screen.display("Out of money, contact support. Change of "+amount+" is not dispensed");
		}
		else{
			this.cashDis.dispenseCash(amount);
		}
	}
	public void reset(){
		this.currSelected=null;
		if(this.currPaid>0){
			this.dispenseChange(currPaid);
		}
		currPaid=0;
	}
	public void addCoin(int amount){
		if(this.cashAcc.addCash(amount)){
			this.currPaid=this.currPaid+amount;
			this.screen.display("Currently Paid "+ this.currPaid);
			if(this.currPaid>=this.currSelected.price){
				deliverProductAndReturnChange();
			}
		}
		else{
			this.screen.display("Cash full, Please try later");
		}
	}
	private void deliverProductAndReturnChange() {
		this.Stock.put(this.currSelected, this.Stock.get(this.currSelected)-1);
		this.screen.display("Item dispensed");
		this.dispenseChange(this.currPaid-this.currSelected.price);
		this.reset();
	}
	public void displayItemInfo(int r,int c){
		if(this.shelf[r][c]==null){
			this.screen.display("Item not available");
		}
		else{
			this.screen.display(this.shelf[r][c].name);
		}
	}
	public void selectProduct(int r,int c){
		if(this.shelf[r][c]==null||this.Stock.get(this.shelf[r][c])==0){
			this.screen.display("Out of stock");
		}
		else{
			this.currSelected=this.shelf[r][c];
			this.screen.display("Item " + this.currSelected.name+" is selected");
		}
	}
	public void cancel(){
		this.currSelected=null;
	}
	public void addItem(Item item,int qty,int r,int c){
		this.shelf[r][c]=item;
		this.Stock.put(item, qty);
	}
}
