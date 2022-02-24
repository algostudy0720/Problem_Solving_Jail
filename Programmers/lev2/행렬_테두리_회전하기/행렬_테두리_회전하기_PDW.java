package programmers;

public class 행렬_테두리_회전하기_PDW {
	class Solution {
	    public int[] solution(int rows, int columns, int[][] queries) {
	        int[] answer = new int[queries.length];
	        int[][] map = new int[rows][columns];
	        
	        int idx = 1;
	        for(int i=0; i<rows; i++){
	            for(int j=0; j<columns; j++){
	                map[i][j] = idx++;
	            }
	        }
	        
	        for(int i=0; i<queries.length; i++){
	            int cnt = (queries[i][2] - queries[i][0] + queries[i][3] - queries[i][1]) * 2;
	            int startR = queries[i][0] -1;
	            int endR = queries[i][2] -1;
	            int startC = queries[i][1] -1;
	            int endC = queries[i][3] -1;
	            int temp = map[startR][startC];
	            int r = startR;
	            int c = startC;
	            int min = temp;
	            for(int j=0; j<endR- startR; j++){
	                map[r][c] = map[++r][c];
	                min = Math.min(min,map[r][c]);
	            }
	            r= endR;
	            c= startC;
	            for(int j=0; j<endC-startC; j++){
	                map[r][c]= map[r][++c];
	                min = Math.min(min,map[r][c]);
	            }
	            r = endR;
	            c = endC;
	            for(int j=0; j<endR-startR; j++){
	                map[r][c] = map[--r][c];
	                min = Math.min(min,map[r][c]);
	            }
	            r= startR;
	            c= endC;   
	            for(int j=0; j<endC-startC-1; j++){
	                map[r][c]= map[r][--c];
	                min = Math.min(min,map[r][c]);
	            }
	            map[startR][startC+1] = temp;
	            answer[i]= min;
	        }
	        
	        return answer;
	    }
	}
}
