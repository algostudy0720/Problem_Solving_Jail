package programmers.해시;

import java.util.*;

public class 전화번호_목록_PDW {
    public boolean solution(String[] phone_book) {
        HashSet<String> map = new HashSet<>();
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length; i++){
        	for(int j=0; j<=phone_book[i].length(); j++) {
        		if(map.contains(phone_book[i].substring(0, j))) { 
        			return false;
        		}
        	}
            map.add(phone_book[i]);
        }
        return true;
    }
}