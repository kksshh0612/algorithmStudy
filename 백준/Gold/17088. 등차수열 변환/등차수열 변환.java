import java.util.*;
import java.io.*;

// 각 끝 + - 0 이거 조합하기
// +1 +1  /  +1 0  /  +1 -1  /  0 +1  /  0 0  /  0 -1  /  -1 +1  /  -1 0  /  -1 -1
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());
        int[] arr = new int[size];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] caseStart = {1, 1, 1, 0, 0, 0, -1, -1, -1};
        int[] caseEnd = {1, 0, -1, 1, 0, -1, 1, 0, -1};

        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;

        if(size == 1) {
            ans = 0;
            System.out.println(ans);
            return;
        }

        int[] test = new int[size];
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                int start = arr[0] + i;
                int end = arr[1] + j;
                int term = end - start;

//                System.out.println("start : " + start + " term : " + term);
//                System.out.println("term : " + term);

                int cnt = 0, curr = start + term;
                boolean isPossible = true;
                for(int idx = 2; idx < size; idx++){
                    if(arr[idx] - (curr + term) == 1 || arr[idx] - (curr + term) == -1){
                        cnt++;
                    }
                    else if(arr[idx] - (curr + term) > 1 || arr[idx] - (curr + term) < -1){       // 만들 수 없음
                        isPossible = false;
                        break;
                    }
                    curr += term;
                }
                if(!isPossible) continue;

                if(i != 0) cnt++;
                if(j != 0) cnt++;

//                System.out.println(cnt);

                ans = Math.min(ans, cnt);
            }
        }







        if(ans == Integer.MAX_VALUE) ans = -1;

        System.out.println(ans);
    }
}