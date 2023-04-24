import java.util.*;

class Solution {
    public int[] solution(String s) {       //s가 1이 될 때까지 
        int[] answer = new int[2];
        int currOneNum = 0, currZeroNum = 0;             //1의 개수
        int zeroNum = 0;     //제거된 0의 갯수 
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();     //자릿수를 이진수로 바꿀 때 사용
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                currZeroNum++;          //0이 몇개인지 셈 
            }
        }
        currOneNum = s.length() - currZeroNum;      //1이 몇개인지 
        
        while(!(currOneNum == 1 && currZeroNum == 0)){
            zeroNum += currZeroNum;     //누적 지워진 0의 수 
            cnt++;
            while(currOneNum != 1){
                stack.push(currOneNum % 2);
                currOneNum /= 2;
            }
            stack.push(1);
            
            currOneNum = 0;
            currZeroNum = 0;
            
            while(!stack.isEmpty()){        //스택이 빌 때까지 반복 
                int curr = stack.pop();
                if(curr == 1){
                    currOneNum++;
                }
                else{
                    currZeroNum++;
                }
            }
        }
        
        answer[0] = cnt;
        answer[1] = zeroNum;
        
        
        return answer;
    }
}