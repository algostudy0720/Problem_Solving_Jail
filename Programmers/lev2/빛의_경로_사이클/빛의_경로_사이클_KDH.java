package Programmers.lev2;

import java.util.*;

public class 빛의_경로_사이클 {

    static int w, h;  
    static boolean[][][] visit;
    static int[][] delats = {{0, -1}, {1, 0}, {0, 1}, {-1,0}};
    
	public static void main(String[] args) {
		String[] grid = {"SL","LR"};
		solution(grid);
	}

    public static int[] solution(String[] grid) {
        ArrayList<Integer> arr = new ArrayList<>();
        w = grid[0].length();
        h = grid.length;
        
        visit = new boolean[h][w][4];
        
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                for(int d = 0; d < 4; d++){
                    if(!visit[i][j][d]){
                        arr.add(getLightLen(grid, visit, i, j, d));
                    }
                }
            }
        }
        int[] answer = new int[arr.size()];
        Collections.sort(arr);
        
        for(int i = 0; i < answer.length; i++) 
        	answer[i] = arr.get(i);
        
        System.out.println(Arrays.toString(answer));
        return answer;
    }
    
    public static int getLightLen(String[] grid, boolean[][][] visit, int y, int x, int d) {
        int cnt = 0;  
        
        while(!visit[y][x][d]){
            cnt++;      
            visit[y][x][d] = true; 
            if(grid[y].charAt(x) == 'R') {
            	d = (d+1) < 0 ? 3 : (d + 1) % 4; 
            }
            else if(grid[y].charAt(x) == 'L') 
            	d = (d - 1) < 0 ? 3 : (d - 1) % 4; 

            x = (x + delats[d][0] + w) % w;    
            y = (y + delats[d][1] + h) % h; 
        }
        
        return cnt;
    }
}
