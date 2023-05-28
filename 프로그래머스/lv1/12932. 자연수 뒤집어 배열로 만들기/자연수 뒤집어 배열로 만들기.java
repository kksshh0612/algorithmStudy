import java.util.*;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        
        while(n > 0){
            Long token = n % 10;
            arr.add(token.intValue());
            n /= 10;
        }
        
        answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}