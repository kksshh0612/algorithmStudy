import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//public class Boj1987 {
public class Main {
    public static int[] dirX = {0, 1, 0, -1};     //행렬에서 열.   북동남서
    public static int[] dirY = {-1, 0, 1, 0};     //행렬에서 행.   북동남서
    public static int max;

    public static void DFS(char[][] arr, boolean[][] isVisited, int currX, int currY, List<Character> alpha){

        isVisited[currY][currX] = true;
        alpha.add(arr[currY][currX]);

        if(max < alpha.size()){
            max = alpha.size();
        }

        for(int i = 0; i < 4; i++){
            int nextY = currY + dirY[i];
            int nextX = currX + dirX[i];

//            System.out.println("nextY : " + nextY + " nextX : " + nextX);

            if((nextX >= 0 && nextX < arr[0].length) && (nextY >= 0 && nextY < arr.length)){
                if(!isVisited[nextY][nextX] && !alpha.contains(arr[nextY][nextX])){
//                    System.out.println("들어와서 nextY : " + nextY + " nextX : " + nextX);
//
//                    System.out.println(arr[nextY][nextX]);

                    DFS(arr, isVisited, nextX, nextY, alpha);
                    isVisited[nextY][nextX] = false;

//                    System.out.println("빠질때 : " + arr[nextY][nextX]);
                    alpha.remove(Character.valueOf(arr[nextY][nextX]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        char[][] arr = new char[row][col];
        boolean[][] isVisited = new boolean[row][col];

        for(int i = 0; i < row; i++){
            String row1 = scanner.next();
            for(int j = 0; j < col; j++){
                arr[i][j] = row1.charAt(j);
            }
        }

        List<Character> alpha = new ArrayList<>();
        max = Integer.MIN_VALUE;

        DFS(arr, isVisited, 0, 0, alpha);

        System.out.println(max);
    }
}