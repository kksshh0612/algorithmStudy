import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 완전탐색 -> 시간초과 날거같음.
// dp로 해결
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int coinType = Integer.parseInt(stringTokenizer.nextToken());
        int total = Integer.parseInt(stringTokenizer.nextToken());
        int[] coin = new int[coinType];
        for(int i = 0; i < coinType; i++){
            coin[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(coin);

        int[] dp = new int[total + 1];
        dp[0] = 1;
        for(int currCoin : coin){
            for(int i = currCoin; i <= total; i++){
                dp[i] = dp[i- currCoin] + dp[i];
            }
        }
        System.out.println(dp[total]);
    }
}