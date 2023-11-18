import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n일 동안 m번 통장에서 k원 빼는데, k의 최소값
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int days = Integer.parseInt(stringTokenizer.nextToken());
        int totalCnt = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[days];

        long min = 1, max = 0;
        for(int i = 0; i < days; i++){
            arr[i] = Integer.parseInt(bufferedReader.readLine());
            max += arr[i];
            min = Math.max(arr[i], min);
        }

        while(min <= max){

            long mid = (min + max) / 2;
            long currCash = mid, cnt = 1;            //최초 인출 한번
            for(int i = 0; i < arr.length; i++){
                if(arr[i] <= currCash){
                    currCash -= arr[i];     //돈 사용
                }
                else{
                    cnt++;
                    currCash = mid - arr[i];
                }
            }

            if(cnt <= totalCnt){     //인출 횟수가 적거나 같으면 한번에 더 조금 뽑으면 됨
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }

        System.out.println(min);

    }
}
