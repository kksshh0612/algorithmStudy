import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 한 블루레이 당 여러개 연속으로 넣을 수 있음. 블루레이 크기 최소로 해서 정해진 갯수 안에 다 넣기 .
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int total = Integer.parseInt(stringTokenizer.nextToken());  //블루레이 갯수
        int[] arr = new int[size];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int min = 0, max = 0;
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            min = Math.max(min, arr[i]);
            max += arr[i];
        }

        while(min <= max){
            int mid = (min + max) / 2;
            long sum = 0, cnt = 1;

            for(int i = 0; i < arr.length; i++){

                sum += arr[i];

                if(sum > mid){      //넘어가면 다음 블루레이에 넣어야 함.
                    cnt++;
                    sum = arr[i];
                }
            }

            if(cnt > total){
                min = mid + 1;
            }
            else{                   //작거나 같으면 블루레이 사이즈 좀 더 작아도 됨
                max = mid - 1;
            }
        }

        System.out.println(min);
    }
}
