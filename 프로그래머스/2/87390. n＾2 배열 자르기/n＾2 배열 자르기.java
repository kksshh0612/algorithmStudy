import java.util.*;

// 수를 나눈 몫은 행, 나머지는 열이다.
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        
        int idx = 0;
        for(long i = left; i <= right; i++){
            answer[idx++] = (int) Math.max(i / n, i % n) + 1;
        }
        
        return answer;
    }
}