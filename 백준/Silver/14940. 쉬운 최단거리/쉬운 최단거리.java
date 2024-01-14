import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 0 : 갈 수 없는 땅   1 : 갈 수 있는 땅   2 : 목표 지점
// 2부터 시작해서 동서남북 탐색하면서 모든 땅 탐색하면서 현재 위치 + 1
//public class Boj14940 {
public class Main{

    public static class Pos{
        int x, y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dirX = {0, 1, 0, -1};       //북동남서
    public static int[] dirY = {-1, 0, 1, 0};

    public static void BFS(Queue<Pos> queue, int[][] arr, int[][] ans, boolean[][] check){

        while(!queue.isEmpty()){

            Pos currPos = queue.poll();

            for(int i = 0; i < 4; i++){
                int nextX = currPos.x + dirX[i];
                int nextY = currPos.y + dirY[i];

                if((nextX < 0 || nextX >= arr[0].length) || (nextY < 0 || nextY >= arr.length)) continue;

                if(arr[nextY][nextX] == 1 && !check[nextY][nextX]){
                    ans[nextY][nextX] = ans[currPos.y][currPos.x] + 1;
                    check[nextY][nextX] = true;
                    queue.add(new Pos(nextX, nextY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[row][col];
        int[][] ans = new int[row][col];
        boolean[][] check = new boolean[row][col];

        Pos startPos = null;

        for(int i = 0; i < row; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < col; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());

                if(arr[i][j] == 2) startPos = new Pos(j, i);
            }
        }

        Queue<Pos> queue = new LinkedList<>();
        queue.add(startPos);
        ans[startPos.y][startPos.x] = 0;
        check[startPos.y][startPos.x] = true;

        BFS(queue, arr, ans, check);

        // 갈 수 없는 땅 처리
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(arr[i][j] != 0 && !check[i][j]) ans[i][j] = -1;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                stringBuilder.append(ans[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}