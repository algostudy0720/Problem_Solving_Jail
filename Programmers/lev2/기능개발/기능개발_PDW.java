package programmers.스택큐;

import java.util.*;

class Solution {
    static LinkedList<int[]> queue;
    public int[] solution(int[] progresses, int[] speeds) {
        queue = new LinkedList<>();
        for(int i =0; i<progresses.length; i++){
            queue.offer(new int[]{progresses[i],speeds[i]});
        }
        int[] temp = new int[100];
        int ans=0;
        int size =0;
        while(!queue.isEmpty()){
            
            if(queue.peek()[0]<100){
                if(ans !=0){
                    temp[size++]=ans;
                }
                ans=0;
               int cnt = queue.size();
                for(int i=0; i<cnt; i++){
                    int[] tempQueue = queue.poll();
                    tempQueue[0]+=tempQueue[1];
                    queue.add(tempQueue);
                }   
            }else{
                queue.poll();
                ans++;
            }    
            
        }
        int[] answer = new int[size+1];
        for(int i=0; i<size; i++){
            answer[i] = temp[i];
        }
        answer[size] = ans;
              
        return answer;
    }
}