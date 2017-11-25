package phone;
import java.util.*;
/*
 * 要实现一个一维的消消乐，也就是多于三个连续的元素要删掉，要考虑级联输入(1,2,2,2,1)要输出(1,1)
输入(1,2,2,2,1,1)要输出().
输入(1,2,2,2,1,1,3,3,3,1)要输出(1)，因为消除三个2的时候，三个1放到了一起被消掉了。所以最后的1留下来了
一开始问我打算输入输出用啥type，说string。然后问要in-place，于是改array。又问删除复杂度是多少能不能更快一点，于是换成链表。
 */
public class Anipop {
	public List<Integer> popElements(int[] nums){
		List<Integer> res=new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++){
			if(res.size()>=2&&res.get(res.size()-1)==nums[i]&&res.get(res.size()-2)==nums[i]){
				while(i+1<nums.length&&nums[i+1]==nums[i]){
					i++;
				}
				while(res.size()>0&&res.get(res.size()-1)==nums[i]){
					res.remove(res.size()-1);
				}
			}
			else{
				res.add(nums[i]);
			}
		}
		return res;
	}
}
