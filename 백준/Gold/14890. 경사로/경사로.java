import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean rowCheck(int[][] arr, int row, int len, boolean[] alreadyChecked){
        boolean isPossible = true;
        int prevHeight = arr[row][0];

        int idx = 1;
        while(idx < arr[0].length){
            int currHeight = arr[row][idx];

            if(currHeight < prevHeight - 1 || currHeight > prevHeight + 1){
                isPossible = false;
                return isPossible;
            }
            // 현재 높이 < 이전 높이 --> 현재부터 오른쪽 len 조사
            else if(currHeight < prevHeight){
                for(int i = idx; i < idx + len; i++){
                    if(i >= arr[0].length || arr[row][i] != currHeight) {
                        isPossible = false;
                        return isPossible;
                    }
                    if(alreadyChecked[i]) {
                        isPossible = false;
                        return isPossible;
                    }
                    alreadyChecked[i] = true;
                }
                prevHeight = currHeight;
                idx += len;     // 다음으로 이동
            }
            // 현재 높이 > 이전 높이 --> 현재 -1부터 왼쪽 len 조사
            else if(currHeight > prevHeight){
                int i = idx - 1;
                while (i >= idx - len) {
                    if(i < 0 || arr[row][i] != prevHeight) {
                        isPossible = false;
                        return isPossible;
                    }
                    if(alreadyChecked[i]) {
                        isPossible = false;
                        return isPossible;
                    }
                    alreadyChecked[i] = true;
                    i--;
                }
                prevHeight = currHeight;
                idx++;          // 다음으로 이동
            }
            // 현재 높이 == 이전 높이 -->
            else{
                idx++;          // 다음으로 이동
            }
        }

        return isPossible;
    }
    public static boolean colCheck(int[][] arr, int col, int len, boolean[] alreadyChecked){
        boolean isPossible = true;
        int prevHeight = arr[0][col];

        int idx = 1;
        while(idx < arr.length){
            int currHeight = arr[idx][col];

            if(currHeight < prevHeight - 1 || currHeight > prevHeight + 1){
                isPossible = false;
                return isPossible;
            }
            // 현재 높이 < 이전 높이 --> 현재부터 오른쪽 len 조사
            else if(currHeight < prevHeight){
                for(int i = idx; i < idx + len; i++){
                    if(i >= arr.length || arr[i][col] != currHeight) {
                        isPossible = false;
                        return isPossible;
                    }
                    if(alreadyChecked[i]) {
                        isPossible = false;
                        return isPossible;
                    }
                    alreadyChecked[i] = true;
                }
                prevHeight = currHeight;
                idx += len;     // 다음으로 이동
            }
            // 현재 높이 > 이전 높이 --> 현재 -1부터 왼쪽 len 조사
            else if(currHeight > prevHeight){
                int i = idx - 1;
                while (i >= idx - len) {
                    if(i < 0 || arr[i][col] != prevHeight) {
                        isPossible = false;
                        return isPossible;
                    }
                    if(alreadyChecked[i]) {
                        isPossible = false;
                        return isPossible;
                    }
                    alreadyChecked[i] = true;
                    i--;
                }
                prevHeight = currHeight;
                idx++;          // 다음으로 이동
            }
            // 현재 높이 == 이전 높이 -->
            else{
                idx++;          // 다음으로 이동
            }
        }

        return isPossible;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int len = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int ans = 0;

        for(int i = 0; i < size; i++) {
//            System.out.println(i + "번째 row");
            if(rowCheck(arr, i, len, new boolean[size])) {
//                System.out.println("통과");
                ans++;
            }
//            System.out.println(i + "번째 col");
            if(colCheck(arr, i, len, new boolean[size])) {
//                System.out.println("통과");
                ans++;
            }
        }

        System.out.println(ans);
    }
}