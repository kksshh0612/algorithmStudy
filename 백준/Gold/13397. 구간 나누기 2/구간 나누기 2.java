import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    public static int countPartition(int mid, int[] arr){
        int cnt = 1;

        int max = arr[0];
        int min = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min) min = arr[i];
            if(arr[i] > max) max = arr[i];

            if(max - min > mid){        // 새로운 구간 시작
                cnt++;
                min = arr[i];
                max = arr[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int partition = Integer.parseInt(st.nextToken());
        int[] arr = new int[size];

        st = new StringTokenizer(br.readLine());
        int left = 0, right = 0;
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        while(left <= right){
            int mid = (left + right) / 2;

            int partitionCnt = countPartition(mid, arr);

            if(partitionCnt > partition){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        System.out.println(right + 1);
    }
}