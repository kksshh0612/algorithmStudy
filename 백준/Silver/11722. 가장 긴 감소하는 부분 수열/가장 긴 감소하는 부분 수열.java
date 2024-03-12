import java.util.Arrays;
import java.util.Scanner;


// 나보다 큰 것 중에 길이가 가장 긴 거
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }
        int[] dp = new int[size];
        dp[0] = 1;

        for(int i = 1; i < size; i++){
            int maxLen = 0;
            for(int j = i - 1; j >= 0; j--){
                if(arr[i] < arr[j] && maxLen < dp[j]){
                    maxLen = dp[j];
                }
            }
            dp[i] = maxLen + 1;
        }

        Arrays.sort(dp);

        System.out.println(dp[size - 1]);
    }
}