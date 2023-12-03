import java.util.*;

// 키 합 100 찾기
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++){
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        sum -= 100;

        boolean end = false;
        for(int i = 0; i < 8; i++){
            if(end) break;
            for(int j = i + 1; j < 9; j++){
                if(arr[i] + arr[j] == sum){
                    arr[i] = -1;
                    arr[j] = -1;
                    end = true;
                    break;
                }
            }
        }

        Arrays.sort(arr);

        for(int i = 2; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
