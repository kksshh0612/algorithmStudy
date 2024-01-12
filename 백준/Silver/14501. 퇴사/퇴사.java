import java.util.Scanner;

// dp임 / 쪼갤 수 없는 보석을 정해진 무게의 가방에 담는 문제와 같다.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] days = new int[size + 1];
        int[] moneys = new int[size + 1];
        for(int i = 1; i <= size; i++){
            days[i] = scanner.nextInt();
            moneys[i] = scanner.nextInt();
        }
        int[] dp = new int[size + 2];

        for(int i = size; i >= 1; i--){

            if(i + days[i] > size + 1){     //날짜 넘어가면 해당 상담은 할 수 없음. 포함하지 않음. 
                dp[i] = dp[i + 1];
                continue;
            }

            dp[i] = Math.max(moneys[i] + dp[i + days[i]], dp[i + 1]);
        }

//        for(int i = 1; i <= size; i++){
//            System.out.print(dp[i] + " ");
//        }

        System.out.println(dp[1]);
    }
}