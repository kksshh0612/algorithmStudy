import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int len = Integer.parseInt(stringTokenizer.nextToken());
        int same = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[len];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < len; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] numberCount = new int[100001];
        int max = 0;
        int start = 0, end = 0;

        while(end < len){       //end가 마지막에 도달할 때까지
            while(end < len && numberCount[arr[end]] + 1 <= same){      //부분수열 조건에 만족하면 추가
                numberCount[arr[end++]]++;
            }

            max = Math.max(end - start, max);

            numberCount[arr[start++]]--;        //start 앞으로 전진
        }

        System.out.println(max);
    }
}
