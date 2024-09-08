import java.util.*;


class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[y + 1];
        for(int i = 0; i < x; i++){
            dp[i] = -1;
        }
        for(int i = x + 1; i <= y; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[x] = 0;
        
        for(int i = x + 1; i <= y; i++){
            if(i - n >= 0 && dp[i - n] != -1 && dp[i - n] < dp[i]){
                dp[i] = dp[i - n] + 1;
            }
            if(i % 2 == 0 && dp[i / 2] != -1 && dp[i / 2] < dp[i]){
                dp[i] = dp[i / 2] + 1;
            }
            if(i % 3 == 0 && dp[i / 3] != -1 && dp[i / 3] < dp[i]){
                dp[i] = dp[i / 3] + 1;
            }
            
            if(dp[i] == Integer.MAX_VALUE){
                dp[i] = -1;
            }
        }
        
        answer = dp[y];
        
        return answer;
    }
}