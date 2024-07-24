import java.io.*;
import java.util.*;
// n개 센서와 k개 집중국 연결. 각 집중국 수신 가능 영역 최소화
// 수신 가능 영역 >= 0   센서 좌표는 같을 수도 있음
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int sensorCnt = Integer.parseInt(bf.readLine());
        int centerCnt = Integer.parseInt(bf.readLine());
        int[] arr = new int[sensorCnt];         // 각 센서 whkvy

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < sensorCnt; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] diff = new int[sensorCnt - 1];
        for(int i = 0; i < sensorCnt - 1; i++){
            diff[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(diff);

        int ans = 0;
        for(int i = 0; i < diff.length - (centerCnt - 1); i++){
            ans += diff[i];
        }

        System.out.println(ans);
    }
}