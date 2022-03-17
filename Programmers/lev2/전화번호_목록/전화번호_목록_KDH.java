package Programmers.lev2;

import java.util.Arrays;

public class 전화번호_목록 {

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		solution(phone_book);
	}

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        System.out.println(Arrays.deepToString(phone_book));
        
        for (int i = 0; i < phone_book.length - 1; i++) {
			if(phone_book[i + 1].startsWith(phone_book[i]))
				answer = false;
		}
        
        System.out.println(answer);
        return answer;
    }
}
