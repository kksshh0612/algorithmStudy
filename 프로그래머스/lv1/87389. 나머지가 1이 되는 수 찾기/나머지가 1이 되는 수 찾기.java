class Solution {
    public int solution(int n) {
        int answer = 0;
        n -= 1;
        
        for(int i = 2; i <= n; i++){
            if(n % i == 0) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}