package Programmers.lev1;

import java.util.Arrays;

public class 소수_만들기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4};
		
		solution(nums);
	}
	
	static int answer = 0;
    public static int solution(int[] nums) {
        
        int[] numbers = new int[3];
        combination(0,0,nums, numbers);

        return answer;
    }
    
    public static void combination(int start, int cnt, int[] nums, int[] numbers) {
    	if(cnt == 3) {
    		System.out.println(Arrays.toString(numbers));
    		int sum = numbers[0] + numbers[1] + numbers[2];
    		for (int i = 2; i < sum; i++) {
				if(sum % i == 0)
					return;
			}
    		answer++;
    		return;
    	}
    	
    	for (int i = start; i < nums.length; i++) {
    		numbers[cnt] = nums[i];
			combination(i+1, cnt+1, nums, numbers);
			
    	}
    }
}
