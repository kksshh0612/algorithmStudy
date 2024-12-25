class Solution {
    public int solution(int num) {
        int answer = 0;
        long curr = num;
        while(true){
            if(curr == 1) break;
            
            if(answer > 500){
                answer = -1;
                break;
            }
            
            if(curr % 2 == 0){
                curr /= 2;
            }
            else{
                curr = curr * 3 + 1;
            }
            answer++;
        }
        
        return answer;
    }
}