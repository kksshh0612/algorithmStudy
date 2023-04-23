import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        ArrayList<Integer> arrList = new ArrayList<>();
        int prev = arr[0];
        arrList.add(prev);
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == prev){
                continue;
            }
            else{
                prev = arr[i];
                arrList.add(arr[i]);
            }
        }
        
        answer = new int[arrList.size()];
        for(int i = 0; i < arrList.size(); i++){
            answer[i] = arrList.get(i);
        }
        return answer;
    }
}