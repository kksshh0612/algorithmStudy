import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 누적을 모두 배열로 구하기엔 n제곱? nlogn의 시간복잡도 나옴 -> 시간초과
// dp 배열 만들고 맨 끝부터 인덱스 arr[i] > arr[i] + arr[i + 1] ? arr[i] : arr[i] + arr[i + 1]
//public class Boj1912 {
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for(int i = n - 2; i >= 0; i--){
            if(arr[i] < arr[i] + arr[i + 1]){
                arr[i] = arr[i] + arr[i + 1];
            }
        }
        Arrays.sort(arr);

        System.out.println(arr[n - 1]);
    }
}
