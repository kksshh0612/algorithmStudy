import java.util.Scanner;

// 대각선 이동을 반으로 나눠서 한칸 이동보다 숫자 작으면 최대한 대각선 이동하도록 하기
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        long oneBlock = scanner.nextLong();
        long cross = scanner.nextLong();

        long ans1 = 0, ans2 = 0, ans3 = 0;
        // 옆,위로만 이동
        ans1 = (x + y) * oneBlock;

        //대각으로만 이동 (짝수인경우)
        if((x + y) % 2 == 0){
            ans2 = cross * Math.max(x, y);
        }
        else{
            ans2 = cross * (Math.max(x, y) - 1) + oneBlock;
        }

        ans3 = cross * Math.min(x, y) + Math.abs(x - y) * oneBlock;

        System.out.println(Math.min(ans1, Math.min(ans2, ans3)));
    }
}