package programmers;
import java.util.*;
public class 메뉴_리뉴얼_PDW {
    static HashMap<String, Integer> map = new HashMap<>();
    static String order;
    static char[] sel;
    static int[] max;
    static int count = 0;

    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> list = new ArrayList<>();
        max = new int[course.length];
        map = new HashMap<>();
        
        for(int i=0; i<orders.length; i++){
             char[] arr= orders[i].toCharArray();
             Arrays.sort(arr);
             order = String.copyValueOf(arr);
             for(int j=0; j<course.length;j++){
                  combination(0,0, j,course[j],"");
             }          
        }
        System.out.println(map);

        for(String key : map.keySet()){
            for(int i=0; i<course.length; i++){
                if(course[i] == key.length() && max[i] > 1 && map.get(key)==max[i])
                    list.add(key);
            }
         }
        
      
   
        Collections.sort(list);
        
        return list;
    }
    
    static void combination(int start, int cnt,int idx,int R,String set){
        if(cnt == R){
           
            int value = 0;
            if(map.containsKey(set)) value = map.get(set);
            map.put(set, value+1);
            max[idx] = Math.max(max[idx], map.get(set));
            return;
        }
        for(int i=start; i<order.length(); i++){
            combination(i+1,cnt+1,idx ,R,set+order.charAt(i));
        }
        
    }
}
