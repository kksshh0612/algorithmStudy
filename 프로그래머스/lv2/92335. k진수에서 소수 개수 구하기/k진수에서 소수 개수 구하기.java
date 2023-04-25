import java.util.*;

class Solution {
    
    public static boolean isPrime(String str){
        long num = Long.parseLong(str);

        if(num == 1) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        String str = "";        //k진수 저장하는 문자열

        //k진수 만들기 
        while(n > (k - 1)){
            str = Integer.toString(n % k) + str;
            n /= k;
        }
        str = n + str;
        
        String[] strArr = str.split("0");
        
        for(String data : strArr){
            if(data.equals("")) continue;

            if(isPrime(data)){
                answer++;
            }
        }
        
        
        return answer;
    }
}