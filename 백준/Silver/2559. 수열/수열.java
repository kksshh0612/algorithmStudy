import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int continueDay = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[size];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int currSum = 0, start = 0, end = 0;
        int max = 0;
        for(int i = 0; i < continueDay; i++){
            currSum += arr[end++];
        }
        max = currSum;

        while(end < size){
            currSum -= arr[start++];
            currSum += arr[end++];

            max = Math.max(currSum, max);
        }

        System.out.println(max);
    }
}
