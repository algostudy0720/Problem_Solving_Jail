package com.ssafy.boj.gold;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 22.01.27 BOJ 인내의 도미노 장인 호석

public class _20165_KOB{
	
	// 동서남북
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] dominos = new int[N][M];
		
		// true 쓰러진 상태, false 서있는 상태
		boolean[][] map = new boolean[N][M];
		
		int score = 0;
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				dominos[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r = 0; r < R; r++) {
			String[] att = br.readLine().split(" ");
			String[] def = br.readLine().split(" ");
			int d = -1;
			
			// 넘어지는 방향
			if(att[2].equals("E"))
				d = 0;
			else if(att[2].equals("W"))
				d = 1;
			else if(att[2].equals("S"))
				d = 2;
			else
				d = 3;
			
			// 공격
			int aX = Integer.parseInt(att[0])-1;
			int aY = Integer.parseInt(att[1])-1;
			
			// 넘어뜨리려는 자리의 도미노가 이미 넘어져있는 경우
			if(map[aX][aY])
				break;
			
			int domino = dominos[aX][aY];
			map[aX][aY] = true;
			score++;
			
			// 넘어지는 길이
			int K = domino - 1;

			while(K-- > 0) {
				aX += dr[d];
				aY += dc[d];
				
				if(aX < 0 || aX >= N || aY < 0 || aY >= M)
					break;
				
				if(map[aX][aY] && K > 0)
					continue;
				
				if(map[aX][aY] && K == 0)
					break;
				
				map[aX][aY] = true;
				
				int nDomino = dominos[aX][aY] - 1;
				
				if(K < nDomino) {
					K = nDomino;
				}
				score++;
			}
			
			// 수비
			int dX = Integer.parseInt(def[0])-1;
			int dY = Integer.parseInt(def[1])-1;
			
			if(map[dX][dY])
				map[dX][dY] = false;
			
		}
		
		sb.append(score).append("\n");
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j])
					sb.append("F ");
				else
					sb.append("S ");
			}
			
			sb.setLength(sb.length()-1);
			sb.append("\n");
		}
		
		
		System.out.println(sb);
	}
}
