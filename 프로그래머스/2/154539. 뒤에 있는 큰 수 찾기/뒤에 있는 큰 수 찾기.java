import java.util.*;

// 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수 
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> idxStack = new Stack<>();        // 인덱스를 저장하는 스택
        
        for(int i = 0; i < numbers.length; i++){
            
            while(!idxStack.isEmpty() && numbers[idxStack.peek()] < numbers[i]){
                answer[idxStack.pop()] = numbers[i];
            }
            
            idxStack.push(i);
        }
        
        while(!idxStack.isEmpty()){
            answer[idxStack.pop()] = -1;
        }
        
        return answer;
    }
}