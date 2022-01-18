package Programmers.lev1;

public class 음양_더하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		solution(absolutes, signs);
	}

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for (int i = 0; i < absolutes.length; i++) {
			if(signs[i] == true)
				answer += absolutes[i];
			else
				answer += absolutes[i]*-1;
		}
        System.out.println(answer);
        return answer;
    }
}
