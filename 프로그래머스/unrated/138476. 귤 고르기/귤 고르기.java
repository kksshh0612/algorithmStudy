import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int item : tangerine){
            if(map.containsKey(item)){
                map.put(item, map.get(item) + 1);
            }
            else{
                map.put(item, 1);
            }
        }
        
        List<Integer> valueList = new ArrayList<>(map.values());
        Collections.sort(valueList);
        
        int i = valueList.size() - 1;
        while(k > 0){
            k -= valueList.get(i--);
            answer++;
        }
        
        
        return answer;
    }
}