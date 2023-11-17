import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최대로 예산을 배정할 수 있는 상한액
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int total = Integer.parseInt(bufferedReader.readLine());

        Arrays.sort(arr);
        int left = 0, right = arr[size - 1], mid = 0;
        while(left <= right){
            mid = (left + right) / 2;
            long sum = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] < mid){
                    sum += arr[i];
                }
                else{
                    sum += mid;
                }
            }
            if(sum <= total){
                left = mid + 1;
            }
            else if(sum > total){
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
