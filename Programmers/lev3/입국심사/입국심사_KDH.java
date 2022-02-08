package Programmers.lev3;

import java.util.Arrays;

public class 입국심사 {

	public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};
		solution(n, times);
		
	}

    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = 1;
        long right = n * (long)times[times.length-1];
        answer = right;
        
        long sum = 0;
        while(left <= right) {
        	long mid = (left + right) / 2;
        	sum = 0;
        	
        	for (int i = 0; i < times.length; i++) 
				sum += mid / times[i];
        	
        	if(sum < n) 
        		left = mid+1;
        	else {
        		right = mid - 1;
        		answer = mid;
        	}
			
        }
        
        System.out.println(answer);
        return answer;
    }
}
