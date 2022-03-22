package programmers;
import java.util.*;

public class 프린터_PDW {

	public int solution(int[] priorities, int location) {
		int answer = 0;
		LinkedList<int[]> queue = new LinkedList<>();
		for (int i = 0; i < priorities.length; i++)
			queue.offer(new int[] { i, priorities[i] });
		outer: while (!queue.isEmpty()) {
			int[] data = queue.poll();
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				if (data[1] < queue.get(i)[1]) {
					queue.offer(data);
					continue outer;
				}
			}
			answer++;
			if (data[0] == location)
				break;
		}
		return answer;
	}
}
