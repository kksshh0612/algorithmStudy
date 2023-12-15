import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS로 구하기
public class Main {

    public static int[] dirX = {0, 1, 0, -1};
    public static int[] dirY = {-1, 0, 1, 0};
    public static int max;
    public static int localCnt;

    public static void DFS(int[][] arr, boolean[][] check, int currX, int currY){

        for(int i = 0; i < 4; i++){
            int nextX = currX + dirX[i];
            int nextY = currY + dirY[i];

            if((nextX < 0 || nextX >= arr[0].length) || (nextY < 0 || nextY >= arr.length)) continue;

            if(check[nextY][nextX]) continue;

            if(arr[nextY][nextX] == 1){
                localCnt++;
                check[nextY][nextX] = true;
                DFS(arr, check, nextX, nextY);
//                check[nextY][nextX] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int trashNum = Integer.parseInt(stringTokenizer.nextToken());

        int[][] arr = new int[row][col];

        for(int i = 0; i < trashNum; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int rowNum = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int colNum = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            arr[rowNum][colNum] = 1;
        }

        boolean[][] check = new boolean[row][col];
        max = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(arr[i][j] == 1 && !check[i][j]){
                    localCnt = 1;
                    check[i][j] = true;
                    DFS(arr, check, j, i);

                    max = Math.max(max, localCnt);
                }
            }
        }




        System.out.println(max);
    }
}