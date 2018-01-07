package onsite;

import java.util.*;

/*
 * 给你一个string， 再给你一堆range of index，删除string中相应的位置。range of index 无序，可能out of bound。
 * sample input:
“abcdefghij”
(2,3) (1,3) (4,5)
sample output:
“aghij”
 */
public class RemoveStringInRange {
	public String removeString(String s,int[][] ranges){
		Arrays.sort(ranges,new Comparator<int[]>(){
			public int compare(int[] i1,int[] i2){
				return i1[0]-i2[0];
			}
		});
		int rangeIndex=0;
		int charIndex=0;
		StringBuilder sb=new StringBuilder();
		while(charIndex<s.length()){
			while(rangeIndex<ranges.length&&charIndex>=ranges[rangeIndex][0]){
				charIndex=Math.max(charIndex, ranges[rangeIndex][1]+1);
				rangeIndex++;
			}
			int max=rangeIndex<ranges.length?ranges[rangeIndex][0]:s.length();
			while(charIndex<max&&charIndex<s.length()){
				sb.append(s.charAt(charIndex));
				charIndex++;
			}
		}
		return sb.toString();
		
	}
}
