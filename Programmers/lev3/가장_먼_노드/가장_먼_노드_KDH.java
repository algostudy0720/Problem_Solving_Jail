package Programmers.lev3;

import java.util.LinkedList;
import java.util.Queue;

public class 가장_먼_노드 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		solution(n, edge);
	}

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        int arr[] = new int[n+1];
        boolean visited[][] = new boolean[n+1][n+1];
        
        for (int i = 0; i < edge.length; i++) {
        	int x = edge[i][0];
        	int y = edge[i][1];
			visited[x][y] = true;
			visited[y][x] = true;
		}
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int max = 0;
        
        while(!queue.isEmpty()) {
        	int idx = queue.poll();
        	for (int j = 2; j <= n; j++) {
				if(arr[j] == 0 && visited[idx][j]) {
					arr[j] = arr[idx] + 1;
					queue.add(j);
				}
			}
        }
        for (int i = 0; i < n+1; i++) 
			max = Math.max(max, arr[i]);
		
        for (int i = 0; i < n+1; i++) {
			if(max == arr[i])
				answer++;
		}
        
        System.out.println(answer);
        
        return answer;
    }
    
}
