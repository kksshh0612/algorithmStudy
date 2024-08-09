import java.util.*;

// 끝방까지 가면서 거치는 검은색 수의 최솟값 구하기 0 검 1 흰
public class Main {

    public static int[] dirRow = {-1, 0, 1, 0};
    public static int[] dirCol = {0, 1, 0, -1};

    public static class Pos{
        int row, col;

        public Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void bfs(char[][] arr, int[][] cntArr){
        Queue<Pos> queue = new LinkedList<>();

        Pos startPos = new Pos(0, 0);
        queue.add(startPos);
        cntArr[0][0] = 0;

        while(!queue.isEmpty()){
            Pos curr = queue.poll();
            for(int i = 0; i < 4; i++){
                int nextRow = curr.row + dirRow[i];
                int nextCol = curr.col + dirCol[i];

                if((nextRow < 0 || nextRow >= arr.length) || (nextCol < 0 || nextCol >= arr[0].length)) continue;

                if(arr[nextRow][nextCol] == '0'){       //검은색
                    if(cntArr[curr.row][curr.col] + 1 < cntArr[nextRow][nextCol]){
                        cntArr[nextRow][nextCol] = cntArr[curr.row][curr.col] + 1;
                        queue.add(new Pos(nextRow, nextCol));
                    }
                }
                else{
                    if(cntArr[curr.row][curr.col] < cntArr[nextRow][nextCol]){
                        cntArr[nextRow][nextCol] = cntArr[curr.row][curr.col];
                        queue.add(new Pos(nextRow, nextCol));
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        char[][] arr = new char[size][size];
        int[][] cntArr = new int[size][size];
        for(int i = 0; i < size; i++){
            String str = sc.next();
            for(int j = 0; j < size; j++){
                arr[i][j] = str.charAt(j);
            }
            Arrays.fill(cntArr[i], Integer.MAX_VALUE);
        }

        bfs(arr, cntArr);

        System.out.println(cntArr[size - 1][size - 1]);
    }
}