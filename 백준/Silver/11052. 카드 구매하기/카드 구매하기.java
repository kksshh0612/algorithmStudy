import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 카드 1개부터 n개까지 들어있음.
// 최대한 비싼 돈을 주고 카드를 n개 구매하도록
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n + 1];     // 1~n까지
        int[] dp = new int[n + 1];      // i 장을 구매했을 때, 지불하는 최대 비용
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());     // 인덱스가 카드 갯수, 값이 비용
            dp[i] = arr[i];
        }

        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i / 2; j++){
                dp[i] = Math.max(dp[j] + dp[i - j], dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}