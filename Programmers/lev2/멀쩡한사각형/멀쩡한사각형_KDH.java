package Programmers.lev2;

public class _124_나라의_숫자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(10);
	}

	public static String solution(int n) {
	      String[] num = {"4","1","2"};
	      String answer = "";

	      while(n > 0){
	          answer = num[n % 3] + answer;
	          n = (n - 1) / 3;
	      }
	      System.out.println(answer);
	      return answer;
	}
}
