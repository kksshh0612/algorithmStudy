import java.util.Scanner;

public class Main {

    public static int[] dirX = {0, 1, 0, -1};
    public static int[] dirY = {-1, 0, 1, 0};
    public static int cnt;

    public static void DFS(char[][] arr, boolean[][] check,
                           int currLen, int totalLen, int currX, int currY){
        if(currLen >= totalLen){
            if(currX == arr[0].length - 1 && currY == 0) cnt++;
        }
        else{
            for(int i = 0; i < 4; i++){
                int nextX = currX + dirX[i];
                int nextY = currY + dirY[i];

                if((nextX < 0 || nextX >= arr[0].length) || (nextY < 0 || nextY >= arr.length)) continue;

                if(check[nextY][nextX]) continue;

                if(arr[nextY][nextX] == 'T') continue;

                check[nextY][nextX] = true;
                DFS(arr, check, currLen + 1, totalLen, nextX, nextY);
                check[nextY][nextX] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int totalLen = scanner.nextInt();
        char[][] arr = new char[row][col];
        for(int i = 0; i < row; i++){
            String str = scanner.next();
            for(int j = 0; j < col; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        boolean[][] check = new boolean[row][col];
        cnt = 0;
        check[row - 1][0] = true;

        DFS(arr, check, 1, totalLen, 0, row - 1);

        System.out.println(cnt);
    }
}