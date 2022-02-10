package programmers;
import java.util.*;
public class 짝지어_제거하기_PDW {
    public int solution(String s)
    {
       int answer= 0;
        int idx = 1;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty()&&stack.peek() == ch) {
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        
        if(stack.size()==0) answer=1;

        return answer;
    }
}
