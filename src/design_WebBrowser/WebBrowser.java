package design_WebBrowser;
import java.util.*;

public class WebBrowser {
	class Node{
		String url;
		Node previous;
		Node next;
		public Node(String url){
			this.url=url;
		}
	}
	String defaultUrl;
	int capacity;
	Map<String,Node> map;
	Node curr;
	Node head;
	public WebBrowser(int cap){
		this.capacity=cap;
		this.defaultUrl="blank";
		this.map=new HashMap<String,Node>();
	}
	public String forward(){
		if(curr.next==null){
			return "no next";
		}
		curr=curr.next;
		return curr.url;
	}
	public String backward(){
		if(curr.previous==null){
			return "no previous";
		}
		curr=curr.previous;
		return curr.url;
	}
	public void goToUrl(String url){
		Node next=map.get(url);
		if(next==null){
			if(map.size()==this.capacity){
				Node toremove=head;
				head=head.next;
				map.remove(toremove.url);
				head.previous=null;
			}
			next=new Node(url);
		}
		else{
			next.previous.next=next.next;
			next.next.previous=next.previous;
			next.next=null;
		}
		if(curr.next!=null){
			Node temp=curr.next;
			while(temp!=null){
				map.remove(temp.url);
				temp=temp.next;
			}
		}
		map.put(url, next);
		curr.next=next;
		next.previous=curr;
		this.curr=next;
	}
	public void start(){
		Node n=new Node(this.defaultUrl);
		this.head=n;
		this.map.put(this.defaultUrl, n);
		curr=head;
	}
	public void close(){
		this.map.clear();
		this.curr=null;
		this.head=null;
	}
}
