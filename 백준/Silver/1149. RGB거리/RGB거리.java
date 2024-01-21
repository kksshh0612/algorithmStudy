
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1번, 2번 색 겹치면 안됨. n번 n-1번 색 겹치면 안됨
// 걍 연속으로 색 같으면 안됨
// 각 집을 빨 초 파로 칠할 때, 비용 최소로 칠하는 법
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[][] val = new int[size][3];     // 빨 초 파
        for(int i = 0; i < size; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < 3; j++){
                val[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[][] dp = new int[3][size];
        dp[0][0] = val[0][0];
        dp[1][0] = val[0][1];
        dp[2][0] = val[0][2];
        for(int i = 1; i < size; i++){
            dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + val[i][0];
            dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + val[i][1];
            dp[2][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + val[i][2];
        }


        System.out.println(Math.min(dp[0][size - 1], Math.min(dp[1][size - 1], dp[2][size - 1])));
    }
}