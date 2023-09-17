import java.util.Scanner;

//public class Boj14916 {
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalPrice = scanner.nextInt();
        int[] dp = new int[totalPrice + 1];         // 동전 갯수 저장할 dp 배열

        for(int i = 0; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        if(totalPrice >= 2){
            dp[2] = 1;
        }
        if(totalPrice >= 4){
            dp[4] = 2;
        }
        if(totalPrice >= 5){
            dp[5] = 1;
        }

        // 2 작은 값과 5 작은 값 중 최솟값 + 1 ex) 10 -> 8 (4개) 5 (1개) -> 1개 선택 ==> 10 = 5 + 5
        for(int i = 6; i < dp.length; i++){
            dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
        }

        if(dp[totalPrice] == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(dp[totalPrice]);
        }
    }
}