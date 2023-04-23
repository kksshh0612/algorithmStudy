import java.util.*;
//낮은 두개 뽑아서 스코빌 지수 만들고 최소힙에 넣고, 반복. 
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int num1 = 0, num2 = 0, scov = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            priorityQueue.add(scoville[i]);
        }

        while(priorityQueue.peek() < K){
            if(priorityQueue.size() < 2){
                answer = -1;
                break;
            }
            num1 = priorityQueue.poll();
            num2 = priorityQueue.poll();
            scov = num1 + num2 * 2;
            priorityQueue.add(scov);
            answer++;
        }

        return answer;
    }
}