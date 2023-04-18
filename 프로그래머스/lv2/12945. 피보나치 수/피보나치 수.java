import java.util.*;

class Solution {
    
//     public static int[] fibArr = new int[100001];
    
//     public static int fib(int n){
//         if(fibArr[n] != 0){
//             return fibArr[n];
//         }
//         if(n == 0 || n == 1) {
//             return n;
//         }

//         fibArr[n] = fib(n - 1) + fib(n - 2);
//         return fibArr[n];

//     }
    
//     public int solution(int n) {
//         int answer = 0;
//         int fibNum = fib(n);
//         answer = fibNum % 1234567;
        
//         return answer;
//     }
    
    public int solution(int n) {
        int answer = 0;
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i <= n; i++){
            fib[i] = (fib[i - 1] + fib[i - 2]) % 1234567;
        }
        answer = fib[n];
        
        return answer;
    }
}