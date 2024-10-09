import java.util.*;
// dp
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int size = sticker.length;
        
        if(size < 4){
            int max = 0;
            for(int i = 0; i < size; i++){
                max = Math.max(sticker[i], max);
            }
            answer = max;
        }
        else{
            for(int i = 0; i < 2; i++){
                int[] dp = new int[size];
            
                dp[i] = sticker[i];     // 시작점
            
                int idx = (i + 1) % size;
                while(idx != i){
                    dp[idx] = Math.max(dp[idx - 2 < 0 ? size + idx - 2 : idx - 2], 
                                   dp[idx - 3 < 0 ? size + idx - 3 : idx - 3]) + sticker[idx];
                    idx = (idx + 1) % size;
                
                    if((idx + 1) % size == i) break;
                }
            
                for(int j = 0; j < size; j++){
                    answer = Math.max(dp[j], answer);
                }
            }
        }
        
        return answer;
    }
}