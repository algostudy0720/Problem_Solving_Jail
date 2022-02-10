package Programmers.lev2;

import java.util.Stack;

public class 짝지어_제거하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cdcd";
		solution(s);
	}
	
    public static int solution(String s)
    {
        int answer = 0;

        
        Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(!stack.isEmpty() && stack.peek() == ch) stack.pop();
			else stack.push(ch);
		}
		
		if(stack.isEmpty())
			answer = 1;
		
        return answer;
    }
}
