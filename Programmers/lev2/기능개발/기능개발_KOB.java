package com.ssafy.pro.lv2;

// 22.01.23 Programmers 스택/큐

import java.util.*;

public class 기능개발_KOB {
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < speeds.length; i++){
            int work = 100 - progresses[i];
            int day = work/speeds[i];
            
            if(work%speeds[i] != 0)
                day++;
            
            // 작업 완료시까지 걸리는 시간
            queue.offer(day);
        }
        
        while(queue.size() != 0){
            // 가장 처음 작업이 끝난 시간
        	int current = queue.poll();
            int result = 1;
            
            // current보다 이전에 끝난 작업들 계산
            while(queue.size() != 0){
                if(queue.peek() > current)
                    break;
                
                result++;
                queue.poll();
            }
            
            list.add(result);
        }
        
        answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
	
}
