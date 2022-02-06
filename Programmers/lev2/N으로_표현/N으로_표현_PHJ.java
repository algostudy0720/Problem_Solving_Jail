package 프로그래머스_02022022;

public class N으로_표현_PHJ {

	public static void main(String[] args) {
		N으로_표현_PHJ s = new N으로_표현_PHJ();
		System.out.println(s.solution(5, 12));
		// number12을 N을 사용하여 만들어야 함
	}

	static int min = Integer.MAX_VALUE, N, number;

	public int solution(int n, int num) {
		// int answer = 0;
		N = n; number = num;//계속 쓸거라 static으로 뺌
		dfs(0,0);// cnt=1, prev num == n
		min = min <= 8 ? min : -1;
		return min;
	}

	/**
	 * N으로 표현 cnt -> 최소 카운트. prev = 이전 연산 결과 => number가 되야함
	 * 
	 */
	public static void dfs(int cnt, int prev) {
		//int num = prev;
		if (cnt > 8) {// 최솟값이 8번 보다 크면 return
			return;
		}
		if (number == prev) {// 연산 결과가 number인지 확인
			min = Math.min(min, cnt); // 현재 최솟값이 더 작으면 업데이트
			return;
		}
		int num = 0;
		for (int i = 0; i < 8 ; i++) {
			num = (num) * 10 + N;// 5->55
			dfs(cnt + 1 + i, prev - num);
			dfs(cnt + 1 + i, prev * num);
			dfs(cnt + 1 + i, prev + num);
			dfs(cnt + 1 + i, prev / num);
		}
	}
}
