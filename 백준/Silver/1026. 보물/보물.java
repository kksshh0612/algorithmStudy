import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        long[] arr = new long[size];
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextLong();
        }
        long[] arr2 = new long[size];
        for(int i = 0; i < size; i++){
            arr2[i] = scanner.nextLong();
        }

        Arrays.sort(arr);
        Arrays.sort(arr2);
        long sum = 0;

        for(int i = 0; i < size; i++){
            sum += arr[i] * arr2[size - 1 - i];
        }

        System.out.println(sum);
    }
}