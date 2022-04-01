package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2565 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] lines = new int[N][2];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			lines[i][0] = sc.nextInt();
			lines[i][1] = sc.nextInt();
		}
		Arrays.sort(lines, (a, b) -> a[0] - b[0]);
		int max = 1;
		for(int i=0; i<N; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(lines[j][1] < lines[i][1]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(N - max);
		sc.close();
	}
}
