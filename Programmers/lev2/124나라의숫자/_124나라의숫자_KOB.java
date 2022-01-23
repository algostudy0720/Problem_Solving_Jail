package com.ssafy.pro.lv2;

// 22.01.23 Programmers 연습문제

public class _124나라의숫자_KOB {
    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int divisor = 3;    // 나누는 수, 3을 4처럼 계산
        int remain = 0;     // 나머지
        
        // 진수 변환하는 것처럼 계산
        while(n > 1){
            remain = n%divisor;            
            if(remain == 0)	// 나머지가 0이면 4로 처리
                answer.append("4");
            else
                answer.append(remain);
            
            if(n%3 == 0)	// 3으로 나누어떨어지는 수라면 몫에 -1
                n = n/divisor - 1;
            else
                n /= divisor;
        }
        
        if(n != 0)	// 몫이 1, 2일 때만 붙여줌
            answer.append(n);
        
        return String.valueOf(answer.reverse().toString());
    }
    
    public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
	}
}
