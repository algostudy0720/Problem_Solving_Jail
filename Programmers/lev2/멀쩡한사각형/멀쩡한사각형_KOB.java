package com.ssafy.pro.lv2;

// 22.01.23 Programmers Summer/Winter Coding(2019)

public class 멀쩡한사각형_KOB {
    public static long solution(int w, int h) {
        // 부동소수점에 따라 달라지므로 long 타입으로 선 형변환 후 계산
    	long total = (long)w * (long)h;
        
    	// 작은 사각형으로 변환해서 구하기 위해 최대 공약수를 구함
        long gcd = gcd(w, h);
        
        /*
         * 	# 작은 사각형에서 대각선에 겹치는 영역을 구한다고 계산
         * 		1. h만큼 아래로 이동
         * 		2. w만큼 가로로 이동
         * 		3. 1과 2에서 겹치는 1개의 코너쪽 사각형을 빼줌
         * 		4. 작은 사각형에서 제거해야할 사각형 갯수 구함
         * 		(ex) 2x3
         * 			* x
         * 			* x
         * 			(*,#) #(도착)
         * 		5. 다시 큰 사각형 버전으로 계산하기 위해 다시 gcd 곱해줌
         */
        long empty = (long)w + (long)h - gcd;
        
        return total-empty;
    }
    
    public static long gcd(int a, int b){
        if(a%b == 0)
            return b;
        else
            return gcd(b, a%b);
    }
    
    public static void main(String[] args) {
		int w = 8;
		int h = 12;
		System.out.println(solution(w, h));
	}
}
