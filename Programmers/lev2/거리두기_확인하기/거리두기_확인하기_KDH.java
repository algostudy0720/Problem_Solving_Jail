package Programmers.lev2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기_확인하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		solution(places);
	}

	public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] p = places[i];

            boolean isOk = true;
            for (int r = 0; r < 5 && isOk; r++) {
                for (int c = 0; c < 5 && isOk; c++) {
                    if (p[r].charAt(c) == 'P') {
                        if (!bfs(r, c, p))
                            isOk = false;
                    }
                }
            }
            answer[i] = isOk ? 1 : 0;
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    private static boolean bfs(int r, int c, String[] p) {
        int deltas[][] = { {-1,0}, {1,0}, {0,-1}, {0,1}};

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[] { r, c });

        while (!queue.isEmpty()) {
            int[] position = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = position[0] + deltas[i][0];
                int nc = position[1] + deltas[i][1];

                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == r && nc == c))
                    continue;

                int d = Math.abs(nr - r) + Math.abs(nc - c);

                if (p[nr].charAt(nc) == 'P' && d <= 2)
                    return false;
                else if (p[nr].charAt(nc) == 'O' && d < 2)
                    queue.offer(new int[] { nr, nc });
            }
        }
        return true;
    }
}
