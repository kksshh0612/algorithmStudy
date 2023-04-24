import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>(); 
        char token = 0;
        
        for(int i = 0; i < s.length(); i++){
            token = s.charAt(i);
            if(token == '('){       //왼쪽괄호이면 push
                stack.push('(');
            }
            else{
                if(stack.empty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
      
        if(!stack.empty()) answer = false;

        return answer;
    }
}