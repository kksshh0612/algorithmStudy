import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 왼쪽 아래 xy, 오른쪽 위 xy
// 직사각형 구역 1로 표시하고 DFS
//public class Boj2583 {
public class Main {
    
    public static int[] dirX = {0, 1, 0, -1};     //북동남서
    public static int[] dirY = {-1, 0, 1, 0};
    public static int areaCnt;
    public static int cnt;

    public static int[][] blockSetting(int[][] arr, int x, int y, int xLen, int yLen){
        for(int i = y; i < y + yLen; i++){
            for(int j = x; j < x + xLen; j++){
                arr[i][j] = 1;
            }
        }
        return arr;
    }

    public static void DFS(int[][] arr, boolean[][] check, int currX, int currY, int xSize, int ySize){
        cnt++;
        arr[currY][currX] = 1;
        check[currY][currX] = true;

        for(int i = 0; i < 4; i++){
            int nextX = currX + dirX[i];
            int nextY = currY + dirY[i];
            if(nextX >= 0 && nextX < xSize && nextY >= 0 && nextY < ySize){
                if(arr[nextY][nextX] == 0 && !check[nextY][nextX]){
                    DFS(arr, check, nextX, nextY, xSize, ySize);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int block = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[row][col];
        for(int i = 0; i < block; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int startX = Integer.parseInt(stringTokenizer.nextToken());
            int startY = Integer.parseInt(stringTokenizer.nextToken());
            int endX = Integer.parseInt(stringTokenizer.nextToken());
            int endY = Integer.parseInt(stringTokenizer.nextToken());
            blockSetting(arr, startX, startY, endX - startX, endY - startY);
        }
        boolean[][] check = new boolean[row][col];
        List<Integer> ans = new ArrayList<>();
        areaCnt = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(arr[i][j] == 0){
                    cnt = 0;
                    DFS(arr, check, j, i, col, row);
                    ans.add(cnt);
                    areaCnt++;
                }
            }
        }
        Collections.sort(ans);
        System.out.println(areaCnt);
        for(Integer num : ans){
            System.out.print(num + " ");
        }
    }
}