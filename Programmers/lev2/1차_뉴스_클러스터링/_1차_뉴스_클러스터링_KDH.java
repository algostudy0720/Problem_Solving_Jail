package Programmers.lev2;

import java.util.*;

public class _1차_뉴스_클러스터링 {

	public static void main(String[] args) {
		String str1 = "FRANCE";
		String str2 = "french";
		solution(str1, str2);
	}

    public static int solution(String str1, String str2) { 
    	int answer = 0;
    	ArrayList<String> mul1 = new ArrayList<>();
        ArrayList<String> mul2 = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i = 0 ; i < str1.length() - 1 ; ++i){
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);
            
            if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z')
                mul1.add(first + "" + second);
        }
        
        for(int i = 0 ; i < str2.length() - 1 ; ++i){
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);
            
            if(first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z')
                mul2.add(first + "" + second);
        }
        
        Collections.sort(mul1);
        Collections.sort(mul2);
              
        for(String s : mul1){
            if(mul2.remove(s))
              intersection.add(s);
            
            union.add(s);
        }
        
        for(String s : mul2)
            union.add(s);
        
        double ja = 0;
        
        if(union.size() == 0) 
            ja = 1;
        else 
            ja = (double)intersection.size() / (double)union.size();
        
        answer = (int)(ja * 65536);
        System.out.println(answer);
        
        return answer;
    }
}
