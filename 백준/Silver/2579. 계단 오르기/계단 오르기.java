import java.util.Scanner;

// 한개 또는 두개 이동, 연속 세개 안됨
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size + 1];
        int[] dp = new int[size + 1];
        for(int i = 1; i <= size; i++){
            arr[i] = scanner.nextInt();
        }

        dp[1] = arr[1];
        if(size >= 2){
            dp[2] = arr[1] + arr[2];
        }

        for(int i = 3; i <= size; i++){
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }

        System.out.println(dp[size]);
    }
}