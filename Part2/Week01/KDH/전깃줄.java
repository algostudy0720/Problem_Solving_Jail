package Baekjoon.Gold;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
 
public class 전깃줄 {
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N];
		
		int[][] wire = new int[N][2];
        
		for(int i = 0; i < N; i++) {
			wire[i][0] = sc.nextInt();
			wire[i][1] = sc.nextInt();
		}
		
		Arrays.sort(wire, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
 
		for(int i = 0; i < dp.length; i++) {
			
			dp[i] = 1;	
			
			for(int j = 0; j < i; j++) {
				if(wire[i][1] > wire[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(N - max);
	}
}