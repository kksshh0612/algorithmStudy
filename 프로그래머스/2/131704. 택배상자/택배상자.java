import java.util.*;
// 실을 순서 아니면 대기 스택에 넣음.
// 최대 몇개 실을 수 잇는지
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        // 1~N까지 주어짐.order 반복하며 1부터 order[i]가 나올 때까지 스택에 넣음.
        // 스택 탑이 order[i]면 거기서 뺌
        int num = 1;
        for(int i = 0; i < order.length; i++){
            while(num < order[i]){
                stack.push(num);
                num++;
            }
            if(num == order[i]){
                answer++;
                num++;
            }
            else{
                if(stack.peek() == order[i]){
                    answer++;
                    stack.pop();
                    
                }
                else{
                    break;
                }
            }
            
        }
        
        return answer;
    }
}