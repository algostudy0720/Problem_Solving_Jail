#include <string>
#include <vector>

using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = 0;
    long long min = 1;
    long long max = (long long)times.back() * n; //마지막*n명
    long long mid = (min + max)/2;
    long long sum = 0;
    answer = max;
    
    while(min<=max)
    {
        sum =  0;
        mid = (min + max)/2;
        for(auto t : times) sum += mid/t;
        if(sum<n) min = mid+1;
         else{
            if(mid<=answer) answer = mid;
            max = mid-1;
         }
        
    }
    return answer;
}

/* 
시간초과나는 자바 코드 : 
import java.util.*;

class Solution {
	public static class Node implements Comparable<Node>{
		long time; //소요 시간
		int index;
		Node(long time, int index){
			this.time = time;
			this.index = index;
		}
		@Override
		public int compareTo(Node o) {
			return (int)(this.time - o.time);
		}
	}
    public long solution(int n, int[] times) {
		long answer = -1;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < times.length; i++) {// 심사위원 전부 큐에 넣음
			pq.add(new Node((long) times[i], i));
		}
		for (int i = 0; i < n-1; i++) {// n명동안...가장 짧은 시간사람한테
			Node node = pq.poll();
			long addTime = node.time + times[node.index];// 이전 시간 + 현재 시간
			pq.add(new Node(addTime, node.index));
		}
		answer = pq.poll().time;
		return answer;
    }

}
*/
