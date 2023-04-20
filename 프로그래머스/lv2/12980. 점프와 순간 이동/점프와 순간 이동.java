import java.util.*;
// System.out.println();

public class Solution {             //최종 수에서 2씩 나누다가 홀수가 나오면 하나씩 빼줌
    public int solution(int n) {
        int ans = 0;
        while(n > 0){
            if(n % 2 == 0){
                n /= 2;
            }
            else{
                n--;
                ans++;
            }
        }
        
        
        
        
        return ans;
    }
}