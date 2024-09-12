import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        int idx1 = 0, idx2 = 0;
        for(String card : goal){
            System.out.println("여기 :  " + card);
            boolean check = false;
            if(idx1 < cards1.length && cards1[idx1].equals(card)){
                idx1++;
                check = true;
            }
            else if(idx2 < cards2.length && cards2[idx2].equals(card)){
                idx2++;
                check = true;
            }
            
            if(!check){
                answer = "No";
                break;
            }
           
        }
        if(!answer.equals("No")){
            answer = "Yes";
        }
        
        return answer;
    }
}