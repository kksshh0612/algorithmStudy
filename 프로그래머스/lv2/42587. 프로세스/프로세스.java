import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        int currMaxIdx = priorities.length - 1;
        
        for(int i = 0; i < priorities.length; i++){
            int[] process = new int[2];     //프로세스종류와 우선순위를 저장하는 배열
            process[0] = i;
            process[1] = priorities[i];      //인덱스와 우선순위 저장 
            queue.add(process);
        }
        
        //priorities는 이제 더이상 안쓰는 배열. 내림차순 정렬한 후, 현재 큐 맨 앞에 있는 수와 최댓값이 같으면 큐에서 뺌. 
        Arrays.sort(priorities);        //오름차순 정렬. 
        
        while(!queue.isEmpty()){
            int currIdx = queue.peek()[0];
            int currPriority = queue.peek()[1];
            if(currPriority >= priorities[currMaxIdx]){     //현재 큐 앞에 있는 값이 최고 우선순위이면 
                queue.poll();
                answer++;
                currMaxIdx--;
                if(currIdx == location){
                    break;
                }
            }
            else{       //최고 우선순위 아니면 
                queue.add(queue.poll());        //뽑아서 맨 뒤로 넣기 
            }
        }
        
        return answer;
    }
}