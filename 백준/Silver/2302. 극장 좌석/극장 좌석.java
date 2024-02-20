import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int fixSize = scanner.nextInt();
        boolean[] isFixed = new boolean[size + 1];
        for(int i = 0; i < fixSize; i++){
            isFixed[scanner.nextInt()] = true;
        }
        int[] dp = new int[size + 1];       //연속된 자리의 바꾸는 수 저장
        dp[1] = 1;

        if(size >= 2) dp[2] = 2;

        for(int i = 3; i <= size; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int continueCnt = 0, ans = 1;
        for(int i = 1; i <= size; i++){
            if(isFixed[i]){
                ans *= dp[continueCnt] == 0 ? 1 : dp[continueCnt];
                continueCnt = 0;
            }
            else{
                continueCnt++;
            }
        }
        ans *= dp[continueCnt] == 0 ? 1 : dp[continueCnt];

        System.out.println(ans);
    }
}