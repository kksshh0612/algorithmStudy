// import java.util.*;

// class Solution {
//     public int solution(int[] queue1, int[] queue2) {
//         int answer = -2;
//         ArrayDeque<Integer> q1 = new ArrayDeque<>();
//         ArrayDeque<Integer> q2 = new ArrayDeque<>();
//         long sum1 = 0, sum2 = 0;
//         long goal = 0, max = 0;
//         int temp = 0, cnt = 0;
        
//         for(int tmp : queue1) {
//             q1.addFirst(tmp);
//             sum1 += tmp;
//             if(tmp > max) max = tmp;
//         }
//         for(int tmp : queue2) {
//             q2.addFirst(tmp);
//             sum2 += tmp;
//             if(tmp > max) max = tmp;
//         }
        
//         goal = (sum1 + sum2) / 2;       //만들어야 하는 수 
//         if((sum1 + sum2) % 2 == 1 || max > goal) return -1;
        
//         while(!q1.isEmpty() && !q2.isEmpty()){            //큰 쪽에서 작은 쪽으로 옮기기
//             if(sum1 == sum2) break;
//             if(sum1 > sum2){        //1에서 2로 옮김
//                 int val = q1.pollLast();
//                 sum1 -= val;
//                 sum2 += val;
//                 q2.addFirst(val);
//             }
//             else{                   //2에서 1로 옮김
//                 int val = q2.pollLast();
//                 sum2 -= val;
//                 sum1 += val;
//                 q1.addFirst(val);
//             }
//             cnt++;
//         }
        
//         answer = cnt;
        
//         return answer;
//     }
// }



import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        long goal = 0, max = 0;
        int temp = 0, cnt = 0;
        
        for(int tmp : queue1) {
            q1.add(tmp);
            sum1 += tmp;
            if(tmp > max) max = tmp;
        }
        for(int tmp : queue2) {
            q2.add(tmp);
            sum2 += tmp;
            if(tmp > max) max = tmp;
        }
        
        goal = (sum1 + sum2) / 2;       //만들어야 하는 수 
        if((sum1 + sum2) % 2 == 1 || max > goal) {
            return -1;
        }
        
    
        while(!q1.isEmpty() && !q2.isEmpty()){            //큰 쪽에서 작은 쪽으로 옮기기
            if(cnt >= (queue1.length + queue2.length) * 2) {
                cnt = -1;
                break;
            }
            if(sum1 == sum2) break;
            if(sum1 > sum2){        //1에서 2로 옮김
                int val = q1.poll();
                sum1 -= val;
                sum2 += val;
                q2.add(val);
            }
            else{                   //2에서 1로 옮김
                int val = q2.poll();
                sum2 -= val;
                sum1 += val;
                q1.add(val);
            }
            cnt++;
            
        }
        
        answer = cnt;
        
        return answer;
    }
}

