package Programmers;

public class 멀쩡한_사각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(8,12);
	}

	public static long solution(int w, int h) {
		long answer = 0;
		long a = 0, b = 0, temp = 0;
		if(w >= h) {
			a = (long)w;
			b = (long)h;
		}
		else {
			a = (long)w;
			b = (long)h;
		}
		
        
		for (long i = b; i > 0; i--) {
			if(a % i == 0 && b % i == 0) {
				temp = i;
				break;
			}
		}
		
        
		answer = ((long)w*(long)h)-((long)w+(long)h-temp);
		return answer;
	}
}
