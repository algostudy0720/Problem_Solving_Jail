package programmers;
import java.util.*;
public class 괄호_변환_PDW {
    public String solution(String p) {
        String answer = "";
        Stack <Character> stack = new Stack<>();
        boolean check = true;
        if(p.charAt(0) == ')'){
            check = false;
        }else{
            stack.push(p.charAt(0));
            for(int i=1; i<p.length(); i++){
                if(p.charAt(i) == '('){
                    stack.push(p.charAt(i));
                }else{
                    if(!stack.isEmpty()){
                        stack.pop();    
                    }else{
                        check = false;
                        break;
                    }
                }
            }
        }
        if(check) {
            return p;
        }
        answer = solve(p);
 
        return answer;
    }
    public String solve(String p){
        if(p.length()== 0){
            return "";
        }
        int r = 0;
        int l = 0;
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '(') l++;
            if(p.charAt(i) == ')') r++;
            if(r==l) {
                u.append(p.substring(0, i +1));
                v.append(p.substring(i+1, p.length()));
                break;
            }
        }
        boolean check = true;
        Stack<Character> stack = new Stack<>();
        if(u.charAt(0) == ')'){
            check= false;
        }else{
            stack.push(u.charAt(0));
            for(int i=1; i<u.length(); i++){
                if(p.charAt(i) == '('){
                    stack.push(p.charAt(i));
                }else{
                    if(!stack.isEmpty()){
                        stack.pop();    
                    }else{
                        check = false;
                        break;
                    }
                }
            }
        }
        
        if(check){
            u.append(solve(v.toString()));
        }else{
            StringBuilder s = new StringBuilder("(");
            s.append(solve(v.toString()));
            s.append(")");
         
            StringBuilder s2 = new StringBuilder();
            for(int i=1; i<u.length()-1; i++){
                if(u.charAt(i)== '(') s2.append(")");
                else s2.append("(");
            }
            s.append(s2.toString());
            return s.toString();
        }
      
        return u.toString();
    }
}
