import java.util.Scanner;

// 0은 00으로만 됨
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dp = new int[n + 1];
        dp[1] = 1;      // 1

        if(n >= 2){
            dp[2] = 2;      // 11 00
        }

        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.println(dp[n]);
    }
}
