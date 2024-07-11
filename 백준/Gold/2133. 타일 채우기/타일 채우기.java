import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        if(n >= 2) dp[2] = 3;
        if(n >= 4) dp[4] = 6 + 3 + 2;

        for(int i = 6; i <= n; i+= 2){
            dp[i] = dp[i - 2] * dp[2];
            for(int j = i - 4; j >= 0; j -= 2){
                dp[i] += dp[j] * 2;
            }

        }

        System.out.println(dp[n]);
    }
}