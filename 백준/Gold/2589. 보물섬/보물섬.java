import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int[] dirX = {0, 1, 0, -1};
    public static int[] dirY = {-1, 0, 1, 0};
    public static int max;

    public static class Pos{
        int x, y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(char[][] arr, Queue<Pos> queue, boolean[][] check){

        int currLevel = -1;

        while(!queue.isEmpty()){
            int currTurnSize = queue.size();

            while(currTurnSize-- > 0){
                Pos currPos = queue.poll();

                for(int i = 0; i < 4; i++){
                    int nextX = currPos.x + dirX[i];
                    int nextY = currPos.y + dirY[i];

                    if((nextX < 0 || nextX >= arr[0].length) || (nextY < 0 || nextY >= arr.length)) continue;

                    if(check[nextY][nextX]) continue;

                    if(arr[nextY][nextX] == 'L'){
                        check[nextY][nextX] = true;
                        queue.add(new Pos(nextX, nextY));
                    }

                }
            }
            currLevel++;
        }

        max = Math.max(max, currLevel);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        char[][] arr = new char[row][col];
        for(int i = 0; i < row; i++){
            String str = scanner.next();
            for(int j = 0; j < col; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        max = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(arr[i][j] == 'L'){
                    Queue<Pos> queue = new LinkedList<>();
                    boolean[][] check = new boolean[row][col];
                    check[i][j] = true;
                    queue.add(new Pos(j, i));

                    BFS(arr, queue, check);
                }
            }
        }

        System.out.println(max);
    }
}