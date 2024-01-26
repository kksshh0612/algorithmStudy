import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static long DFS(int[][] arr, long[][] dp, int currX, int currY){

        if(currX == arr[0].length -1 && currY == arr.length - 1) return 1;

        if(dp[currY][currX] != -1) return dp[currY][currX];

        dp[currY][currX] = 0;

        int nextX = currX + arr[currY][currX];
        int nextY = currY;

        if(nextX >=0 && nextX < arr[0].length && nextY >= 0 && nextY < arr.length){
            dp[currY][currX] += DFS(arr, dp, nextX, nextY);
        }

        nextX = currX;
        nextY = currY + arr[currY][currX];

        if(nextX >=0 && nextX < arr[0].length && nextY >= 0 && nextY < arr.length){
            dp[currY][currX] += DFS(arr, dp, nextX, nextY);
        }

        return dp[currY][currX];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[n][n];
        long[][] dp = new long[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                dp[i][j] = -1;
            }
        }

        long ans = DFS(arr, dp, 0, 0);

        System.out.println(ans);
    }
}