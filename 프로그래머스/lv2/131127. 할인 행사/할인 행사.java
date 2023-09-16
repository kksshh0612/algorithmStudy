import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        int totalCnt = 0;
        for(int i = 0; i < number.length; i++){
            wantMap.put(want[i], number[i]);
            countMap.put(want[i], 0);
            totalCnt += number[i];
        }
        
        for(int i = 0; i < discount.length - totalCnt + 1; i++){
            
            for(int j = i; j < i + totalCnt; j++){
                if(!countMap.containsKey(discount[j])){     
                    break;
                }
                countMap.put(discount[j], countMap.get(discount[j]) + 1);
            }
        
            // 현재 묶음에서 원하는 물건 수와 discount의 물건 수가 같은지 확인해서 같으면 answer++
            boolean isAnswer = true;
            for(int j = 0; j < want.length; j++){
                if(wantMap.get(want[j]) != countMap.get(want[j])){
                    isAnswer = false;
                    break;
                }
            }
            if(isAnswer) answer++;
            
            // discount 수 세는 map 초기화
            for(int idx = 0; idx < number.length; idx++){
                countMap.put(want[idx], 0);
            }
        }
        
        
        
        return answer;
    }
}