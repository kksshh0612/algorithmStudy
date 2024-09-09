import java.util.*;

// 투 포인터
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = sequence.length;
        
        // start부터 end까지 더해서 k보다 작으면 end + 1 크면 start + 1
        // 같을 때마다 answer 초기화
        int start = 0, end = 0, sum = sequence[0];
        
        while(end < sequence.length){
            if(sum < k){
                end++;
                if(end < sequence.length){
                    sum += sequence[end];
                }
            }
            else if(sum > k){
                sum -= sequence[start];
                start++;
            }
            else{
            
                if(end - start < answer[1] - answer[0]){
                    answer[0] = start;
                    answer[1] = end;
                }
                end++;
                if(end < sequence.length){
                    sum += sequence[end];
                }
            }
        }
        
        return answer;
    }
}