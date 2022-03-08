package programmers;
import java.util.ArrayList;

public class 수식_최대화_PDW {
	    static String[] arr ={};
	    static ArrayList<Long> numbers = new ArrayList<>();
	    static ArrayList<String> ops =new ArrayList<>();
	    public long solution(String expression) {
	        int cnt =0;
	        String s = "";
	        for(int i=0; i< expression.length(); i++){
	            char ch = expression.charAt(i);
	            if(ch == '+' || ch == '-' || ch =='*'){
	                ops.add(ch+"");
	                numbers.add(Long.parseLong(s));
	                s="";
	            }else{
	                s+=ch;
	            }
	        }        
	        numbers.add(Long.parseLong(s));
	        boolean plus =false;
	        boolean minus=false;
	        boolean mul = false;
	        if(expression.contains("+")){
	            plus = true;
	            cnt++;
	        }
	        if(expression.contains("-")){
	            minus = true;
	            cnt++;
	        }
	        if(expression.contains("*")){
	            mul = true;
	            cnt++;
	        }
	        arr = new String[cnt];
	        result = new String[cnt];
	        visited = new boolean[cnt];
	        for(int i=0; i<cnt; i++){
	            if(plus){
	                arr[i] = "+";
	                plus = false;
	                continue;
	            }
	            if(minus){
	                arr[i] = "-";
	                minus = false;
	                continue;
	            }
	            if(mul){
	                arr[i] = "*";
	                mul = false;
	                continue;
	            }
	        }
	        
	        solve(expression,0);
	        return ans;
	    }
	    
	    static String[] result = {};
	    static boolean[] visited = {};
	    long ans = Integer.MIN_VALUE;
	    public void solve(String expression,int cnt){
	        if(cnt == arr.length){
	            ArrayList<String> opTemp = new ArrayList<>();
	            ArrayList<Long> numTemp = new ArrayList<>();
	            opTemp.addAll(ops);
	            numTemp.addAll(numbers);
	            for(int i=0; i<result.length; i++){
	                String op = result[i];
	                for(int j=0; j<opTemp.size(); j++){
	                    if(opTemp.get(j).equals(op)) {
	                        long a = numTemp.get(j);
	                        long b = numTemp.get(j+1);
	                        long temp = 0;
	                        if(op.equals("+")){
	                            temp =a+b;
	                        }else if(op.equals("-")){
	                            temp = a-b;
	                        }else if(op.equals("*")){
	                            temp = a*b;
	                        }
	                        numTemp.remove(j+1);
	                        numTemp.remove(j);
	                        
	                        opTemp.remove(j);
	                        numTemp.add(j,temp);
	                        j--;
	                   
	                      
	                    }
	                }
	            }
	            System.out.println(numTemp.get(0));
	            ans = Math.max(Math.abs(numTemp.get(0)), ans);
	            return;
	        }
	        for(int i=0; i<arr.length; i++){
	            if(visited[i]) continue;
	            result[cnt] = arr[i];
	            visited[i] = true;
	            solve(expression, cnt+1);
	            visited[i] = false;
	        }
	  
	    }
}
