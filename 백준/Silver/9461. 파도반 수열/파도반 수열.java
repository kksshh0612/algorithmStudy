import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tCase = scanner.nextInt();
        while(tCase-- > 0){
            int n = scanner.nextInt();
            long[] dp = new long[n + 1];
            dp[1] = 1;
            if(n >= 2) dp[2] = 1;
            if(n >= 3) dp[3] = 1;
            if(n >= 4) dp[4] = 2;
            if(n >= 5) dp[5] = 2;

            for(int i = 6; i <= n; i++){
                dp[i] = dp[i - 1] + dp[i - 5];
            }

            System.out.println(dp[n]);
        }
    }
}