import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long N = in.nextLong();
        long M = in.nextLong();

        // 각각의 승수
        long count5 = fiveNum(N) - fiveNum(N - M) - fiveNum(M);
        long count2 = twoNum(N) - twoNum(N - M) - twoNum(M);

        System.out.println(Math.min(count5, count2));

    }

    // 5의 승수를 구하는 함수 
    static long fiveNum(long num) {
        int count = 0;

        while(num >= 5) {
            count += (num / 5);
            num /= 5;
        }
        return count;
    }

    // 2의 승수를 구하는 함수
    static long twoNum(long num) {
        int count = 0;

        while(num >= 2) {
            count += (num / 2);
            num /= 2;
        }
        return count;
    }

}