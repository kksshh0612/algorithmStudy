import java.util.*;
// 기지국 커버 안되는 것들 자르고 2W + 1로 나누고 나머지 있으면 + 1 한게 그 범위 커버하는방법
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        // 기지국 커버 안된 범위 저장
        List<Integer> rangeList = new ArrayList<>();
        
        int currStart = 1;
        for(int pos : stations){
            int range = (pos - w) - currStart;
            currStart = pos + w + 1;
            
            if(range > 0){
                rangeList.add(range);
            }
        }
        
        if(currStart <= n){
            rangeList.add(n - currStart + 1);
        }
        
        for(Integer num : rangeList){
            int ans = num / (2 * w + 1);
            if(num % (2 * w + 1) != 0){
                ans++;
            }
            answer+= ans;
            
        }
        // System.out.println(answer);

        return answer;
    }
}