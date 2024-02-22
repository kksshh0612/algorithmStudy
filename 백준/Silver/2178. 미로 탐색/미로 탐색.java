import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS로 경로 탐색하기 / 최단 거리
public class Main {

    public static int[] dirX = {0, 1, 0, -1};
    public static int[] dirY = {-1, 0, 1, 0};   //복동남서

    public static class Pos{
        int x, y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int BFS(int[][] arr, boolean[][] check){

        int cnt = 0;
        Queue<Pos> queue = new LinkedList<>();

        queue.add(new Pos(0, 0));

        while(!queue.isEmpty()){
            int currTurnSize = queue.size();

            cnt++;

            while(currTurnSize-- > 0){
                Pos currPos = queue.poll();

                if(currPos.x == arr[0].length - 1 && currPos.y == arr.length - 1){
                    return cnt;
                }

                for(int i = 0; i < 4; i++){
                    int nextX = currPos.x + dirX[i];
                    int nextY = currPos.y + dirY[i];

                    if((nextX < 0 || nextX >= arr[0].length) || (nextY < 0 || nextY >= arr.length)) continue;

                    if(check[nextY][nextX]) continue;

                    if(arr[nextY][nextX] == 1){
                        check[nextY][nextX] = true;
                        queue.add(new Pos(nextX, nextY));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[row][col];
        for(int i = 0; i < row; i++){
            String str = bufferedReader.readLine();
            for(int j = 0; j < col; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        boolean[][] check = new boolean[row][col];

        System.out.println(BFS(arr, check));
    }
}