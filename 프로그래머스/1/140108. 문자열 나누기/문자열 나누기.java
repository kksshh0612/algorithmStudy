import java.util.*;
// 첫 글자를 x로 지정. x 수와 다른 문자 수 세기. 둘이 같으면 자름
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char x = s.charAt(0);
        int xCnt = 1, otherCnt = 0;
        for(int i = 1; i < s.length(); i++){
            
            if(x == '0'){
                x = s.charAt(i);
                xCnt = 1;
                otherCnt = 0;
                continue;
            }
            
            if(x == s.charAt(i)){
                xCnt++;
            }
            else{
                otherCnt++;
            }
            
            if(xCnt == otherCnt){
                answer++;
                x = '0';
            }
        }
        
        if(xCnt != otherCnt) answer++;
        
        return answer;
    }
}