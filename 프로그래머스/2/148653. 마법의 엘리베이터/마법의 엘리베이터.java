class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int num = storey % 10;
            storey /= 10;
            
            if(num < 5){
                answer += num;
            }
            else if(num > 5){
                answer += (10 - num);
                storey++;
            }
            else{       // 5와 같으면 더할지 뺄지 결정해야함.
                if(storey % 10 >= 5){
                    answer += 5;
                    storey++;
                }
                else{
                    answer += 5;
                }
            }
     
        }
        
        return answer;
    }
}