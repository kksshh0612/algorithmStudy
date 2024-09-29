import java.util.*;
// 자연수
class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        
        // 균일하게 나누고 곱하는게 최대임.
        int minNum = s / n;
        int plusCnt = s % n;
        
        if(minNum == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            answer = new int[n];
            for(int i = 0; i < n - plusCnt; i++){
                answer[i] = minNum;
            }
            for(int i = n - plusCnt; i< n; i++){
                answer[i] = minNum + 1;
            }
        }
        
        return answer;
    }
}