package programmers;
import java.util.*;
public class 디스크_컨트롤러_PDW {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs,(a,b)->{
            if(a[0] == b[0]) return a[1]- b[1];
            return a[0] - b[0];
        });
        PriorityQueue<int[]> pq  = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(jobs[0]);
        int time =jobs[0][0];
        int idx = 1;
        while(!pq.isEmpty()){
            int[] data = pq.poll();
            time += data[1];
            answer += time - data[0];
            while(idx<jobs.length && jobs[idx][0] <= time) pq.offer(jobs[idx++]);
            if(pq.isEmpty() && idx<jobs.length){
                time = jobs[idx][0];
                pq.offer(jobs[idx++]);
            }
        }
        return answer/jobs.length;
    }
}
