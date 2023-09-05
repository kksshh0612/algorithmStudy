class Solution {
    public int solution(int n) {
        int answer = 0;
        int curr = 1, stock = 0;
        
        for(int i = 1; i <= n; i++){
            for(int j = i; j <= n; j++){
                stock += j;
                if(stock == n) {
                    answer++;
                    break;
                }
                else if(stock > n){
                    break;
                }
            }
            stock = 0;
        }
        
        return answer;
    }
}