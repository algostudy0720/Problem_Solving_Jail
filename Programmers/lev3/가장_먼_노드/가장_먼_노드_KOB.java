package com.ssafy.pro.lv3;

import java.util.*;

// 22.02.08 Programmers 그래프

public class 가장_먼_노드_KOB{
	public static void main(String[] args) {
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
	
		System.out.println(solution(n, edge));
	}
	
	static class Node{
		int vertex;
		int depth;
		
		public Node(int vertex, int depth) {
			this.vertex = vertex;
			this.depth = depth;
		}
	}
	
	static List<List<Integer>> adjList;
    static int len;
    static int[] edges;
    static int max;
	    
	 public static int solution(int n, int[][] edge) {
	        int answer = 0;
	        adjList = new ArrayList<List<Integer>>();
	        len = n;
	        max = 0;
	        edges = new int[n+1];
	        
	        for(int i = 0; i <= n; i++){
	            adjList.add(new ArrayList<Integer>());
	        }
	        
	        for(int i = 0; i < edge.length; i++){
	            int from = edge[i][0];
	            int to = edge[i][1];
	            
	            adjList.get(from).add(to);
	            adjList.get(to).add(from);
	        }
	        
	        // 일단 다 집어 넣고 bfs 순회
	        bfs(1);
	        
	        for(int i = 0; i < edges.length; i++) {
	        	if(edges[i] == max) {
	        		answer++;
	        	}
	        }
	        
	        return answer;
	    }
	    
	    private static void bfs(int start){
	        boolean[] visited = new boolean[len+1];
	        Queue<Node> queue = new LinkedList<Node>(); 
	        queue.offer(new Node(start, 0));
	        visited[start] = true;
	        
	        // 다 탐색
	        while(!queue.isEmpty()){
	            Node current = queue.poll();
	            
	            // 연결된 애들 다 넣고 간선 1
	            List<Integer> temp = adjList.get(current.vertex);
	            for(int i = 0; i < temp.size(); i++){
	                int vertex = temp.get(i);
	                if(!visited[vertex]){
	                    queue.offer(new Node(vertex, current.depth+1));
	                    edges[vertex] = current.depth+1;
	                    max = Math.max(max, current.depth+1);
	                    visited[vertex] = true;
	                }
	            }
	            
	        }
	        
	    }
}
