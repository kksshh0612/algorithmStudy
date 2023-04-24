import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        //본인 옷 잃어버린 사람은 다른사람에게 빌려줄 수 없기 때문에 먼저 확인 
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){              
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] != -1 && reserve[j] != -1){            
                    if(lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1){
                        lost[i] = -1;
                        reserve[j] = -1;
                        answer++;
                        break;
                    }
                }
            }
        }
        
         
        return answer;
    }
}