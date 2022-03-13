package programmers;

public class N으로_표현_PDW {
    int n;
    int selectN;
    int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        n = N;
        selectN = number;
        dfs(0, 0);        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(int cnt, int prev) {
        if (cnt > 8) {
            answer = -1;
            return;
        }

        if (prev == selectN) {
            answer = Math.min(answer, cnt);
            return;
        }

        int tempN = n;
        for (int i = 0; i < 8 - cnt; i++) {
            int newCount = cnt + i + 1;
            dfs(newCount, prev + tempN);
            dfs(newCount, prev - tempN);
            dfs(newCount, prev / tempN);
            dfs(newCount, prev * tempN);

            tempN = tempN * 10 + n;
        }
    }
}
