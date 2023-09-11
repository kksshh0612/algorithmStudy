// List 사용해서 있으면(contains) hit 빼서 맨 뒤로 옮김. 
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList list = new LinkedList<>();
        
        if(cacheSize > 0){
            for(String city : cities){
                
                if(!list.contains(city.toLowerCase())){       //miss
                    
                    if(list.size() < cacheSize){        //아직 캐시가 차지 않았으면 add
                        list.add(city.toLowerCase());
                    }
                    else{
                        list.pollFirst();                    
                        list.add(city.toLowerCase());
                    }
                    answer += 5;
                }
                else{                       //hit
                    answer++;
                    list.remove(city.toLowerCase());
                    list.add(city.toLowerCase());
                }
            }
        }
        else{
            answer = 5 * cities.length;
        }

        
        return answer;
    }
}