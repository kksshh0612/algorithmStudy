import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int tCase = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[size];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < size; i++){
            int num = Integer.parseInt(stringTokenizer.nextToken());
            if(i == 0) arr[i] = num;
            else arr[i] = arr[i - 1] + num;
        }

        while(tCase-- > 0){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int end = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            if(start == 0) System.out.println(arr[end]);
            else System.out.println(arr[end] - arr[start - 1]);
        }
    }
}