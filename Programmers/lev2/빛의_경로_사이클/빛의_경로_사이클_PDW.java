package programmers;
import java.util.*;

public class 빛의_경로_사이클_PDW {
	    static char[][] map={};
	    static boolean[][][] visited = {};
	    static int[] dx = {-1,0,1,0}; 
	    static int[] dy = {0,-1,0,1};
	    static int R,C;
	    static ArrayList<Integer> answer = new ArrayList<>();
	    
	    public ArrayList<Integer> solution(String[] grid) {
	        map = new char[grid.length][grid[0].length()];
	        for(int i=0; i< grid.length; i++){
	            for(int j=0; j< grid[0].length(); j++){
	                map[i][j] = grid[i].charAt(j);
	            }
	        }
	        R = grid.length;
	        C = grid[0].length();
	        visited = new boolean[grid.length][grid[0].length()][4];
	        for(int i=0; i< R; i++){
	            for(int j=0; j< C; j++){
	                for(int d = 0; d<4; d++) {
	                    if(!visited[i][j][d]) solve(i,j,d);
	                }
	            }
	        }            
	        Collections.sort(answer);
	        return answer;
	    }
	    public void solve(int i, int j, int d){
	       int cnt = 0;
	        while(!visited[i][j][d]){
	            cnt++;
	            visited[i][j][d] = true;
	            
	            if(map[i][j] == 'L') d = d== 0? 3 : d-1;
	            else if(map[i][j] == 'R') d = d==3? 0 : d+1;
	            
	            i = (i+dx[d]+R) % R;
	            j = (j+dy[d]+C) % C;
	        }
	        answer.add(cnt);
	    }
}
