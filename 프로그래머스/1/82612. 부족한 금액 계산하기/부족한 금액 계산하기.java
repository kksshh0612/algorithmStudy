class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        long sum = 0, idx = 1;
        while(count-- > 0){
            sum += price * idx++;
        }
        
        if(sum > money) answer = sum - money;
        else answer = 0;

        return answer;
    }
}