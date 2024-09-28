import java.util.*;
// col번째 컬럼 기준 오름차순, 첫번째 컬럼 기준 내림차순
// i번째 행의 모든 열을 i로 나눈 나머지 들의 합을 정의 -> s
// row_begin <= s <= row_end 인 모든 s값을 누적해서 XOR한 값 반환
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        row_begin--;
        row_end--;
        
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col - 1] == o2[col - 1]) return o2[0] - o1[0];
            else return o1[col - 1] - o2[col - 1];
        });
        
        for(int i = row_begin; i <= row_end; i++){
            int modNum = i + 1;
            
            int modSum = Arrays.stream(data[i])
                .map(k -> k % (modNum))
                .sum();
            
            answer = answer ^ modSum;
        }
        
        
        
        return answer;
    }
}