import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String curr : skill_trees){
            StringBuilder currSkill = new StringBuilder();
            
            for(int i = 0; i < curr.length(); i++){
                if(skill.contains(Character.toString(curr.charAt(i)))){
                    currSkill.append(curr.charAt(i));
                }
            }
            
            boolean possible = true;
            
            for(int i = 0; i < currSkill.length(); i++){
                if(i == skill.length()) break;
                
                // System.out.println(currSkill.charAt(i) + " "+ skill.charAt(i));
                
                if(currSkill.charAt(i) != skill.charAt(i)){
                    possible = false;
                }
                
            }
                          
            if(possible) answer++;
            // System.out.println("==========");
            
        }
        
        return answer;
    }
}