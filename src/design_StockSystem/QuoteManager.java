package design_StockSystem;
import java.util.*;
/*
 * design a stock price system. Input are ticket, quote side and price . 
 * Supports read best bid and ask, top 10 bid and ask, and all quote history
 */
public class QuoteManager {
	Map<String,TreeSet<Quote>> currSellQuote;
	Map<String,TreeSet<Quote>> currBuyQuote;
	Map<String,Set<Quote>> oldlQuote;
	Comparator<Quote> buyCom;
	Comparator<Quote> sellCom;
	public QuoteManager(){
		this.currBuyQuote=new HashMap<String,TreeSet<Quote>>();
		this.currSellQuote=new HashMap<String,TreeSet<Quote>>();
		this.oldlQuote=new HashMap<String,Set<Quote>>();
		this.buyCom=new Comparator<Quote>(){
			public int compare(Quote q1,Quote q2){
				return q1.price-q2.price;
			}
		};
		this.sellCom=new Comparator<Quote>(){
			public int compare(Quote q1,Quote q2){
				return q2.price-q1.price;
			}
		};
	}
	public void addQuote(Quote toadd){
		Map<String,TreeSet<Quote>> curr=toadd.side==Side.BUY?this.currBuyQuote:this.currSellQuote;
		if(!curr.containsKey(toadd.symbol)){
			curr.put(toadd.symbol, new TreeSet<Quote>(toadd.side==Side.BUY?buyCom:sellCom));
		}
		curr.get(toadd.symbol).add(toadd);
	}
	public void matchOrPutQuote(Side side,int price,String symbol){
		Quote toadd=new Quote(side,price,symbol);
		if(toadd.side==Side.BUY){
			Map<String,TreeSet<Quote>> curr=this.currSellQuote;
			if(curr.containsKey(toadd.symbol)&&curr.get(toadd.symbol).iterator().next().price<=toadd.price){
				trashQuote(toadd);
				Quote counter=curr.get(toadd.symbol).iterator().next();
				trashQuote(counter);
				if(curr.get(counter.symbol).isEmpty()){
					curr.remove(counter.symbol);
				}
			}
			else{
				addQuote(toadd);
			}
		}
		else{
			Map<String,TreeSet<Quote>> curr=this.currBuyQuote;
			if(curr.containsKey(toadd.symbol)&&curr.get(toadd.symbol).iterator().next().price>=toadd.price){
				trashQuote(toadd);
				Quote counter=curr.get(toadd.symbol).iterator().next();
				trashQuote(counter);
				if(curr.get(counter.symbol).isEmpty()){
					curr.remove(counter.symbol);
				}
			}
			else{
				addQuote(toadd);
			}
		}
	}
	public void trashQuote(Quote toTrash){
		if(!this.oldlQuote.containsKey(toTrash.symbol)){
			this.oldlQuote.put(toTrash.symbol, new HashSet<Quote>());
		}
		this.oldlQuote.get(toTrash.symbol).add(toTrash);
	}
	public Quote findBestQuote(String symbol,Side side){
		Map<String,TreeSet<Quote>> curr=side==Side.BUY?this.currBuyQuote:this.currSellQuote;
		if(curr.containsKey(symbol)){
			return curr.get(symbol).iterator().next();
		}
		return null;
	}
	public List<Quote> findBestTenQuote(String symbol,Side side){
		List<Quote> res=new ArrayList<Quote>();
		Map<String,TreeSet<Quote>> curr=side==Side.BUY?this.currBuyQuote:this.currSellQuote;
		if(curr.containsKey(symbol)){
			Iterator<Quote> it=curr.get(symbol).iterator();
			while(it.hasNext()&&res.size()<10){
				res.add(it.next());
			}
		}
		return res;
	}
}
