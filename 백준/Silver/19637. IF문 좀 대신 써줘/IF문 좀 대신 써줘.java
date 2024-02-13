
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 십만을 순차탐색하는 것을 10만번 -> 시간초과 --> 이분탐색으로 풀기
//public class Boj19637 {
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        String[] step = new String[n];
        int[] level = new int[n];

        for(int i = 0; i < n; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            step[i] = stringTokenizer.nextToken();
            level[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < size; i++){
            int curr = Integer.parseInt(bufferedReader.readLine());

            int start = 0, end = n - 1;
            while(start < end){
                int mid = (start + end) / 2;

                if(curr > level[mid]){
                    start = mid + 1;
                }
                else{
                    end = mid;
                }
            }

            stringBuilder.append(step[start]).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
}
