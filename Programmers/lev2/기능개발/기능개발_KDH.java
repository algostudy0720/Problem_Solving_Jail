package Programmers.lev2;


public class 기능개발 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses= {95, 90, 99, 99, 80, 99}; 
		int[] speeds = {1, 1, 1, 1, 1, 1};
		solution(progresses, speeds);
	}
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] arr = new int[progresses.length];
        int temp = 0;
        for (int i = 0; i < progresses.length; i++) {
        	temp = (100 - progresses[i]) / speeds[i];
        	if((100 - progresses[i]) % speeds[i] != 0)
        		temp++;
        	arr[i] = temp;
		}
        
        int start = arr[0];
        int arr_size = 1;
        for (int i = 0; i < arr.length; i++) {
			if(start < arr[i]) {
				start = arr[i];
				arr_size++;
			}
		}
        answer = new int[arr_size];
        
        int num = arr[0];
        int cnt = 0;
        for (int i = 0, v = 0; i < arr.length; i++) {
			if(i != 0 && num < arr[i]) {
				num = arr[i];
				answer[v++] = cnt;
				cnt=0;
			}		
			if(arr[i] <= num)
				cnt++;
		}
   
        answer[answer.length-1] = cnt;
        return answer;
    }
}
