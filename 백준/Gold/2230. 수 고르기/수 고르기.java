import java.util.Arrays;
import java.util.Scanner;

// 수열에서 두개 골랐을 때, 차이가 m 이상이면서 가장 작은 경우
// 정렬하고 투포인터
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int diff = scanner.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        int left = 0, right = 0;
        while(right < size){
            if(arr[right] - arr[left] < diff){
                right++;
            }
            else{
                min = Math.min(min, arr[right] - arr[left]);
                left++;
                if(left > right) right++;
            }
        }

        System.out.println(min);
    }
}