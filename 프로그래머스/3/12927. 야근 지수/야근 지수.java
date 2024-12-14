import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        
        for(int work : works){
            pq.add(work);
        }
        
        while(n-- > 0){
            int curr = pq.poll();
            
            pq.add(curr - 1);
        }
        
        while(!pq.isEmpty()){
            int num = pq.poll();
            
            if(num < 0) break;
            
            answer += num * num;
        }
        
        return answer;
    }
}