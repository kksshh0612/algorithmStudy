import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// R, G, B 수      (R - G), B 수 -> R을 G로 바꾸기
//public class Boj10026 {
public class Main {
    public static int[] dirX = {0, 1, 0, -1};     //행렬에서 열.   북동남서
    public static int[] dirY = {-1, 0, 1, 0};     //행렬에서 행.   북동남서

    public static void DFS(boolean[][] visited, char[][] rgb, int xPos, int yPos, int size){
        visited[yPos][xPos] = true;
        char curr = rgb[yPos][xPos];

        for(int i = 0; i < 4; i++){
            int nextX = xPos + dirX[i];
            int nextY = yPos + dirY[i];
            if((nextX >= 0 && nextX < size) && (nextY >= 0 && nextY < size)){   //범위 안에 있고
                if(!visited[nextY][nextX] && (rgb[nextY][nextX] == curr)){        //다음 탐색하는 것이 현재와 같은 문자이면
                    DFS(visited, rgb, nextX, nextY, size);    //다음으로 이동
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        char[][] rgbGeneral = new char[size][size];
        char[][] rgbNotGeneral = new char[size][size];
        for(int i = 0; i < size; i++){
            String token = bufferedReader.readLine();
            for(int j = 0; j < size; j++){
                rgbGeneral[i][j] = token.charAt(j);
                if(token.charAt(j) == 'R'){             //R을 G로 바꿔서 저장
                    rgbNotGeneral[i][j] = 'G';
                }
                else{
                    rgbNotGeneral[i][j] = token.charAt(j);
                }

            }
        }
        int general = 0;          //정상
        int notGeneral = 0;       //정록색약

        boolean[][] visited = new boolean[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(!visited[i][j]){
                    DFS(visited, rgbGeneral, j, i, size);       //정상인
                    general++;      //묶음 수 + 1
                }
            }
        }

        for(int i = 0; i < size; i++){              //visited 초기화
            for(int j = 0; j < size; j++){
                visited[i][j] = false;
            }
        }

//        for(int k = 0; k < size; k++){
//            for(int t = 0; t < size; t++){
//                System.out.print(rgbNotGeneral[k][t]);
//            }
//            System.out.println();
//        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(!visited[i][j]){
                    DFS(visited, rgbNotGeneral, j, i, size);       //정상인
                    notGeneral++;      //묶음 수 + 1
                }
            }
        }

        System.out.println(general + " " + notGeneral);
    }
}