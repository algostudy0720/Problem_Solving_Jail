package Programmers.lev2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 더_맵게 {
	public static void main(String[] args) {
		int[] scoville = {5, 6};
		int K = 11;
		
		solution(scoville, K);
	}
	
	// 오답...
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        while(true) {
        	Arrays.sort(scoville);
        	if(scoville[scoville.length-1] == 1) {
        		return -1;
        	}
        	if(scoville[0] < K) {
        		scoville[0] = scoville[0] + (scoville[1]*2);
        		
        		if( scoville.length-1 >= 2 && scoville[2] == 1000000001) {
        			if(scoville[0] < K)
        				return -1;
        		}
        			
        		scoville[1] = 1000000001;
        		answer++;
        	}
        	else
        		break;
        }
        System.out.println(answer);
        return answer;
    }
	
	
	// 일반적으로 매번 Arrays.sort(scoville)을 해주게 되면 시간 초과가 발생한다.
	// 그렇기에 PriorityQueue를 사용하여 sort로 인해 낭비되는 시간을 줄여줘야 한다.
	public static int solution2(int[] scoville, int K) {
		   int answer = 0;

		   PriorityQueue<Integer> pq = new PriorityQueue<>();
		   for(int i=0; i<scoville.length; i++){
			   pq.offer(scoville[i]);
		   }

		   while(pq.peek() < K){
		       if(pq.size() < 2) 
		    	   return -1;
		       int f1 = pq.poll();
		       int f2 = pq.poll();

		       int temp = f1 + (f2 * 2);
		       pq.offer(temp);
		       answer++;
		   }

		   return answer;
		}
}
