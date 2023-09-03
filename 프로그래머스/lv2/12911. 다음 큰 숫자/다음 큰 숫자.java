import java.util.*;

class Solution {
    
//     public int oneNum(int n){
        
//         int one = 0;
        
//         while(n > 0){
//             if(n % 2 == 1){
//                 one++;
//             }
//             n /= 2;
//         }
        
//         return one;
//     }
    
    
    public int solution(int n) {
        int answer = 0;
        int originOneNum = 0, currOneNum = -1;
        
        originOneNum = Integer.bitCount(n);
        while(originOneNum != currOneNum){
            currOneNum = Integer.bitCount(++n);
        }
        
        answer = n;
        
        return answer;
    }
}