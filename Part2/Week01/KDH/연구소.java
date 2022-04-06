package Baekjoon.Gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연구소 {
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	
	static int N, M, answer;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] deltas = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	static Queue<Node> q = new LinkedList<>();
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				
			}
		}
		
		dfs(0);
		System.out.println(answer);
	}

	public static void dfs(int cnt) {
		if(cnt == 3) {
			bfs();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					dfs(cnt + 1);
					
					arr[i][j] = 0;
				}
			}
		}
	}
	
	public static void bfs() {
		int[][] map = new int[N][M];
//		map = arr;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = arr[i][j];
				if(arr[i][j] == 2)
					q.add(new Node(i,j));
			}
		}
		
		while(!q.isEmpty()) {
			Node nd = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = nd.x + deltas[i][0];
				int ny = nd.y + deltas[i][1];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 0)
					continue;
				
				map[nx][ny] = 2;
				q.add(new Node(nx, ny));
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0)
					cnt++;
			}
		}
		answer = Math.max(answer, cnt);
	}
}
