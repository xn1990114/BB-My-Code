package onsite;

/*
 * 第一道是
给aaabbca=>abcbccd
a a a b b c a
a b c b c c d
小印只给了几个例子，也没有解释清楚。后来我自己又写了几个例子，问他输出应该是什么才弄清楚。
其实不难，对于某个字母如果第一次碰到，不改变，第二次碰到，变为该字母在字母表中的下一个字母（z的下一个是a），
第三次碰到，变为下下个字母。依次类推。
 */
public class StringConvertIncremental {
	public String increaseString(String s){
		StringBuilder sb=new StringBuilder();
		int[] incre=new int[26];
		for(int i=0;i<s.length();i++){
			int curr=incre[s.charAt(i)-'a'];
			sb.append((char)(s.charAt(i)+curr));
			incre[s.charAt(i)-'a']=(incre[s.charAt(i)-'a']+1)%26;
		}
		return sb.toString();
	}
}
