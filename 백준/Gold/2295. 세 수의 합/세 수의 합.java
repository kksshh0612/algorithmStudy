import java.util.*;
import java.io.*;

// x + y = k - z
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        // x + y 리스트에 저장
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                list.add(arr[i] + arr[j]);
            }
        }
        Collections.sort(list);

        int ans = -1;
        // k - z 가 리스트에 있는지 확인
        for(int i = size - 1; i >= 0; i--) {
            for(int j = size - 1; j >= 0; j--){
                if(Collections.binarySearch(list, arr[i] - arr[j]) >= 0){
                    ans = Math.max(ans, arr[i]);
                }
            }
        }
        System.out.println(ans);
    }
}

