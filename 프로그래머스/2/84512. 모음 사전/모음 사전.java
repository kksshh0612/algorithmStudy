import java.util.*;

// dfs로 모두 탐색
class Solution {
    
    public static int ans, val;
    public static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    
    public static void dfs(String target, StringBuilder curr, int size){
        if(size > 5){
            return;
            
        }
        else{
            
            // System.out.println(ans + "    " + curr.toString());
            if(curr.toString().equals(target)){
                val = ans;
                return;
            }
            ans++;
            
            for(int i = 0; i < 5; i++){
                curr.append(alpha[i]);
                dfs(target, curr, size + 1);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
    
    public int solution(String word) {
        int answer = 0;
        
        dfs(word, new StringBuilder(), 0);
        
        answer = val;
        
        return answer;
    }
}