import java.util.Arrays;
import java.util.Scanner;
// 홀수는 0이고 짝수는
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < size; i++){
            stringBuilder.append(arr[i]).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
}