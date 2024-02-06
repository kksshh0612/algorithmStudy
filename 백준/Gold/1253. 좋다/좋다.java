
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 정렬 하고 투포인터?
//public class Boj1253 {
public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[size];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(arr);
        
        int ans = 0;
        for(int i = 0; i < size; i++){
            int currNum = arr[i];
            int start = 0, end = size - 1;
            while(start < end){
                //본인은 안됨
                if(start == i) start++;
                if(end == i) end--;
                if(start >= end) break;

                if(arr[start] + arr[end] == currNum){
                    ans++;
                    break;
                }
                else if(arr[start] + arr[end] < currNum){
                    start++;
                }
                else{
                    end--;
                }
            }
        }
        System.out.println(ans);
    }
}
