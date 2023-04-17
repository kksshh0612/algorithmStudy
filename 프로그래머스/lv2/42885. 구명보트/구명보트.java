import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;         //구명보트 수 
        int left = 0;
        int right = people.length - 1;
        
        Arrays.sort(people);
        
        while(left <= right){       //왼쪽부터 오른쪽까지 서로를 향해 탐색. 
            if(people[left] + people[right] <= limit){      //왼쪽과 오른쪽 두명 다 탈 수 있으면
                left++;
                right--;        //둘 다 태움
                answer++;      
            }   
            else{                       //왼쪽과 오른쪽 둘 다 못타면 
                right--;       //무거운 사람만 태움
                answer++;
            }
        }
        
        return answer;
    }
}