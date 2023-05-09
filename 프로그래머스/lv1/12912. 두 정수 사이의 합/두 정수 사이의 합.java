class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if(a > b){          //a를 작은 수로 만들기 
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        while(a <= b){
            answer += a;
            a++;
        }
        
        return answer;
    }
}