import java.util.*;
import java.io.*;
// 부순 벽 수( 1의 카운트 수 ) 작으면 그쪽으로 이동 (다익스트라)
public class Main {

    public static int rowSize, colSize;
    public static int[][] arr;
    public static int[] dirRow = {0, 1, -1, 0};
    public static int[] dirCol = {1, 0, 0, -1};

    public static class Pos{
        int row, col, val;
        public Pos(int r, int c, int val){
            this.row = r;
            this.col = c;
            this.val = val;
        }
    }

    public static int djikstra(){
        boolean[][] check = new boolean[rowSize][colSize];
        int[][] ansArr = new int[rowSize][colSize];
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                ansArr[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pos> queue = new PriorityQueue<>(new Comparator<Pos>(){
            @Override
            public int compare(Pos o1, Pos o2){
                return o1.val - o2.val;
            }
        });
        queue.add(new Pos(0, 0, 0));
        ansArr[0][0] = 0;

        while(!queue.isEmpty()){
            Pos curr = queue.poll();

            check[curr.row][curr.col] = true;

            for(int i = 0; i < 4; i++){
                int nextRow = curr.row + dirRow[i];
                int nextCol = curr.col + dirCol[i];

                if((nextRow < 0 || nextRow >= rowSize) || (nextCol < 0 || nextCol >= colSize)) continue;
                if(check[nextRow][nextCol]) continue;

                if(arr[nextRow][nextCol] == 0 && ansArr[curr.row][curr.col] < ansArr[nextRow][nextCol]){
                    ansArr[nextRow][nextCol] = ansArr[curr.row][curr.col];
                    queue.add(new Pos(nextRow, nextCol, ansArr[nextRow][nextCol]));
                }
                else if(arr[nextRow][nextCol] == 1 && ansArr[curr.row][curr.col] + 1 < ansArr[nextRow][nextCol]){
                    ansArr[nextRow][nextCol] = ansArr[curr.row][curr.col] + 1;
                    queue.add(new Pos(nextRow, nextCol, ansArr[nextRow][nextCol]));
                }
            }
        }

//        for(int i = 0; i < rowSize; i++){
//            for(int j = 0; j < colSize; j++){
//                System.out.print(ansArr[i][j] + " ");
//            }
//            System.out.println();
//        }

        return ansArr[rowSize - 1][colSize - 1];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        colSize = Integer.parseInt(st.nextToken());
        rowSize = Integer.parseInt(st.nextToken());
        arr = new int[rowSize][colSize];
        for(int i = 0; i < rowSize; i++){
            String line = bf.readLine();
            for(int j = 0; j < colSize; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int ans = djikstra();



        System.out.println(ans);
    }
}