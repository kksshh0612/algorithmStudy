import java.util.*;
// 각 인덱스 당 약수 중 가장 큰 수 
class Solution {
    
    public static int search(int num){
        if(num == 1) return 0;
        
        int ans = 1;
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                if(num / i <= 10000000){
                    ans = num / i;
                    break;
                }
                else{
                    ans = i;
                }
            
            }
        }
        return ans;
    }
    
    public int[] solution(long begin, long end) {
        int size = (int)end - (int)begin + 1;
        int[] answer = new int[size];
        
        int idx = 0;
        for(int i = (int)begin; i <= (int)end; i++){
            answer[idx++] = search(i);
        }
        
        return answer;
    }
}
