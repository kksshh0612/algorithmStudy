import java.util.Arrays;
import java.util.Scanner;

// 무게 / 로프 갯수 -> 최대로 들 수 있는 중량. 모든 로프 사용할 필요는 없음.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ropeNum = scanner.nextInt();
        int[] arr = new int[ropeNum];
        for(int i = 0; i < ropeNum; i++){
            arr[i] = scanner.nextInt();
        }
        int max = 0;

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            max = Math.max(arr[i] * (ropeNum - i), max);
        }

        System.out.println(max);
    }
}
