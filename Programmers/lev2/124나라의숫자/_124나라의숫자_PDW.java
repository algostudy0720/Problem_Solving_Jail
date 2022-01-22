
public class _124나라의숫자 {
	class Solution {
	    public String solution(int n) {
	        String answer="";
	        String[] mapping = {"4","1","2"};
	        while(n>0){
	            answer=mapping[n%3] + answer;
	            if(n%3==0) n--;
	            n/=3;
	            
	        }
	        
	        return answer;
	    }
	}
}
