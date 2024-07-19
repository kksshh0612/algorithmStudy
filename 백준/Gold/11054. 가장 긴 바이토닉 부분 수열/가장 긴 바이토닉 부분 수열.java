import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[size];
        int[] dp = new int[size];
        int[] dp2 = new int[size];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        dp[0] = 1;
        for(int i = 1; i < size; i++){
            int maxDp = 0;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    maxDp = Math.max(maxDp, dp[j]);
                }
            }
            dp[i] = maxDp + 1;
        }

        dp2[size - 1] = 1;
        for(int i = size - 2; i >= 0; i--){
            int maxDp = 0;
            for(int j = size - 1; j > i; j--){
                if(arr[j] < arr[i]){
                    maxDp = Math.max(maxDp, dp2[j]);
                }
            }
            dp[i] += maxDp;
            dp2[i] = maxDp + 1;
        }

        Arrays.sort(dp);
        System.out.println(dp[size - 1]);
    }
}