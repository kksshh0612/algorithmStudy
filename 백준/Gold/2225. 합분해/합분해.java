import java.util.Scanner;

// 0부터 20까지 2개를 더해서 20이 되는 경우의 수  /  0부터 6까지 4개를 더해서 6이 되는 경우의 수
// 순열로 풀 수 있지만 시간초과 -> dp로 해결
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] dp = new int[k + 1][n + 1];

        for(int i = 0; i <= n; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i <= k; i++){
            for(int j = 0; j <= n; j++){
                for(int idx = 0; idx <= j; idx++){
                    dp[i][j] = (dp[i][j] + dp[i - 1][idx]) % 1_000_000_000;
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}

