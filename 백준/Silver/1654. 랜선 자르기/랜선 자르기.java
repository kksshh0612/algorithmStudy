import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 같은 길이로 만들 수 있는 최대의 랜선 길이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int totalNum = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(arr);
        long left = 1, right = arr[arr.length - 1], mid = 0;
        while(left <= right){
            mid = (left + right) / 2;

            long currNum = 0;
            for(int i = 0; i < size; i++){
                currNum += arr[i] / mid;
            }

            if(currNum >= totalNum){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}
