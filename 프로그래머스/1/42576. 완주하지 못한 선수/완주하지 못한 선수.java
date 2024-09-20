import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        // 참가자 이름으로 hashMap에 저장. 이때, 이미 있으면 갯수 ++
        for(String man : participant){
            if(map.containsKey(man)){
                map.put(man, map.get(man) + 1);
            }
            else{
                map.put(man, 1);
            }
        }
        
        // 완주자 반복문 돌며 map 초기화
        for(String man : completion){
            map.put(man, map.get(man) - 1);
        }
        
        for(String key : map.keySet()){
            if(map.get(key) == 1){
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}