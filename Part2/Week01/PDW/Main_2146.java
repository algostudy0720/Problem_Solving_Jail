package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2146 {
	static int N, ans;
	static int[][] map;
	static boolean[][] isVisited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		isVisited = new boolean[N][N];
		ans = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int idx =2;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					divideArrea(i,j,idx);
					idx++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]!=0) {
					for(int d=0; d<4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if(nx < 0 || nx>=N || ny<0 || ny>=N) continue;
						if(map[nx][ny] == 0) {
							isVisited = new boolean[N][N];
							solve(nx,ny,map[i][j]);
						}
 					}
				}
			}
		}
		System.out.println(ans);
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
 	}
	private static void solve(int i, int j, int island ) {
		Queue<int[]> queue = new LinkedList<>();
		isVisited[i][j]=true;
		queue.offer(new int[] {i,j,1});
		int cnt =0;
//		System.out.println();
		while(!queue.isEmpty()) {
			int[] data= queue.poll();
//			System.out.println(data[0] + " : " + data[1]);
			if(data[2] > ans) return;
			for(int d = 0; d<4; d++) {
				int nx = data[0] + dx[d];
				int ny = data[1] + dy[d];
				if(nx<0 || nx>=N || ny<0 || ny >=N) continue;
				if(!isVisited[nx][ny] && map[nx][ny] == 0) {
					isVisited[nx][ny] = true;
					queue.offer(new int[] {nx,ny,data[2]+1});
				}
				
				if(map[nx][ny] != 0 && map[nx][ny] !=island) {
					ans = Math.min(ans, data[2]);
//					System.out.println(data[2]);
					return;
				}
			}
		}
	}
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	private static void divideArrea(int i, int j, int idx) {
		isVisited[i][j]=true;
		map[i][j] = idx;
		for(int d=0; d<4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if(nx < 0 || nx>=N || ny<0 || ny>=N) continue;
			if(!isVisited[nx][ny] && map[nx][ny]==1) {
				divideArrea(nx,ny,idx);
			}
		}
		
	}
}
