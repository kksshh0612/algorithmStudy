import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        answer = new int[2];
        char op = 0;
        int goal = 0;
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations){
            op = operation.charAt(0);
            
            switch(op){
                case 'I':
                    goal = Integer.parseInt(operation.substring(2));
                    minQueue.add(goal);
                    maxQueue.add(goal);
                    break;
                case 'D':
                    if(minQueue.isEmpty() || maxQueue.isEmpty()){   //비어있으면 무시
                        break;
                    }
                    if(operation.charAt(2) == '-'){     //최솟값 삭제
                        goal = minQueue.poll();
                        maxQueue.remove(goal);
                    }
                    else{                               //최댓값 삭제
                        goal = maxQueue.poll();
                        minQueue.remove(goal);
                    }
                    break;
            }
        }
        if(minQueue.isEmpty() || maxQueue.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }
        
        return answer;
    }
}