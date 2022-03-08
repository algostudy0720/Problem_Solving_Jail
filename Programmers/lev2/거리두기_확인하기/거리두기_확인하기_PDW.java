package programmers;
import java.util.*;
public class 거리두기_확인하기_PDW {
	class Solution {
	    public int[] solution(String[][] places) {
	        int[] answer = new int[5];
	        int[][] dx = {{0,1},{1,0},{0,2},{2,0},{1,1},{1,-1}};
	        for(int i=0; i<5; i++){
	            answer[i] = 1;
	        }
	outer :  for(int t =0; t<5; t++){
	            char[][] map = new char[5][5];
	            for(int i=0; i<5; i++){
	                for(int j=0; j<5; j++){
	                    map[i][j] = places[t][i].charAt(j);
	                }
	            }
	            
	            for(int i=0; i<5; i++){
	                for(int j=0; j<5; j++){
	                    if(map[i][j] == 'P'){
	                        for(int d=0; d<=5; d++){
	                            int nx = i+dx[d][0];
	                            int ny = j+dx[d][1];
	                            if(nx>=5 || nx<0 || ny>=5 || ny<0) continue;
	                            if(map[nx][ny]=='P' && d<2){
	                                answer[t] = 0;
	                                continue outer;
	                            }
	                            if(map[nx][ny] == 'P' && d>=2){
	                                if(d==2 && map[nx][ny-1] == 'O'){
	                                    answer[t] = 0;
	                                    continue outer;
	                                }
	                                if(d==3 && map[nx-1][ny] == 'O'){
	                                    answer[t] = 0; 
	                                    continue outer;
	                                }
	                                if(d==4 && (map[nx-1][ny]== 'O' || map[nx][ny-1]=='O')){
	                                    answer[t]=0;
	                                    continue outer;
	                                }
	                                if(d==5 && (map[nx-1][ny]== 'O' || map[nx][ny+1]=='O')){
	                                    answer[t]=0;
	                                    continue outer;
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	            
	            
	        }
	        
	        
	        return answer;
	    }
	}
}
