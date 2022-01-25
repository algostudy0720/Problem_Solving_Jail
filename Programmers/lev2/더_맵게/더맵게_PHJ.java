package 프로그래머스_01252022;
/**
 * 힙 문제 -> 자바 힙 == PQ 활용
 * 01/25/2022
 * 프로그래머스 레벨 2
 * @author June Park
 *
 */
import java.util.*;
public class 더맵게_PHJ {

	public static void main(String[] args) {
		더맵게_PHJ s = new 더맵게_PHJ();
		System.out.println(s.solution(new int[] {1,2,3,9,10,12}, 7));
	}
	/**
	 * 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수  + 두번째로 맵지 않은 음식의 스코빌 지수
	 * 모든 음식의 스코빌 지수가 k 이상이 될때까지 섞음
	 * news = 1 + 2*2 = 5
	 * @param scoville
	 * @param K
	 * @return
	 */
    public int solution(int[] scoville, int K) {
    	PriorityQueue<Integer> scovilleHeap = new PriorityQueue<Integer>();
    	for(int i = 0 ; i<scoville.length ; i++) scovilleHeap.add(scoville[i]);
    	int answer = 0;
    	while(true) {
    		if(scovilleHeap.isEmpty()) return -1;	//if impossible = return -1
            if(scovilleHeap.peek()>=K) break; 
            if(scovilleHeap.size()<2)  return -1;//스코브빌의 길이는 2 이상(문제 제시)  
            
    		int notSpicy = scovilleHeap.poll();
    		int notSpicy2 = scovilleHeap.poll();
    		int newScoville = notSpicy + notSpicy2*2;
            // if(notSpicy>=K)break; -> 실패 ->테케16?->맨 위로 옮김....
            answer++;
    		scovilleHeap.add(newScoville);//새 스코빌 지수 = 제일 안매움 + 두번째로 안매웅 -> pq poll두번하면 됨
    	}
        return answer;
    }
}
