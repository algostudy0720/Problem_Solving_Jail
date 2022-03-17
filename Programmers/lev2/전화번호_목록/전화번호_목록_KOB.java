package com.ssafy.pro.lv2;

import java.util.*;

// 22.03.17 Programmers 해시

public class 전화번호_목록_KOB {
	public static boolean solution(String[] phone_book) {
        int len = phone_book.length;
        
        Arrays.sort(phone_book);
                
        for(int i = 0; i < len - 1; i++){
            String X = phone_book[i];
            String Y = phone_book[i+1];

            if(Y.startsWith(X))
                return false;
            
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		System.out.println(solution(phone_book));
	}
}
