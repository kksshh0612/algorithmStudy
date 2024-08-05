import java.util.*;
import java.io.*;

// 토마토가 다 익는 최소 일 수  1: 익음  0: 안익음  -1: 없음
public class Main{

    public static int col, row, height;
    public static int[] dirRow = {-1, 0, 1, 0, 0, 0};       // 북동남서위아래
    public static int[] dirCol = {0, 1, 0, -1, 0, 0};
    public static int[] dirHeight = {0, 0, 0, 0, 1, -1};

    public static class Pos{
        int height, row, col;

        public Pos(int h, int r, int c){
            this.height = h;
            this.row = r;
            this.col = c;
        }
    }

    public static void spread(int[][][] arr, Queue<Pos> queue){

        while(!queue.isEmpty()){
            Pos pos = queue.poll();

            for(int i = 0; i < 6; i++){
                int nextHeight = pos.height + dirHeight[i];
                int nextRow = pos.row + dirRow[i];
                int nextCol = pos.col + dirCol[i];

                if((nextHeight < 0 || nextHeight >= height)
                        || (nextRow < 0 || nextRow >= row) || (nextCol < 0 || nextCol >= col)) continue;

                if(arr[nextHeight][nextRow][nextCol] != 0) continue;

                arr[nextHeight][nextRow][nextCol] = arr[pos.height][pos.row][pos.col] + 1;
                queue.add(new Pos(nextHeight, nextRow, nextCol));
            }
        }
    }

    public static int complete(int[][][] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < row; j++){
                for(int k = 0; k < col; k++){
                    if(arr[i][j][k] == 0) return Integer.MIN_VALUE;
                    max = Math.max(arr[i][j][k], max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[height][row][col];
        Queue<Pos> queue = new LinkedList<>();

        for(int i = 0; i < height; i++){
            for(int j = 0; j < row; j++){
                st = new StringTokenizer(bf.readLine());
                for(int k = 0; k < col; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1){
                        queue.add(new Pos(i, j, k));
                    }
                }
            }
        }

        spread(arr, queue);
        int day = complete(arr);

        if(day == Integer.MIN_VALUE) day = -1;
        else day--;
        System.out.println(day);

    }
}