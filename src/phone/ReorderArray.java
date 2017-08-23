package phone;
/*
 * 給了一道array swap的題目，如下
{1， 4， 3， 0， 2}
{a,   b,  e,   f,  c}
 */
public class ReorderArray {
	public void reOrder(char[] chars,int[] orders){
		for(int i=0;i<orders.length;i++){
			if(i!=orders[i]){
				int temp=orders[i];
				char tempChar=chars[i];
				orders[i]=orders[temp];
				orders[temp]=temp;
				chars[i]=chars[temp];
				chars[temp]=tempChar;
				i--;
			}
		}
	}
}
