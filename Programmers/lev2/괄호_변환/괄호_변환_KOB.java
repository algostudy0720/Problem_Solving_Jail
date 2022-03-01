package com.ssafy.pro.lv2;

import java.util.*;

// 22.03.01 Programmers 2020 KAKAO BLIND RECRUITMENT

public class 괄호_변환_KOB{
    /*
    1. 균형잡힌 괄호 문자열 : '(', ')'의 갯수가 일치
    2. 올바른 괄호 문자열 : 1번 + 괄호의 짝도 일치
    
    변환 과정(균형잡힌 괄호 문자열의 경우에만)
    1. 입력이 빈 문자열 -> 빈 문자열 반환
    2. w를 균형잡힌 괄호 문자열 u, v로 분리
        * u는 더 이상 분리 불가능한 균형잡힌 괄호 문자열
        * v는 빈 문자열도 가능
    3. u가 올바른 괄호 문자열이면 v는 1 단계부터 실행
        3.1 : 수행한 결과를 u에 이어 붙인 후 반환
    4. u가 올바른 괄호 문자열이 아닌 경우
        4-1. 빈 문자열에 첫 문자 '('
        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙힌다.
        4-3. ')'를 붙임
        4-4. u의 첫 번째, 마지막 문자를 제거
        4-5. 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙임
        4-6. 문자열 반환
        
    
	*/
	public static String solution(String p) {     
	    
	    // 1 단계
	    if(p.equals(""))
	        return "";
	    
	    if(isCorrect(p) == 1)
	        return p;
	    
	    // 2 단계
	    String u = "";
	    String v = "";
	    int state = -1;
	    for(int i = 1; i < p.length(); i++){
	        state = isCorrect(p.substring(0, i+1));
	        if(state == 0 || state == 1){
	            u = p.substring(0, i+1);
	            v = p.substring(i+1, p.length());
	            break;
	        }
	    }
	    
	    // 3 단계
	    if(state == 1){
	        return u + solution(v);
	    }
	    // 4 단계
	    else{
	        // 4-1
	        String str = "(";
	        
	        // 4-2
	        str += solution(v);
	        
	        // 4-3
	        str += ")";
	        StringBuilder sb = new StringBuilder();
	        sb.append(str);
	        
	        // 4-4
	        for(int i = 1; i < u.length()-1; i++){
	            if(u.charAt(i) == '(')
	                sb.append(')');
	            else
	                sb.append('(');
	        }
	         
	        // 4-5
	        return sb.toString();
	    }
	}
	
	// 문자열 판독
	// 1 : 올바른 괄호 문자열
	// 0 : 균형잡힌 괄호 문자열
	// -1 : 이도저도 아닌 문자열
	private static int isCorrect(String str){
	    Stack<Character> st = new Stack<>();
	    char[] strToCharArr = str.toCharArray();
	    int leftCnt = 0;
	    int rightCnt = 0;
	    
	    for(int i = 0; i < str.length(); i++){     
	        char current = strToCharArr[i];
	
	        if(current == '(')
	            leftCnt++;
	        else
	            rightCnt++;
	        
	        if(current == '(')
	            st.add(current);
	        else{
	            // current가 ')'
	            if(st.size() != 0 && st.peek() == '(')
	                st.pop();
	            else
	                st.add(current);
	        }
	    }
	    
	    if(st.size() == 0)
	        return 1;
	    else{
	        if(leftCnt == rightCnt)
	            return 0;
	        else
	            return -1;
	    }
	}
	
	public static void main(String[] args) {
		String p = "(()())()";
		System.out.println(solution(p));
	}

}
