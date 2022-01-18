package Programmers;

public class 멀쩡한_사각형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(8,12);
	}

	public static long solution(int w, int h) {
		long answer = 0;
		int a = 0, b = 0, temp = 0;
		if(w >= h) {
			a = w;
			b = h;
		}
		else {
			a = h;
			b = w;
		}
		
//		for (int i = b; i > 0; i--) {
//			if(a % i == 0 && b % i == 0) {
//				temp = i;
//				break;
//			}
//		}
		temp = a % b;
		
		answer = (w*h)-(w+h-temp);
		System.out.println(answer);
		return answer;
	}
}
