import java.util.Scanner;

// 1로 시작, 1이 두번 연속 ㄴㄴ
//public class Boj2193 {
public class Main {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] dp = new long[n + 1];

        dp[1] = 1;
        if(dp.length > 2){
            dp[2] = 1;          // 10
        }

        // i-2번째는 1로 시작하는거, i-1번째는 0으로 시작하는거
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}
