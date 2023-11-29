import java.util.*;

// 각 팀에서 한명씩 나와서 숫자 비교하고 큰 쪽이 승점 1점 얻음 
// B는 A의 순서를 알고 있음. B가 얻을 수 있는 최고의 승점 구하기
// A는 출전 순서대로 주어짐. A B 길이 같음 
// 우선순위 큐에 넣고, 해당 번호보다 큰 것중에 가장 작은 수를 내보내기 -> 그리디 (틀림) 시간초과 

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx = 0, bIdx = 0;
        while(bIdx < B.length){
            if(A[aIdx] < B[bIdx]){
                aIdx++;
                bIdx++;
                answer++;
            }
            else{
                bIdx++;
            }
               
        }
        
        return answer;
    }
}