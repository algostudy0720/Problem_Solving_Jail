package Programmers.lev2;

import java.util.Arrays;
import java.util.HashSet;

public class 튜플 {

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		solution(s);
	}

    public static int[] solution(String s) {
        int[] answer = {};
        
        String[] strs = s.replaceAll("[{}]", " ").trim().split(" ,");
        answer = new int[strs.length];
        
        HashSet<Integer> hs = new HashSet<Integer>();
        Arrays.sort(strs, (a,b)->(a.length()-b.length()));
        int i = 0;
        for(String str : strs){
            for(String st : str.split(",")){
                int a  = Integer.parseInt(st.trim());
                if(hs.contains(a))
                	continue;
                hs.add(a);
                answer[i++] = a;
            }
        }
        
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
