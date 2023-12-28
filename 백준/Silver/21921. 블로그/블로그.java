import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시작과 끝을 포인터로 두고, 하나씩 오른쪽으로 옮기면서 값 비교하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int day = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] arr = new int[size];

        int currSum = 0;
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            if(i < day){
                currSum += arr[i];
            }
        }

        int maxNum = 1, max = currSum;

        int start = 0, end = day - 1;
        while(end < size - 1){
            currSum -= arr[start++];
            currSum += arr[++end];

            if(max < currSum){
                max = currSum;
                maxNum = 1;
            }
            else if(max == currSum){
                maxNum++;
            }
        }

        if(max == 0) System.out.println("SAD");
        else System.out.println(max + "\n" + maxNum);
    }
}