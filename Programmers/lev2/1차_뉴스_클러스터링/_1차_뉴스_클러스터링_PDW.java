package programmers;
import java.util.*;
public class _1차_뉴스_클러스터링_PDW {
	 public int solution(String str1, String str2) {
	        int answer = 0;
	        str1= str1.toUpperCase();
	        str2= str2.toUpperCase();
	        ArrayList<String> list1 = new ArrayList<>();
	        ArrayList<String> list2 = new ArrayList<>();
	        int idx = 0;
	        while(idx < str1.length() - 1){
	            String s1 = str1.substring(idx, idx+2);
	            if('A'<= s1.charAt(0) && s1.charAt(0) <='Z' && 'A'<= s1.charAt(1) && s1.charAt(1) <='Z')
	                list1.add(s1);
	            idx++;
	        }
	        idx = 0;
	        while(idx < str2.length() - 1){
	            String s2 = str2.substring(idx, idx+2);
	            if('A'<= s2.charAt(0) && s2.charAt(0) <='Z' && 'A'<= s2.charAt(1) && s2.charAt(1) <='Z')
	                list2.add(s2);
	            idx++;
	        }
	        int inter =0;
	outer: for(int i=0; i< list1.size(); i++){
	            for(int j=0; j<list2.size(); j++){
	                // System.out.println(list1.get(i) + " " +list2.get(j));
	                if(list1.get(i).equals(list2.get(j))) {
	                    inter++;
	                    list2.remove(j);
	                    continue outer;
	                }
	            }
	        }
	        // System.out.println(inter);
	        int uni = list1.size() + list2.size();
	        double temp = 1;
	        if(uni!=0){
	             temp =(double) ((double)inter/(double)uni);
	        }
	            
	        temp = temp * 65536;
	        answer = (int) temp;
	        return answer;
	    }
	   
}
