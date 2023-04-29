class Solution {
    
    public static int func(int n){      //약수의 갯수 구하기 
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                cnt++;
            }
        }
        return cnt;
    }
    
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++){        
            if(func(i) % 2 == 0){
                answer += i;
            }
            else{
                answer -= i;
            }
        }
        
        return answer;
    }
}