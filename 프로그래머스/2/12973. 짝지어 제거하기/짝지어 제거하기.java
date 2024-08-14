import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char token = s.charAt(i);
            
            if(stack.isEmpty() || stack.peek() != token){
                stack.push(token);
            }
            else{
                stack.pop();
            }
        }
        
        if(stack.size() > 0) answer = 0;
        else answer = 1;
        

        return answer;
    }
}