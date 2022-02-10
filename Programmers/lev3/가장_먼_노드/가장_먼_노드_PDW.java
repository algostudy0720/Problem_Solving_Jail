package programmers;
import java.util.*;
public class 가장_먼_노드_PDW {
	public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[][] vertex = new boolean[n+1][n+1];
        boolean[] isVisited = new boolean[n+1]; 
        for(int i =0; i<edge.length; i++){
            vertex[edge[i][0]][edge[i][1]] = true;
            vertex[edge[i][1]][edge[i][0]] = true;
        }
        isVisited[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int start = queue.poll();
                for(int j=1; j<=n; j++){
                    if(vertex[start][j] && !isVisited[j]){
                        isVisited[j]=true;
                        queue.add(j);
                    }
                }
            }
            answer = size;
        }
        
        return answer;
    }
}
