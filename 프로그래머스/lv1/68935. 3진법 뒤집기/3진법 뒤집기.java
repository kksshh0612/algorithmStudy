import java.lang.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder str = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        while(n > 2){
            str.insert(0, n % 3);
            n /= 3;
        }
        str.insert(0, n);
        
        str = str.reverse();        //뒤집기 
        
        for(int i = 0; i < str.length(); i++){
            int num = (int)(str.charAt(i) - '0');
            answer += num * Math.pow((double)3, (double)(str.length() - i - 1));
        }
   
        return answer;
    }
}