package design_PhoneBook;
import java.util.*;

public class Trie {
	class Node{
		Node[] dic;
		Set<Person> numbers;
		public Node(){
			this.dic=new Node[256];
			this.numbers=new HashSet<Person>();
		}
	}
	public Node root;
	public Trie(){
		this.root=new Node();
	}
	public boolean insert(String name,Person p){
		Node curr=this.root;
		for(int i=0;i<name.length();i++){
			char ch=name.charAt(i);
			if(curr.dic[ch]==null){
				curr.dic[ch]=new Node();
			}
			curr=curr.dic[ch];
		}
		if(curr.numbers.contains(p)){
			return false;
		}
		curr.numbers.add(p);
		return true;
	}
	public boolean remove(String name,Person p){
		Node curr=this.root;
		for(int i=0;i<name.length();i++){
			char ch=name.charAt(i);
			if(curr.dic[ch]==null){
				curr.dic[ch]=new Node();
			}
			curr=curr.dic[ch];
		}
		if(!curr.numbers.contains(p)){
			return false;
		}
		curr.numbers.remove(p);
		return true;
	}
	public List<String> search(String name){
		List<String> result=new ArrayList<String>();
		search(this.root, name,result,0);
		return result;
	}
	public void search(Node curr,String name,List<String> result,int index){
		if(curr==null){
			return;
		}
		if(index==name.length()){
			for(Person p:curr.numbers){
				result.add(p.number);
			}
			for(int i=0;i<256;i++){
				if(curr.dic[i]!=null){
					search(curr.dic[i],name,result,index);
				}
			}
			return;
		}
		else{
			for(int i=index;i<name.length();i++){
				char ch=name.charAt(i);
				if(curr.dic[ch]==null){
					return;
				}
				curr=curr.dic[ch];
			}
			search(curr,name,result,name.length());
		}
	}
}
