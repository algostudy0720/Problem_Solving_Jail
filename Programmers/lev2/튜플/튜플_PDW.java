package programmers;
import java.util.*;

public class 튜플_PDW {
	class Solution {
	    public ArrayList<Integer> solution(String s) {
	        int[] answer = {};
	        String str = s.substring(1,s.length()-1);
	        String[] sArr = str.split("},");
	        for(int i=0; i<sArr.length; i++){
	            sArr[i] = sArr[i].substring(1,sArr[i].length());
	            if(i==sArr.length-1){
	                sArr[i] = sArr[i].substring(0,sArr[i].length()-1);
	            }
	        }
	        ArrayList<String[]> list = new ArrayList<>();
	        for(int i=0; i<sArr.length; i++){
	            String[] data = sArr[i].split(",");
	            list.add(data);
	        }
	    
	        int idx =1;
	        ArrayList<Integer> answerList = new ArrayList<>();
	        while(true){
	outer :  for(int i=0; i<list.size(); i++){
	                String[] arr = list.get(i);
	                if(list.get(i).length == idx){
	                    if(idx == 1) {
	                        answerList.add(Integer.parseInt(arr[0]));
	                        list.remove(i);
	                        continue outer;
	                    }
	                    else{
	                        if(idx == arr.length){
	                            for(int j=0; j<arr.length; j++){
	                                for(int k=0; k<answerList.size(); k++){
	                                    if(answerList.contains(Integer.parseInt(arr[j]))) continue;
	                                    answerList.add(Integer.parseInt(arr[j]));
	                                    continue outer;
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	            if(idx == sArr.length) break;
	            idx++;
	        }
	        return answerList;
	    }
	}
}
