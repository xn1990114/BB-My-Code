package onsite;
import java.util.*;
/*
 * 白人老大叔问的是给了一段掺杂着各种左右括号的话，然后从中间开始print每一对合法括号里的句子，直到最外层。
 * 当然，如果这段话里面的括号不合法，就直接结束。
举个简单地栗子给大家：比如({I [ forget ( the ) details ] sorry } minasang)   
这段话里面括号都是合法的，所以 print的结果是：
the,
forget the details,
I forget the details sorry
I forget the details sorry minasang
然后大叔会问非常非常多corner case，并且不允许你在代码前去处理这些corner case，要在主要结构里面把这些都解决了
 */
public class ParenthesisStringParser {
	public List<String> parse(String s){
		List<String> res=new ArrayList<String>();
		Stack<Character> bracket=new Stack<Character>();
		Stack<StringBuilder> sbs=new Stack<StringBuilder>();
		Map<Character,Character> map=new HashMap<Character,Character>();
		map.put(')', '(');map.put(']', '[');map.put('}', '{');
		int index=0;
		while(index<s.length()){
			char ch=s.charAt(index);
			if(Character.isLetterOrDigit(ch)){
				int start=index;
				if(sbs.isEmpty()){
					return new ArrayList<String>();
				}
				while(index<s.length()&&Character.isLetterOrDigit(s.charAt(index))){
					index++;
				}
				if(sbs.peek().length()>0){
					sbs.peek().append(' ');
				}
				sbs.peek().append(s.substring(start,index));
			}
			else if(map.containsKey(ch)){
				if(bracket.isEmpty()||bracket.pop()!=map.get(ch)){
					return new ArrayList<String>();
				}
				String curr=sbs.pop().toString();
				if(!sbs.isEmpty()){
					if(sbs.peek().length()>0){
						sbs.peek().append(' ');
					}
					sbs.peek().append(curr);
				}
				res.add(curr);
				index++;
			}
			else{
				bracket.push(ch);
				sbs.push(new StringBuilder());
				index++;
			}
		}
		if(!sbs.isEmpty()){
			return new ArrayList<String>();
		}
		return res;
	}
	public boolean sameStringList(String[] r1,List<String> r2){
		if(r1.length!=r2.size()){
			return false;
		}
		for(int i=0;i<r1.length;i++){
			if(!r1[i].equals(r2.get(i))){
				return false;
			}
		}
		return true;
	}
}
