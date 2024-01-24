import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }
        int[] dp = new int[n + 1];

        int cnt = 1;
        for(int i = arr[0]; i <= n; i += arr[0]){
            dp[i] = cnt++;
        }

        for(int i = 1; i < size; i++){
            int currCoin = arr[i];

            for(int j = currCoin; j <= n; j++){
                if(dp[j - currCoin] > 0 || j - currCoin == 0){
                    if(dp[j] == 0){
                        dp[j] = dp[j - currCoin] + 1;
                    }
                    else{
                        dp[j] = Math.min(dp[j], dp[j - currCoin] + 1);
                    }
                }
            }
        }

        if(dp[n] == 0){
            System.out.println(-1);
        }
        else{
            System.out.println(dp[n]);
        }


    }
}