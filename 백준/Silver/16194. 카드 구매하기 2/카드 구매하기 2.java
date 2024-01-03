import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cardPrice = new int[n + 1];
        for(int i = 1; i <= n; i++){
            cardPrice[i] = scanner.nextInt();
        }

        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = cardPrice[i];

            for(int j = 1; j < i; j++){
                dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
            }
        }

        System.out.println(dp[n]);
    }
}