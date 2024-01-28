
import java.util.Arrays;
import java.util.Scanner;

// LIS 문제임. 최장 증가 부분수열을 구하면 나머지는 그 사이에 끼워넣으면 되기 때문에
// 전체 길이 - LIS이다.
//public class Boj2631 {
public class Main {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        int[] dp = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }
        dp[0] = 1;

        // 나보다 전에 있는 것들 중, 나보다 작고 dp값이 제일 큰 애로 선택
        for(int i = 1; i < size; i++){
            int max = 0;
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < arr[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        Arrays.sort(dp);

        System.out.println(size - dp[size - 1]);
    }
}
