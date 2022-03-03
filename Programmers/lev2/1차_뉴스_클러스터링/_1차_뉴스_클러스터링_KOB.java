package com.ssafy.pro.lv2;

import java.util.*;

// 22.03.03 Programmers 2018 KAKAO BLIND RECRUITMENT

public class _1차_뉴스_클러스터링_KOB {
	/*
	    # 자카드 유사도
	        - 집합 간 유사도 비교
	        - 집합 A, 집합 B
	        - J(A, B) = (A n B) / (A u B)
	        - A, B 모두 공집합이면 J(A, B) = 1
	        - 다중 집합 시 A n B는 같은 원소 갯수 중 작은 값
	        - 다중 집합 시 A u B는 같은 원소 갯수 중 큰 값
	        - 문자열은 두 글자씩 잘라서 계산
	        - 대소문자는 따로 구분하지 않음
	        - 특수 문자가 섞여있으면 버림
	        - 유사도 값은 실수, (곱하기)65536, 소수점 아래 버림
	*/
	
	public static int solution(String str1, String str2) {        
	    // 초기화
	    HashMap<String, Integer> map1 = init(str1);
	    HashMap<String, Integer> map2 = init(str2);
	    
	    // 유사도 측정
	    int answer = getJS(map1, map2);
	    
	    return answer;
	}
	
	private static HashMap<String, Integer> init(String str){
	    HashMap<String, Integer> map = new HashMap<>();
	    
	    str = str.toLowerCase();
	    
	    for(int i = 0; i < str.length()-1; i++){
	        char c1 = str.charAt(i);
	        char c2 = str.charAt(i+1);
	        
	        // 하나라도 문자가 아니라면
	        if(c1 < 97 || c1 > 122 || c2 < 97 || c2 > 122)
	            continue;
	        
	        String keyword = String.valueOf(c1) + c2;
		        
	        if(!map.containsKey(keyword))
	            map.put(keyword, 1);
	        else
	            map.put(keyword, map.get(keyword) + 1);
	    }
	    
	    return map;
	}
	
	private static int getJS(HashMap<String, Integer> map1, HashMap<String, Integer> map2){
	    // 둘 다 공집합
	    if(map1.size() == 0 && map2.size() == 0)
	       return 65536;
	    
	    // 분자, 분모 초기화
	    int x = 0;
	    int y = 0;
	    
	    // 교집합, 합집합 구하기
	    for(String keyword : map1.keySet()){
	        if(map2.containsKey(keyword)){
	            // 교집합
	            x += Math.min(map1.get(keyword), map2.get(keyword));
	            // 합집합
	            y += Math.max(map1.get(keyword), map2.get(keyword));
	        } else 
	            y += map1.get(keyword);
	    }
	
	    for(String keyword : map2.keySet()){
	        if(!map1.containsKey(keyword)){
	            y += map2.get(keyword);
	        }
	    }
	    
	    float js = (float)x/(float)y;
	    
	    return (int)(js*65536);
	}
	
	public static void main(String[] args) {
		String str1 = "FRANCE";
		String str2 = "french";
		System.out.println(solution(str1, str2));
	}
}
