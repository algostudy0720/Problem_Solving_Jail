package Programmers.lev1;

public class 없는_숫자_더하기 {

	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,6,7,8,0};
		
		solution(numbers);
	}

    public static int solution(int[] numbers) {
        int answer = 45;
        
        for (int i = 0; i < numbers.length; i++) {
			answer -= numbers[i];
		}
        
        System.out.println(answer);
        return answer;
    }
}
