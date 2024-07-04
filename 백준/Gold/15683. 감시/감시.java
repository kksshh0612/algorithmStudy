import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 1~5 : CCTV   6 : 벽
// CCTV 회전시킬 수 있고, 사각지대 최소화하도록 CCTV 회전 시키기
public class Main {

    public static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dirX = {0, 1, 0, -1};       // 북 남 동 서
    public static int[] dirY = {-1, 0, 1, 0};       // 북 남 동 서

    public static int ans;

    public static void dfs(int[][] arr, List<Pos> posList, int idx){

        // 모든 CCTV 위치의 방향이 확정되면
        if(idx == posList.size()){
            int cnt = 0;
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr[0].length; j++){

                    if(arr[i][j] == 0){         // 사각지대 갯수 확인
                        cnt++;
                    }
                }
            }

            ans = Math.min(ans, cnt);
            return;
        }

        Pos currPos = posList.get(idx);
        int[][] copyArr = new int[arr.length][arr[0].length];
        // 북남동서
        for(int i = 0; i < 4; i++){

            // 직전 상태 저장
            for(int t = 0; t < copyArr.length; t++) {
                for (int j = 0; j < copyArr[0].length; j++) {
                    copyArr[t][j] = arr[t][j];
                }
            }

            switch (arr[currPos.y][currPos.x]){
                case 1:
                    check(arr, currPos.x, currPos.y, i);
                    break;
                case 2:
                    check(arr, currPos.x, currPos.y, i);
                    check(arr, currPos.x, currPos.y, (i + 2) % 4);
                    break;
                case 3:
                    check(arr, currPos.x, currPos.y, i);
                    check(arr, currPos.x, currPos.y, (i + 1) % 4);
                    break;
                case 4:
                    check(arr, currPos.x, currPos.y, i);
                    check(arr, currPos.x, currPos.y, (i + 1) % 4);
                    check(arr, currPos.x, currPos.y, (i + 3) % 4);
                    break;
                case 5:
                    check(arr, currPos.x, currPos.y, i);
                    check(arr, currPos.x, currPos.y, (i + 1) % 4);
                    check(arr, currPos.x, currPos.y, (i + 2) % 4);
                    check(arr, currPos.x, currPos.y, (i + 3) % 4);
                    break;
            }
            dfs(arr, posList, idx + 1);

            // 초기화
            for(int t = 0; t < copyArr.length; t++) {
                for (int j = 0; j < copyArr[0].length; j++) {
                    arr[t][j] = copyArr[t][j];
                }
            }
        }
    }

    // 정해진 방향대로 CCTV 시야를 세팅
    public static void check(int[][] arr,int x, int y, int dir){

        while(true){
            x = x + dirX[dir];
            y = y + dirY[dir];

            if((x < 0 || x >= arr[0].length) || (y < 0 || y >= arr.length)) break;

            if(arr[y][x] == 0) arr[y][x] = -1;
            if(arr[y][x] == 6) break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());

        int[][] arr = new int[row][col];
        List<Pos> posList = new ArrayList<>();

        for(int i = 0; i < row; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < col; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(arr[i][j] >= 1 && arr[i][j] <= 5) posList.add(new Pos(j, i));
            }
        }

        ans = Integer.MAX_VALUE;

        dfs(arr, posList, 0);

        System.out.println(ans);
    }
}