package design_PhoneBook;
import java.util.*;

public class PhoneBook {
	Trie book_first;
	Trie book_last;
	HashMap<String,Person> map;
	public PhoneBook(){
		this.book_first=new Trie();
		this.book_last=new Trie();
		this.map=new HashMap<String,Person>();
	}
	public boolean addContact(String first,String last,String number){
		if(number.length()!=10){
			return false;
		}
		if(this.map.keySet().contains(number)){
			return false;
		}
		Person toadd=new Person(first,last,number);
		this.map.put(number, toadd);
		boolean canInsertFirst=this.book_first.insert(first, toadd);
		boolean canInsertLast=this.book_last.insert(last,toadd);
		return canInsertFirst&&canInsertLast;
	}
	public boolean removeContact(String first,String last,String number){
		if(number.length()!=10){
			return false;
		}
		Person target=map.get(number);
		if(target==null){
			return false;
		}
		this.map.remove(number);
		boolean canRemoveFirst=this.book_first.remove(first, target);
		boolean canRemoveLast=this.book_last.remove(last, target);
		return canRemoveFirst&&canRemoveLast;
	}
	public List<String> searchFirst(String name){
		return this.book_first.search(name);
	}
	public List<String> searchLast(String name){
		return this.book_last.search(name);
	}
}
