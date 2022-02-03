package Baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 인내의_도미노_장인_호석 {

	static int N, M, R;
	static int[][] map, temp;
	static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		R = Integer.parseInt(st.nextToken()); // 라운드 수 
		
		map = new int[N][M];
		temp = new int[N][M];
		
		for( int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for( int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for( int i=0; i<N; i++) {
			for( int j=0; j<M; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		
		for( int r=0; r<R; r++) {
			// 공격하기
			st = new StringTokenizer(br.readLine()," ");
			int Ar = Integer.parseInt(st.nextToken())-1;
			int Ac = Integer.parseInt(st.nextToken())-1;
			char direct = st.nextToken().charAt(0);
			
			Attack(Ar,Ac,direct);
			
			// 수비하기
			st = new StringTokenizer(br.readLine()," ");
			int Dr = Integer.parseInt(st.nextToken())-1;
			int Dc = Integer.parseInt(st.nextToken())-1;
			int t = temp[Dr][Dc];
			map[Dr][Dc] = t;
		}
		
		System.out.println(answer);
		for( int[] output : map) {
			for( int out : output) {
				if(out >= 1)
					System.out.print("S ");
				else
					System.out.print("F ");
			}
			System.out.println();
		}
	}
	private static void Attack(int r, int c, char direct) {

		int direction =0;
		switch( direct) {
		case 'E' : 
			direction = 1;
			break;
		case 'W' :
			direction = 3;
			break;
		case 'S' :
			direction = 2;
			break;
		case 'N' :
			direction = 0;
			break;
		default:
			break;
		}
		int height = map[r][c]; 
		int nr = r;
		int nc = c;
		while( height > 0 ) {

			if ( map[nr][nc] > 0 ) {
				height = Math.max(height, map[nr][nc]);
				height --;
				map[nr][nc] =0 ; 
				answer ++;

			}
			else {
				height --;
			}
			nr = nr + deltas[direction][0];
			nc = nc + deltas[direction][1];
			
			if ( !isIn(nr,nc)) break;
		}

	}
	private static boolean isIn(int r , int c ) {
		if ( r >= 0 && r < N && c >= 0 && c < M) 
			return true;
		
		return false;
	}

}
