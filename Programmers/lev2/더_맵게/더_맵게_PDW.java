package programmers.힙;

import java.util.*;

public class 더_맵게_PDW {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        while(pq.peek()<K){
            if(pq.size()==1) {
                return -1;
            }
            int first = pq.poll();
            int second  = pq.poll();
            
            int sum = first + (second*2);
            answer++;
            pq.offer(sum); 
        }
 
        return answer;
    }
}