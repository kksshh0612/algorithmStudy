import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 끝까지 가는 최소 비용
//public class Boj13305 {
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cityNum = Integer.parseInt(bufferedReader.readLine());
        int[] road = new int[cityNum];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 1; i < road.length; i++){
            road[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[] city = new int[cityNum];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < cityNum; i++){
            city[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        // 도시의 마지막 주유소는 의미없음.
        long[] dp = new long[cityNum];
        for(int i = 1; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for(int i = 0; i < city.length; i++){
            for(int j = i + 1; j < road.length; j++){
                dp[j] = Math.min(dp[j], dp[j - 1] + city[i] * road[j]);
            }
        }

        System.out.println(dp[cityNum - 1]);
    }
}
