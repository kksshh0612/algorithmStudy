import java.util.*;
// 무적권 k번 쓸 수 있음
// 무적권은 현재 가장 많을 때 쓰는게 이득임
class Solution {    // 처음 병사 수 / 무적권 수 / 매 라운드 적 수
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        
        int curr = 0;   // 일단 curr에 더하고 curr이 n보다 커지면 k 확인 후 pq에서 하나 빼서 curr에서 그 수 빼기
        for(int i = 0; i < enemy.length; i++){
            curr += enemy[i];
            pq.add(enemy[i]);
            
            if(curr > n){
                if(k > 0){
                    curr -= pq.poll();
                    k--;
                }
                else{           // 무적권 없으면 끝임
                    answer = i;
                    break;
                }
            }
        }
        
        if(answer == 0) answer = enemy.length;
        
        return answer;
    }
}