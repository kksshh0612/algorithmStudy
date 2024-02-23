import java.util.*;
// 한 번호가 다른 번호의 접두어인 경우가 있으면 false 
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Map<String, Integer> map = new HashMap<>();
        for(String str : phone_book){
            map.put(str, str.length());     //문자열, 길이 
        }
        
        // str의 접두사랑 
        for(String str : phone_book){
            for(int i = 0; i < str.length(); i++){
                if(map.containsKey(str.substring(0, i))) {
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}