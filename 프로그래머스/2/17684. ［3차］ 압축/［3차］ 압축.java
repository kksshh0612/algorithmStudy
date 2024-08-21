import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        
        Map<String, Integer> map = new HashMap<>();     // 문자열, 색인
        for(int i = 0; i < 26; i++){
            char alphabet = (char)('A' + i);
            map.put(Character.toString(alphabet), i + 1);       // 초기 세팅
        }
        
        for(String key : map.keySet()){
            System.out.println(key + " " + map.get(key));
        }
        
        
        List<Integer> ansList = new ArrayList<>();
        
        int start = 0, maxIndex = 26;
        while(start < msg.length()){
            int end = start + 1;
            
            while(end <= msg.length() && map.containsKey(msg.substring(start, end))){
                end++;
            }
            
            String key = msg.substring(start, end - 1);       // 현재 존재하는 사전에 가장 긴 문자열
            int index = map.get(key);
            
            ansList.add(index);
            
            // 추가할 것 없고, 마지막이면 끝 
            if(end == msg.length() + 1 && map.containsKey(msg.substring(start, end - 1))){
                break;
            }
            
            if(end <= msg.length()){
                map.put(msg.substring(start, end), ++maxIndex);
                start = end - 1;
            }
        }
        
        answer = new int[ansList.size()];
        for(int i = 0; i < ansList.size(); i++){
            answer[i] = ansList.get(i);
        }
        

        
        
        return answer;
    }
}