import java.util.*;
// 둘로 나눴을 때, 토핑 종류 수가 같아야 함. 
// 공평하게 자르는 방법 수
// 투 포인터
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        int idx = 0;
        
        // 일단 처음 위치에서 잘랐을 때, 토핑 갯수 카운팅
        left.put(topping[idx], 1);
        while(++idx < topping.length){
            if(right.containsKey(topping[idx])){
                right.put(topping[idx], right.get(topping[idx]) + 1);
            }
            else{
                right.put(topping[idx], 1);
            }
        }
        
        idx = 1;
        while(idx < topping.length){
            // 공평한지 확인
            if(left.size() == right.size()) answer++;
            
            // 왼쪽에 토핑하나 추가 
            if(left.containsKey(topping[idx])){     // 이미 존재하면
                left.put(topping[idx], left.get(topping[idx]) + 1);
            }
            else{           // 존재하지 않으면
                left.put(topping[idx], 1);
            }
            
            // 오른쪽에 토핑 하나 제거
            if(right.get(topping[idx]) == 1){
                right.remove(topping[idx]);
            }
            else{
                right.put(topping[idx], right.get(topping[idx]) - 1);
            }
            
            idx++;
        }
        
        
        return answer;
    }
}