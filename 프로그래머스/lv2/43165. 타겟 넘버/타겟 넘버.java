import java.util.*;

class Solution {
    
    public static int cnt;
    
    public static void DFS(int[] numbers, int target, boolean[] check, int currIdx){
        if(currIdx == numbers.length){
            int currNum = 0;
            for(int i = 0; i < numbers.length; i++){

                if(check[i]){           
                    currNum -= numbers[i];
                }
                else{
                    currNum += numbers[i];
                }
            }
            if(currNum == target) cnt++;
        }
        else{
            check[currIdx] = true;
            DFS(numbers, target, check, currIdx + 1);
            check[currIdx] = false;
            DFS(numbers, target, check, currIdx + 1);
        }
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        boolean[] isMinus = new boolean[numbers.length];   
        boolean[] check = new boolean[numbers.length];      //해당 수를 빼는지 확인. true면 빼고 아니면 더할거임.  
        cnt = 0;
        
        DFS(numbers, target, check, 0);
        
        answer = cnt;
        
        return answer;
    }
}