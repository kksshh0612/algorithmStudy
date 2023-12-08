class Solution {
    public int solution(int n) {
        int answer = 0;
        int divNum = 1_000_000_007;
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        
        if(n >= 2) dp[2] = 2;
        
        for(int i = 3; i <= n; i++){
            dp[i] = ((dp[i - 1] % divNum) + (dp[i - 2] % divNum)) % divNum ;
        }
        
        answer = dp[n];
        
        return answer;
    }
}