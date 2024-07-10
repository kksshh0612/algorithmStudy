import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1: 상하 반전   2: 좌우 반전
// 3: 오른쪽 90도 회전   4: 왼쪽 90도 회전
// 5: 4개 그룹 오른쪽 회전   6: 4개 그룹 왼쪽 회전
public class Main {

    public static void one(int[][] arr, int row, int col){
        int[][] copy = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                copy[row - i - 1][j] = arr[i][j];
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                arr[i][j] = copy[i][j];
            }
        }
    }

    public static void two(int[][] arr, int row, int col){
        int[][] copy = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                copy[i][col - j - 1] = arr[i][j];
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                arr[i][j] = copy[i][j];
            }
        }
    }

    public static int[][] three(int[][] arr, int row, int col){
        int[][] copy = new int[col][row];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                copy[j][row - i - 1] = arr[i][j];
            }
        }

        return copy;
    }

    public static int[][] four(int[][] arr, int row, int col){
        int[][] copy = new int[col][row];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                copy[col - j - 1][i] = arr[i][j];
            }
        }

        return copy;
    }

    public static void five(int[][] arr, int row, int col){
        int[][] copy = new int[row][col];

        for(int i = 0; i < row / 2; i++){
            for(int j = 0; j < col / 2; j++){
                copy[i][col / 2 + j] = arr[i][j];
            }
        }
        for(int i = 0; i < row / 2; i++){
            for(int j = col / 2; j < col; j++){
                copy[row / 2 + i][j] = arr[i][j];
            }
        }
        for(int i = row / 2; i < row; i++){
            for(int j = col / 2; j < col; j++){
                copy[i][j - col / 2] = arr[i][j];
            }
        }
        for(int i = row / 2; i < row; i++){
            for(int j = 0; j < col / 2; j++){
                copy[i - row / 2][j] = arr[i][j];
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                arr[i][j] = copy[i][j];
            }
        }
    }

    public static void six(int[][] arr, int row, int col){
        int[][] copy = new int[row][col];

        for(int i = 0; i < row / 2; i++){
            for(int j = col / 2; j < col; j++){
                copy[i][j - col / 2] = arr[i][j];
            }
        }
        for(int i = 0; i < row / 2; i++){
            for(int j = 0; j < col / 2; j++){
                copy[row / 2 + i][j] = arr[i][j];
            }
        }
        for(int i = row / 2; i < row; i++){
            for(int j = 0; j < col / 2; j++){
                copy[i][col / 2 + j] = arr[i][j];
            }
        }
        for(int i = row / 2; i < row; i++){
            for(int j = col / 2; j < col; j++){
                copy[i - row / 2][j] = arr[i][j];
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                arr[i][j] = copy[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int tCase = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[row][col];
        for(int i = 0; i < row; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < col; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int[] caseArr = new int[tCase];
        stringTokenizer =  new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < tCase; i++){
            caseArr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int idx = 0;
//        int[][] newArr;
        while(idx < tCase){
            switch (caseArr[idx++]){
                case 1:{
                    one(arr, row, col);
                    break;
                }
                case 2:{
                    two(arr, row, col);
                    break;
                }
                case 3:{
                    arr = three(arr, row, col);
                    row = arr.length;
                    col = arr[0].length;
                    break;
                }
                case 4:{
                    arr = four(arr, row, col);
                    row = arr.length;
                    col = arr[0].length;
                    break;
                }
                case 5:{
                    five(arr, row, col);
                    break;
                }
                case 6:{
                    six(arr, row, col);
                    break;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                stringBuilder.append(arr[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
}