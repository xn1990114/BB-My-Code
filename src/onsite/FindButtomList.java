package onsite;
import java.util.*;
/*
 * Linked List 变形。 K list. 
有一条主list, 给你h1头结点， 然后其余n-1个list都会与这条主list相融合。 
就是会有intersection点，后半部分合并。求最bottom的list的head。 
输入是arr of heads [h1,h2,h3....hn].  很像以前的Y list。 
只不是这题完全不是按以前找intersection点的方式去做，而且反而那样想，容易使你陷入，找不到最优方式。 
最bottom的list得定义是  他与主list相交的点是位于最后，相对其他intersection node of other lists

这题我提出方式用set可以找出最后全部list相交的点，可以那样之后就很难base on this, 找出bottom list的head. 
最后他给我了提示，要记录下每个点被访问次数，我这才恍然大悟。
比如总共有4个list， bottom list 的node 将会是从访问次数1直接跳至访问次数4的点。
1 （h1）
|
2  -- 1 -- 1 (h2)
| 
3  -- 1 --.... --1 (h3)
|
4  -- 1 -- 1  (h4)

由此可见，最bottom的list (h4) 访问次数的突变是其他list里不会发生的。 这就是它的特殊性！！
最后写了记录次数的code, 用hashmap就好。 后面的code他也不需要写了， 因为很简单。 
 */

/*
 * my way: use hashmap to record the index of each node in parent
 * appear to be better: less space,less time
 */
public class FindButtomList {
	public class Node{
		int val;
		public Node next;
		public Node(int val){
			this.val=val;
		}
	}
	// main list is always at index 0;
	public Node findButtomHead(Node[] heads){
		Node currLatest=heads[0];
		int buttomIndex=0;
		HashMap<Node,Integer> map=new HashMap<Node,Integer>();
		Node curr=heads[0];
		int index=0;
		while(curr!=null){
			map.put(curr,index);
			index++;
			curr=curr.next;
		}
		for(int i=1;i<heads.length;i++){
			curr=heads[i];
			while(curr!=null){
				if(map.keySet().contains(curr)){
					if(map.get(curr)>map.get(currLatest)){
						currLatest=curr;
						buttomIndex=i;
					}
					break;
				}
				curr=curr.next;
			}
		}
		return heads[buttomIndex];
	}
}
