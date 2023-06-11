import java.util.Scanner;

// 15988 1, 2, 3 더하기 3
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tCase = scanner.nextInt();
        long[] dp = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int lastIdx = 4;

        for(int i = 0; i < tCase; i++){
            int num = scanner.nextInt();
            for(int j = lastIdx; j <= num; j++){
                dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1_000_000_009;
                lastIdx = j;
            }
            System.out.println(dp[num]);
        }
    }
}