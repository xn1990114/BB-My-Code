package onsite;

import java.util.*;

/*
 * 情景是UDP传输，假设收到许多out of order的sequence（带序号的内容），排序组装后按顺序打印完整的内容， 例如，
input:
[1,"a"]    // 立刻输出a. 
[2,"b"]    // 立刻输出ab. 
[4,"d"]    // 无输出，缺sequence 3.
[3,"c"]    // 立刻输出abcd
 */
public class UDPCharSequence {
	class Element implements Comparable<Element>{
		int seq;
		String content;
		public Element(int seq,String content){
			this.seq=seq;
			this.content=content;
		}
		public int compareTo(Element e2){
			return this.seq-e2.seq;
		}
	}
	public List<String> generateString(int[] seqs,String[] content){
		List<String> res=new ArrayList<String>();
		StringBuilder sb=new StringBuilder();
		int currSeq=0;
		PriorityQueue<Element> pq=new PriorityQueue<Element>();
		for(int i=0;i<seqs.length;i++){
			Element toadd=new Element(seqs[i],content[i]);
			pq.offer(toadd);
			if(pq.peek().seq==currSeq+1){
				while(!pq.isEmpty()&&pq.peek().seq==currSeq+1){
					currSeq++;
					sb.append(pq.poll().content);
				}
				res.add(sb.toString());
			}
		}
		return res;
	}
	public boolean sameRes(List<String> r1,String[] r2){
		if(r1.size()!=r2.length){
			return false;
		}
		for(int i=0;i<r1.size();i++){
			if(!r1.get(i).equals(r2[i])){
				return false;
			}
		}
		return true;
	}
}
