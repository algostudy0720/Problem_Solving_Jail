package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_14502 {
	static int[][] map;
	static int N,M;
	static int count,ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 0) count++;
			}
		}
		
		ans = Integer.MIN_VALUE;
		dfs(0);
		
		System.out.println(ans);
		sc.close();
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	private static void dfs(int cnt) {
		if(cnt == 3) {
			int temp = count-3;
			boolean[][] visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 2) {
						Queue<int[]> q = new LinkedList<>();
						q.offer(new int[] {i,j});
						visited[i][j] = true;
						while(!q.isEmpty()) {
							int[] data = q.poll();
							for(int d =0; d<4; d++) {
								int nx = data[0] + dx[d];
								int ny = data[1] + dy[d];
								if(nx<0 || nx>=N || ny<0 || ny >=M ) continue;
								if(map[nx][ny]==1 ) continue;
								if(!visited[nx][ny] && map[nx][ny]==0) {
									visited[nx][ny]= true;
									q.offer(new int[] {nx,ny});
									temp--;
								}
							}
						}
					}
				}
			}
			ans = Math.max(temp, ans);
			return;
		}
		for(int i =0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] =1;
					dfs(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
}
