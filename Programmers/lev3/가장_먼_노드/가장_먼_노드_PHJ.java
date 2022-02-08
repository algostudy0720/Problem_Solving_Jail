import java.util.*;
class Solution {
     //최장경로, 뭐야..왜 n=6인데 7개줘..
    public int solution(int n, int[][] edge) {
        int answer = 0;
     
        boolean[][] connected = new boolean[n+1][n+1];
        int[] track = new int[n+1];//최대 거리가 아니라, 최대 거리가 몇갠지 구해야해서 배열
        
        for(int i = 0 ; i< edge.length; i++){
            connected[edge[i][0]][edge[i][1]] = true;
            connected[edge[i][1]][edge[i][0]] = true;//서로 연결
        }
        
        Queue<Integer> q = new LinkedList<>();//노드
        boolean[] visited = new boolean[n+1];//방문중인 배열
        q.add(1); //1번 노드 방문(1번노드부터 가장 멀리 떨어진 노드구하는중)
        visited[1] = true;
        
        //BFS 시작
        while(!q.isEmpty()){
            int size = q.size();
           
            //connected map 에서 지금 node를 찾아야하는데..
            //이게 문젠가....????
            for(int j = 0; j <size ;j ++){
             int node = q.poll();
                for(int i = 1 ; i<=n; i ++){
                if(connected[i][node] && !visited[i]){//지금 노드랑 연결 + 방문 x
                    q.offer(i);//다음 노드로 정함
                    visited[i] = true;
                  //  track[i] = track[node]+1 ; //현재 거리 +1
                }
            }
            }
            answer = size;
        }
        return answer;
    }

}
