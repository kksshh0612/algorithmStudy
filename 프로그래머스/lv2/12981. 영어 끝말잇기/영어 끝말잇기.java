import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int personCnt = 0, turnCnt = 1;     //현재 턴 사람 수, 현재 턴 수 
        Map<String, Boolean> bannedWord = new HashMap<>();
        char prevLast = 0;
        
        for(String word : words){
            
            if(prevLast == 0){   
                bannedWord.put(word, true);     //금지어에 넣고 
                prevLast = word.charAt(word.length() - 1);      //마지막 단어 저장 
                personCnt++;
                continue;
            }
            
            if(word.charAt(0) != prevLast || bannedWord.containsKey(word)){
                answer[0] = personCnt + 1;
                answer[1] = turnCnt;
                break;
            }
            
            bannedWord.put(word, true);     //금지어에 넣고 
            prevLast = word.charAt(word.length() - 1);      //마지막 단어 저장 
            personCnt++;
            
            if(personCnt == n){
                personCnt = 0;
                turnCnt++;
            } 
        }
        
        return answer;
    }
}