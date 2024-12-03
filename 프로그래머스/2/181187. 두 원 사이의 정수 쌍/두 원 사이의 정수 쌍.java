import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int i = 1; i <= r2; i++){
            long big = (long)Math.floor(Math.sqrt(1.0*r2*r2 - 1.0*i*i));
            long small = (long)Math.ceil(Math.sqrt(1.0*r1*r1 - 1.0*i*i));
                        
            answer += (big - small) + 1;
        }
        
        answer *= 4;
        
        // 나중에 4개 더해주기
        
        return answer;
    }
}