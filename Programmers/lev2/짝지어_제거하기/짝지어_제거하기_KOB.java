package com.ssafy.pro.lv2;

import java.util.*;

// 22.02.10 Programmers 2017 팁스타운

public class 짝지어_제거하기_KOB {
	/*
	    1. s는 소문자로 이루어진 문자열
	    2. 같은 알파벳이 2개 붙어있으면 제거
	    3. 모두 제거될 수 있으면 1
	    4. 모두 제거될 수 없으면 0
	*/
	
	public static int solution(String s)
	{
	    
	    Stack<Character> stack = new Stack<>();
	    
	    int len = s.length();
	    
	    for(int i = 0; i < len; i++){
	        if(stack.size() == 0 || stack.peek() != s.charAt(i)){
	            stack.push(s.charAt(i));
	        } else {
	            stack.pop();
	        }
	    }
	    
	    if(stack.size() != 0)
	        return 0;
	    else
	        return 1;
	}
	
	public static void main(String[] args) {
		String s = "baabaa";
		System.out.println(solution(s));
	}
}
