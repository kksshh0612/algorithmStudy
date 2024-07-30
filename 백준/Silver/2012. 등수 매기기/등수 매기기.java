import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        long ans = 0;
        for(int i = 0; i < size; i++){
            ans += arr[i] - (i + 1) >= 0 ? (arr[i] - (i + 1)) : ((i + 1) - arr[i]);
        }

        System.out.println(ans);
    }
}