package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2583 {
	static ArrayList<Integer> list;
	static boolean[][] map;
	static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		int K = sc.nextInt();
		map = new boolean[M + 1][N];
		list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for (int j = y1; j < y2; j++) {
				for (int k = x1; k < x2; k++) {
					map[j][k] = true;
				}
			}
		}
		
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		for (int j = 0; j < M; j++) {
			for (int k = 0; k < N; k++) {
				if (!map[j][k]) {
					int cnt = 0;
					Queue<int[]> queue = new LinkedList<>();
					map[j][k] = true;
					queue.add(new int[] { j, k });
					while (!queue.isEmpty()) {
						int[] data = queue.poll();
						for (int d = 0; d < 4; d++) {
							int nx = data[0] + dx[d];
							int ny = data[1] + dy[d];
							if (nx < 0 || nx >= M || ny < 0 || ny >= N)
								continue;
							if (!map[nx][ny]) {
								map[nx][ny] = true;
								queue.offer(new int[] { nx, ny });
							}
						}
						cnt++;
					}
//					System.out.println(cnt);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int v : list) {
			System.out.print(v + " ");
		}
	}

}
