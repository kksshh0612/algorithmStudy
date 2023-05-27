import java.util.*;

class Solution {
    
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 1; j < numbers.length; j++){
                if(i != j){
                   set.add(numbers[i] + numbers[j]); 
                }
                
            }
        }
    
        ArrayList<Integer> arr = new ArrayList<>(set);
        Collections.sort(arr);
        
        answer = new int[arr.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}