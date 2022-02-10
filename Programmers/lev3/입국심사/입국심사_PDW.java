package programmers;
import java.util.*;

public class 입국심사_PDW {
	 public long solution(int n, int[] times) {
	        long answer = Long.MAX_VALUE;
	        Arrays.sort(times);
	        long left = 0;
	        long right =(long) n * times[times.length - 1];
	   
	        while(left<=right){
	            long people = 0;
	            long mid = (left + right) /2;
	            
	            for(int i =0; i< times.length; i++){
	                people += mid/times[i]; 
	            }
	            if(people < n){
	                left= mid+1;
	                
	            }else{
	                right = mid-1;
	                answer = Math.min(answer,mid);
	            }
	            
	        }
	        
	        
	        return answer;
	    }
}
