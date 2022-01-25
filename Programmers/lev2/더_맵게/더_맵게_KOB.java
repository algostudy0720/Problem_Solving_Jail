package com.ssafy.pro.lv2;

// 22.01.25 Programmers 힙(Heap)

import java.util.*;

public class 더_맵게_KOB{
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 오름차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>();
       
        for(int i = 0; i < scoville.length; i++) {
        	pq.offer(scoville[i]);
        }
        
        while(pq.peek() < K) {
        	if(pq.size() < 2)
        		return -1;
        	
        	int mix = pq.poll() + 2*pq.poll();
        	
        	if(mix < K)
        		pq.offer(mix);
        	answer++;
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;
		
		System.out.println(solution(scoville, K));
	}
}
