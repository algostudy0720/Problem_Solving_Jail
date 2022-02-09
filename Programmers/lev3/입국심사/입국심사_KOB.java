package com.ssafy.pro.lv3;

import java.util.*;

// 22.02.09 Programmers 이분탐색

public class 입국심사_KOB{
    public static long solution(int n, int[] times) {
        int len = times.length;
        Arrays.sort(times);
        
        long answer = n *  (long)times[len - 1];
                
        long start = 1;
        long end = answer;

        
        while(start <= end){
            long person = 0;
            long mid = (start + end) / 2;
    
            for(int i = 0; i < len; i++){
                person += mid/times[i];
            }
            
            if(person < n){
                start = mid + 1;
            } else{
                end = mid - 1;
                answer = mid;
            }
           
        }
                
        return answer;
    }
    
    public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};
		System.out.println(solution(n, times));
	}
}
