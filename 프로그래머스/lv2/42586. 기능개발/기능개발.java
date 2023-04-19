import java.util.*;

class Solution {        //하나 빼고 남은 진도를 스피드로 나눠서 걸린 시간 구하고, peek를 하나씩 보면서 계산해보고 끝나면 뺌
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int currNum = 0;
        int time = 0;       //현재 일이 작업을 끝내는데 걸린 시간 
        int currIdx = -1;
        Queue<Integer> queue = new LinkedList<>();      //작업을 넣을 큐 
        ArrayList<Integer> ansArrList = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){
            queue.add(progresses[i]);     //작업을 모두 큐에 넣음. 
        }
        
        while(!queue.isEmpty()){
            int cnt = 0;                    
            currNum = queue.poll();         //큐 젤 앞에 있는 작업
            currIdx++;
            cnt++;
            //배포할 때까지 걸린 시간 
            time = (int)Math.ceil(((double)(100 - currNum) / (double)speeds[currIdx]));
            
            System.out.println(time);
            while(!queue.isEmpty()){       //큐에 다른 작업이 남아있을 때, currNum 처리하는동안 처리됐는지 확인. 
                currNum = queue.peek();
                if(currNum + speeds[currIdx + 1] * time >= 100){
                    currIdx++;
                    cnt++;
                    queue.poll();
                }
                else{
                    break;
                }
            }
            ansArrList.add(cnt);        //한번 배포할 때 끝난 작업 수 

        }
        
        answer = new int[ansArrList.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = ansArrList.get(i);
        }
            
            
        return answer;
    }
}