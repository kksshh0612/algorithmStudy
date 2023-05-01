class Solution {
    
    public int prime(int num){
        int sum = 0;
        for(int i = 1; i <= num; i++){
            if(num % i == 0) sum += i;
        }
        return sum;
    }
    
    public int solution(int n) {
        int answer = prime(n);
        
        return answer;
    }
}