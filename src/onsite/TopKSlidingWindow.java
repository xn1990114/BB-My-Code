package onsite;
import java.util.*;
/*
 * topk in sliding window...
 * {2,1,5,2,1,6,1,4,4,5,7,9,1}
 */
public class TopKSlidingWindow {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List[] findTopK(int[] nums,int k,int windowSize){
		List[] result=new List[nums.length-windowSize+1];
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>(new Comparator<Integer>(){
			public int compare(Integer i1,Integer i2){
				return i2-i1;
			}
		});
		for(int i=0;i<result.length;i++){
			result[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<nums.length;i++){
			int curr=nums[i];
			if(!map.containsKey(curr)){
				map.put(curr, 0);
			}
			map.put(curr, map.get(curr)+1);
			int start=i-windowSize+1;
			if(start>=0){
				addElement(result[start],map,k);
				int last=nums[start];
				map.put(last,map.get(last)-1);
				if(map.get(last)==0){
					map.remove(last);
				}
			}
		}
		
		return result;
	}
	public void addElement(List<Integer> list,TreeMap<Integer,Integer> map,int k){
		for(int key:map.keySet()){
			int count=map.get(key);
			for(int i=0;i<count&&list.size()<k;i++){
				list.add(key);
			}
		}
	}
}
