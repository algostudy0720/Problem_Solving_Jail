import java.util.*;
class Solution
{
    public int solution(String s)
    {
       Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        
        for(int i = 1 ; i<s.length(); i++){
            if(!stack.isEmpty()) {
                if(s.charAt(i)!=stack.peek()){
                    stack.push(s.charAt(i));
                     // System.out.println(stack.toString());
                  }
                else stack.pop();
            }else{stack.push(s.charAt(i));}
        }
      
      //  System.out.println(hasPopped);
        return (stack.size()==0)?1:0;
    }
}
