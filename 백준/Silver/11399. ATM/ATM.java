import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1 1+2 1+2+3 1+2+3+3 1+2+3+3+4    =   5 + 8 + 9 + 6 + 4
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[num];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(arr);

        int ans = 0;
        for(int i = 0; i < num; i++){
            ans += arr[i] * (num - i);
        }

        System.out.println(ans);
    }

}

