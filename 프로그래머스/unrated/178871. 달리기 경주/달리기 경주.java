import java.util.*;

class Solution {  
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map = new HashMap<>();     //이름, 등수 
        
        int rank = 0, currRank = 0;
        for(String curr : players){
            map.put(curr, rank++);
        }
        
        for(String curr : callings){
            currRank = map.get(curr);       //현재 호출된 선수의 순위 
            String prevPlayer = players[currRank - 1];      //현재 호출된 선수보다 1순위 높은 선수 
            players[currRank] = prevPlayer;
            players[currRank - 1] = curr;
            
            map.put(curr, currRank - 1);
            map.put(prevPlayer, currRank);
        }
        
        for(int i = 0; i < players.length; i++){
            answer[i] = players[i];
        }
        
        return answer;
    }
}