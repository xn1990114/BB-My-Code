package onsite;
import java.util.*;
/*
 * {"a", 100, 200} {"b", 200, 300} {"c", 200, 100} ...  n个组合"a","b","c"是员工的名字，
 * 第一个数字是去第一个城市出差的费用，第二个数字是去第二个城市出差的费用，要求派一半员工去第一个城市，
 * 另一半去第二个城市，怎么让公司开销最少。
 */
public class TravelPlan {
	class Element{
		char name;
		int diff;
		public Element(int name,int c1,int c2){
			this.name=(char)(name+'a');
			this.diff=c1-c2;
		}
	}
	public List<List<Character>> makePlan(int[] c1,int[] c2){
		if(c1.length%2==1){
			return null;
		}
		List<List<Character>> result=new ArrayList<List<Character>>();
		List<Character> l1=new ArrayList<Character>();
		List<Character> l2=new ArrayList<Character>();
		result.add(l1);
		result.add(l2);
		Element[] els=new Element[c1.length];
		for(int i=0;i<c1.length;i++){
			Element e=new Element(i,c1[i],c2[i]);
			els[i]=e;
		}
		int k=c1.length/2;
		quickSelect(els,k,0,els.length-1);
		for(int i=0;i<els.length;i++){
			if(i<k){
				l1.add(els[i].name);
			}
			else{
				l2.add(els[i].name);
			}
		}
		return result;
	}
	public void quickSelect(Element[] els, int k,int start,int end){
		if(start>end){
			return;
		}
		Element curr=els[start];
		int s=start+1;
		int e=end;
		while(s<=e){
			while(s<=e&&els[s].diff<=curr.diff){
				s++;
			}
			while(e>=s&&els[e].diff>curr.diff){
				e--;
			}
			if(s<=e){
				Element temp=els[e];
				els[e]=els[s];
				els[s]=temp;
				s++;
				e--;
			}
		}
		els[start]=els[e];
		els[e]=curr;
		if(e+1==k){
			return ;
		}
		else if(e+1<k){
			quickSelect(els,k,e+1,end);
		}
		else{
			quickSelect(els,k,start,e-1);
		}
	}
}
