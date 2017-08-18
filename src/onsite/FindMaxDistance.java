package onsite;
import java.util.*;
/*
 * 第一题是给出一组数列代表stock price,
 * 找到2个坐标，i, j, 使得 price[i] < price[j] 并且确保 i 和 j 的距离是最远的
 */
public class FindMaxDistance {
	public int calMaxDistance(int[] nums){
		Stack<int[]> stack=new Stack<int[]>();
		for(int i=nums.length-1;i>=0;i--){
			if(stack.isEmpty()||nums[i]>stack.peek()[0]){
				int[] toadd={nums[i],i};
				stack.push(toadd);
			}
		}
		int max=0;
		for(int i=0;i<nums.length;i++){
			while(!stack.isEmpty()&&nums[i]<stack.peek()[0]){
				max=Math.max(max, stack.pop()[1]-i);
			}
		}
		return max;
	}
}
