import java.util.Scanner;

//9095 1, 2, 3 더하기
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tCase = scanner.nextInt();
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 0; i < tCase; i++){
            int num = scanner.nextInt();

            for(int idx = 4; idx <= num; idx++){
                dp[idx] = dp[idx - 1] + dp[idx - 2] + dp[idx - 3];
            }

            System.out.println(dp[num]);
        }
    }
}