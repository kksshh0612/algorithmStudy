// 찍을 수 없는 점의 수 세기
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        // 원으로 생각
        for(int i = 0; i <= d; i += k){
            long distance = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2));
            
            answer += distance / k + 1;
        }
        
        
        return answer;
    }
}
