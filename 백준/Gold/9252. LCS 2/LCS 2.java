import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최장 공통 부분 수열
//public class Boj9252 {
public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine(), s1 = br.readLine();

        int[][] dp = new int[s.length() + 1][s1.length() + 1];

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= s1.length(); j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if(s.charAt(i - 1) == s1.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1 , dp[i][j]);
                }
            }
        }

        String answer = "";
        int i = dp.length - 1, j = dp[0].length - 1;
        while(i != 0 && j != 0) {
            if(dp[i][j] == dp[i - 1][j]) {
                i--;
            }
            else if(dp[i][j] == dp[i][j - 1]) {
                j--;
            }
            else {
                answer += s.charAt(i - 1);
                i--;
                j--;
            }
        }
        System.out.println(dp[s.length()][s1.length()]);
        System.out.print(new StringBuilder(answer).reverse());
    }


}
