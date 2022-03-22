package Programmers.lev2;

import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
    static class Printer{
        int location;
        int priority;
        public Printer(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }
    
	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		solution(priorities, location);
	}

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Printer> queue = new LinkedList<>();

        for(int i=0; i<priorities.length; i++){
            queue.add(new Printer(i, priorities[i]));
        }

        while(!queue.isEmpty()){
        	Printer pt = queue.poll();
            boolean flag = false;
            
            for(Printer t : queue){
                if(t.priority > pt.priority){
                    flag = true;
                }
            }
            
            if(flag) { 
                queue.add(pt);
            }
            else{
            	answer++;
                if(pt.location == location) {
                    break;
                }
            }
        }
        
        System.out.println(answer);
        return answer;
    }
}
