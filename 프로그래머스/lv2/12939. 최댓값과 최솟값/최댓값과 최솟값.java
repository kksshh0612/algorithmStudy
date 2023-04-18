import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        int i = 0;
        String currNum = "";
        while(i < s.length()){
            if(s.charAt(i) == ' '){
                arr.add(Integer.parseInt(currNum));
                // System.out.println(currNum);
                currNum = "";
                i++;
            }
            else {
                if(s.charAt(i) == '-'){
                    currNum += "-";
                    i++;
                }
                else{
                    currNum += s.charAt(i) - 48;
                    i++;
                }
            }
        }
        arr.add(Integer.parseInt(currNum));
        
        Collections.sort(arr);
        
        answer = Integer.toString(arr.get(0)) + " " + Integer.toString(arr.get(arr.size() - 1));
        
        return answer;
    }
}