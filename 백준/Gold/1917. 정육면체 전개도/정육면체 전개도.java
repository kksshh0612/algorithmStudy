import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 6행씩 자르기.
// 1이 어디에 있는지 확인하기
public class Main {

    public static int[] dirX = {0, 1, 0, -1};
    public static int[] dirY = {-1, 0, 1, 0};
    public static Map<Integer, Integer> oppositeMap = new HashMap<Integer, Integer>();

    public static class Cube{
        int row, col, num;                  // 현재 위치, 숫자
        int north, east, south, west;       // 현재 면에 북동남서 연결된 면 숫자

        public Cube(int row, int col, int num, int north, int east, int south, int west) {
            this.row = row;
            this.col = col;
            this.num = num;
            this.north = north;
            this.east = east;
            this.south = south;
            this.west = west;
        }
    }

    public static void DFS(Cube cube, int[][] arr, boolean[][] check, int cnt){
        if(cnt == 6){
            return;
        }
        else{
            for(int i = 0; i < 4; i++){
                int nextX = cube.col + dirX[i];
                int nextY = cube.row + dirY[i];

                if((nextX < 0 || nextX >= 6) || (nextY < 0 || nextY >= 6)) continue;
                if(arr[nextY][nextX] == 0) continue;
                if(check[nextY][nextX]) continue;

                Cube nextCube = null;
                switch (i){
                    case 0:
                        nextCube = new Cube(nextY, nextX, cube.north, oppositeMap.get(cube.num), cube.east, cube.num, cube.west);
                        break;
                    case 1:
                        nextCube = new Cube(nextY, nextX, cube.east, cube.north, oppositeMap.get(cube.num), cube.south, cube.num);
                        break;
                    case 2:
                        nextCube = new Cube(nextY, nextX, cube.south, cube.num, cube.east, oppositeMap.get(cube.num), cube.west);
                        break;
                    case 3:
                        nextCube = new Cube(nextY, nextX, cube.west, cube.north, cube.num, cube.south, oppositeMap.get(cube.num));
                        break;
                }
                check[nextY][nextX] = true;
                arr[nextY][nextX] = nextCube.num;
                DFS(nextCube, arr, check, cnt + 1);
            }
        }
    }

    public static boolean isAns(int[][] arr){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(arr[i][j] == 0) continue;

                set.add(arr[i][j]);
            }
        }

        if(set.size() == 6) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[6][6];
        oppositeMap.put(1, 6);
        oppositeMap.put(6, 1);
        oppositeMap.put(3, 5);
        oppositeMap.put(5, 3);
        oppositeMap.put(2, 4);
        oppositeMap.put(4, 2);

        for(int i = 0; i < 3; i++){

            int startRow = 0, startCol = 0;

            for(int row = 0; row < 6; row++){
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int col = 0; col < 6; col++){
                    arr[row][col] = Integer.parseInt(stringTokenizer.nextToken());
                    if(arr[row][col] == 1){
                        startRow = row;
                        startCol = col;
                    }
                }
            }

            boolean[][] check = new boolean[6][6];

            check[startRow][startCol] = true;
            arr[startRow][startCol] = 1;
            Cube cube = new Cube(startRow, startCol, 1, 2, 3, 4, 5);

            DFS(cube, arr, check, 1);

            if(isAns(arr)) System.out.println("yes");
            else System.out.println("no");
        }
    }
}