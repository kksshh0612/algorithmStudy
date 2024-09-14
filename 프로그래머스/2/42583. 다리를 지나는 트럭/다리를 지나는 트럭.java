import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();      
        for(int i = 0; i < bridge_length; i++){
            queue.add(0);
        }
        
        int sum = 0, idx = 0;
        while(!queue.isEmpty()){
            answer++;
            sum -= queue.poll();
            
            if(idx < truck_weights.length){
                if(sum + truck_weights[idx] <= weight){     //올라갈 수 있으면
                    queue.add(truck_weights[idx]);
                    sum += truck_weights[idx];
                    idx++;
                }
                else{
                    queue.add(0);
                }
            }
            
        }
        
        return answer;
    }
}