import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 대각선까지 이동 가능. 현재 위치에서 1까지 최대 거리
public class Main {

    // 시계방향
    public static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int max;

    public static class Pos{
        int x, y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int[][] arr, boolean[][] check, Queue<Pos> queue){
        int level = -1;

        while(!queue.isEmpty()){

            level++;

            int currTurnSize = queue.size();

            while(currTurnSize-- > 0){
                Pos curr = queue.poll();

                for(int i = 0; i < 8; i++){
                    int nextX = curr.x + dirX[i];
                    int nextY = curr.y + dirY[i];

                    if((nextX < 0 || nextX >= arr[0].length) || (nextY < 0 || nextY >= arr.length)){
                        continue;
                    }

                    if(arr[nextY][nextX] == 1){
                        max = Math.max(max, level + 1);
                        return;
                    }

                    if(arr[nextY][nextX] == 0 && !check[nextY][nextX]){
                        check[nextY][nextX] = true;
                        queue.add(new Pos(nextX, nextY));
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] arr = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        max = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(arr[i][j] == 0){
                    Queue<Pos> queue = new LinkedList<>();
                    boolean[][] check = new boolean[row][col];
                    check[i][j] = true;
                    queue.add(new Pos(j, i));

                    BFS(arr, check, queue);
                }
            }
        }

        System.out.println(max);
    }
}