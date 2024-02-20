import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] health = new int[n];
        int[] joy = new int[n];
        for(int i = 0; i < n; i++){
            health[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++){
            joy[i] = scanner.nextInt();
        }

        int[][] dp = new int[n][101];

        for(int i = health[0]; i <= 99; i++){
            dp[0][i] = joy[0];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j <= 99; j++){
                if(health[i] <= j){
                    dp[i][j] = Math.max(dp[i - 1][j - health[i]] + joy[i], dp[i - 1][j]);
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n - 1][99]);
    }
}