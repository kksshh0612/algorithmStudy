import java.util.*;
// 투 포인터
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        int size = elements.length;
        for(int i = 0; i < size; i++){
            int head = i, tail = i;
            int sum = elements[i];
            set.add(sum);
            
            for(int j = 1; j < size; j++){
                head = (head + 1) % size;
                sum += elements[head];
                set.add(sum);
            }
            for(int j = 1; j < size; j++){
                sum -= elements[tail];
                set.add(sum);
                tail = (tail + 1) % size;
            }
            
        }
        answer = set.size();
        
        return answer;
    }
}