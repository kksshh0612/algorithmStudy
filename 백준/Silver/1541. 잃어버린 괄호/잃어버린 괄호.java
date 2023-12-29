import java.util.Scanner;

// 마이너스 뒤를 최대로 해야 함. 그래서 마이너스 나오면 다음 마이너스 나올 때까지 더하기
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String[] plus = str.split("-");     // 빼기 기준으로 자름

        int ans = Integer.MAX_VALUE;

        for(String token : plus){
            String[] num = token.split("\\+");

            int currSum = 0;
            for(String numToken : num){
                currSum += Integer.parseInt(numToken);
            }

            if(ans ==Integer.MAX_VALUE){
                ans = currSum;
            }
            else{
                ans -= currSum;
            }
        }

        System.out.println(ans);
    }
}