import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(scanner.next());
        }
        int[] dp = new int[n + 1];

        dp[1] = arr[1];

        for(int i = 2; i <= n; i++){
            dp[i] = arr[i];
            for(int j = 1; j < i; j++){
                if(arr[j] < arr[i] && dp[j] + arr[i] > dp[i]){
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

//        for(int i = 1; i <= n; i++){
//            System.out.print(dp[i] + " ");
//        }

        Arrays.sort(dp);

        System.out.println(dp[n]);

    }
}
