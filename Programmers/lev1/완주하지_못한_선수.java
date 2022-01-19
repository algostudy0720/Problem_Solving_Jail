package Programmers.lev1;

import java.util.Arrays;

public class 완주하지_못한_선수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		solution(participant, completion);
	}

	public static String solution(String[] participant, String[] completion) {
        String answer = "";
       
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i = 0;
        for (i = 0; i < completion.length; i++) {
			if(!participant[i].equals(completion[i])) {
				break;
			}
		}
        
        answer = participant[i];
        return answer;
    }
}

