import java.util.Scanner;

// 1, 2, 3으로 나타내는 방법의 수 -> dp
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tCase = scanner.nextInt();

        while(tCase-- > 0){
            int n = scanner.nextInt();
            int[][] dp = new int[3][n + 1];
            for(int i = 0; i <= n; i++){
                dp[0][i] = 1;
            }
            dp[1][0] = dp[2][0] = dp[1][1] = dp[2][1] = 1;

            for(int i = 2; i <= n; i++){
                dp[1][i] = dp[0][i] + dp[1][i - 2];

            }

            if(n >= 2) dp[2][2] = dp[1][2];

            for(int i = 3; i <= n; i++){
                dp[2][i] = dp[1][i] + dp[2][i - 3];
            }

            System.out.println(dp[2][n]);
        }
    }
}