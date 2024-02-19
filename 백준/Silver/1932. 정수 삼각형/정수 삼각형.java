import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dp문제임
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[size][size];

        for(int i = 0; i < size; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j <= i; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[][] dp = new int[size][size];
        dp[0][0] = arr[0][0];

        for(int i = 0; i < size - 1; i++){
            for(int j = 0; j <= i; j++){
                dp[i + 1][j] = Math.max(dp[i][j] + arr[i + 1][j], dp[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i][j] + arr[i + 1][j + 1], dp[i + 1][j + 1]);
            }
        }

        int max = 0;
        for(int i = 0; i < size; i++){
            max = Math.max(max, dp[size - 1][i]);
        }

        System.out.println(max);
    }
}