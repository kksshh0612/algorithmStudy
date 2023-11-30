import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 안전 영역의 최댓값 구하기. -> 높이 100까지
public class Main {

    public static int maxSafeArea = 1;
    //북동남서
    public static int[] dirX = {0, 1, 0, -1};
    public static int[] dirY = {-1, 0, 1, 0};

    public static class Pos{
        int x, y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int[][] arr, boolean[][] check, int currHeight, Pos currPos){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(currPos);

        while(!queue.isEmpty()){
            Pos curr = queue.poll();

            for(int i = 0; i < 4; i++){
                int nextX = curr.x + dirX[i];
                int nextY = curr.y + dirY[i];
                if((nextX >= 0 && nextX < arr.length) && (nextY >= 0 && nextY < arr.length)){
                    if(!check[nextY][nextX] && arr[nextY][nextX] > currHeight){
                        check[nextY][nextX] = true;
                        queue.add(new Pos(nextX, nextY));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[n][n];
        int maxHeight = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                maxHeight = Math.max(arr[i][j], maxHeight);
            }
        }
        boolean[][] check = new boolean[n][n];

        int currRainHeight = 0;

        while(currRainHeight++ <= maxHeight){
            int currCnt = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(!check[i][j] && arr[i][j] > currRainHeight){     //현재 지역이 안전하면 탐색 시작
                        BFS(arr, check, currRainHeight, new Pos(j, i));
                        currCnt++;
                    }
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    check[i][j] = false;
                }
            }
            maxSafeArea = Math.max(currCnt, maxSafeArea);
        }

        System.out.println(maxSafeArea);

    }
}
