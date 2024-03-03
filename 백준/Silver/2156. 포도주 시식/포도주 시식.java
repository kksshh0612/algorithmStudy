import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 수를 선택해서 최대를 만들기 -> 3개 연속은 안됨. -> 완전탐색 불가임.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        int[] dp = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }

        dp[0] = arr[0];
        for(int i = 1; i < size; i++){

            if(i == 1) {
                dp[i] = dp[0] + arr[1];
                continue;
            }
            if(i == 2){
                dp[i] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
                continue;
            }

            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }

        Arrays.sort(dp);
        System.out.println(dp[size - 1]);
    }
}
// 00X 0X0 X00