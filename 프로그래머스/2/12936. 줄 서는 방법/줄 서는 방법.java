import java.util.*;

class Solution {
    
    public static long factorial(int n){
        if(n > 1){
            return n * factorial(n - 1);
        }
        else{
            return 1;
        }
    }
    
    public long[] solution(int n, long k) {
        long[] answer = new long[n];
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(i + 1);
        }
        
        int idx = 0, size = n;
        k--;
        while(idx < size){
            long fact = factorial(n - 1);
            answer[idx++] = list.get((int)(k / fact));
            list.remove((int)(k / fact));
           
            k %= fact;
            n--;
        }
        
        return answer;
    }
}