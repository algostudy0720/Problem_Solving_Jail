package Baekjoon.Silver;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
 
class Node {
    int y;
    int x;
    
    Node(int y, int x){
        this.y = y;
        this.x = x;
     }
}
 
public class 영역_구하기 {
    
    static int[][] map;
    static boolean[][] visited;
    static int M,N,K;
    static int count;
    static int[] sum;
    static int[][] deltas = {{0,-1}, {0,1}, {-1,0}, {1,0}};

    
    public static void main(String[] args) throws Exception {
        

        Scanner sc = new Scanner(System.in);
        
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        
        map = new int[N][M];
        visited = new boolean[N][M];
        sum = new int[N*M];
        count = 0;
        
        for (int i = 0; i < K; i++) {
            
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    map[x][y] = 1;
                }
            }
        }
        
        
        int c = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0 && !visited[i][j]){
                    bfs(i,j, c);
                    count++;
                    c++;
                }
            }
        }
        
        System.out.println(count);
        Arrays.sort(sum, 0, count);
        for (int i = 0; i < count; i++) {
            System.out.print(sum[i] + " ");
        }
    }
    
    static public void bfs(int y, int x, int c) {
        Queue<Node> q = new LinkedList<>();
        
        Node r1 = new Node(y, x);
        
        q.add(r1);
        
        while(!q.isEmpty()){
        	Node r2 = q.poll();
            visited[r2.y][r2.x] = true;
            sum[c] += 1;
            
            for (int i = 0; i < 4; i++) {
                int ny = r2.y + deltas[i][0];
                int nx = r2.x + deltas[i][1];
                
                if(ny >=0 && nx >= 0 && ny < N && nx < M){
                    if(map[ny][nx] == 0 && !visited[ny][nx]){
                    	Node r3 = new Node(ny, nx);
                        q.add(r3);
                        visited[r3.y][r3.x] = true;
                    }
                }
            }
        }
    }
}
 