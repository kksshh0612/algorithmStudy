import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] token: clothes){
            if(map.containsKey(token[1])){
                map.put(token[1], map.get(token[1]) + 1);
            }
            else{
                map.put(token[1], 1);
            }
        }
        
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            // System.out.println(key + " " + map.get(key));
            answer *= (map.get(key) + 1);
        }
 
        return answer - 1;
    }
}