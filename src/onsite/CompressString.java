package onsite;

/*
 * 压缩string,  aaabbbcc -> a3b3c2  傻逼题。秒写完code.  
 * 我是用java 写的， 感觉那人是用c++的，他好像期待我能够Inplace, 但是java 的string是immutable的， 
 * 所以他最后说返回一个new string 也OK吧。  - -！
 */
public class CompressString {
	public String compress(String s){
		StringBuilder sb=new StringBuilder();
		int i=0;
		while(i<s.length()){
			if(i+1==s.length()||s.charAt(i)!=s.charAt(i+1)){
				sb.append(s.charAt(i));
				i++;
			}
			else{
				int count=1;
				while(i+1<s.length()&&s.charAt(i)==s.charAt(i+1)){
					count++;
					i++;
				}
				sb.append(s.charAt(i));
				sb.append(count);
				i++;
			}
		}
		return sb.toString();
	}
}
