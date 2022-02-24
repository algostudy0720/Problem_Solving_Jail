package com.ssafy.pro.lv2;

import java.util.Arrays;

// 22.02.24 Programmers 2021 Deb-Matching

public class 행렬_테두리_회전하기_KOB{
	public static int[] solution(int rows, int columns, int[][] queries) {
        int len = queries.length;
        int[] answer = new int[len];
        int[][] map = new int[rows][columns];
        int num = 1;
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++){
                map[r][c] = num++;
            }
        }
        
        
        for(int q = 0; q < len; q++){
            int x1 = queries[q][0] - 1;
            int y1 = queries[q][1] - 1;
            int x2 = queries[q][2] - 1;
            int y2 = queries[q][3] - 1;
            
            // 초기값 세팅
            int min = map[x1][y1];
            int value = map[x1][y1];
            
            // 회전 시작(시계 방향)
            // 왼쪽 변
            int val = x1;
            while(x2 > val){
                map[val][y1] = map[val+1][y1];
                min = Math.min(min, map[val][y1]);
                val++;
            }
            
            // 아래 변
            val = y1;
            while(y2 > val){
                map[x2][val] = map[x2][val+1];
                min = Math.min(min, map[x2][val]);
                val++;
            }
            
            // 오른 변
            val = x2;
            while(x1 < val){
                map[val][y2] = map[val-1][y2];
                min = Math.min(min, map[val][y2]);
                val--;
            }
            
            val = y2;
            while(y1+1 < val){
                map[x1][val] = map[x1][val-1];
                min = Math.min(min, map[x1][val]);
                val--;
            }
            map[x1][y1+1] = value;
            
            answer[q] = min;
        }
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
		
		System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}
}
