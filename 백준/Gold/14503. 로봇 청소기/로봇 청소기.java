import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 벽 1 또는 빈칸 0 청소된거 -1
// 현재 칸 주변 네칸 청소할데 없는 경우, 한칸 후진하고 다시 반복 . 이때, 벽이라 후진 못하면 작동 멈춤
// 현재 칸 주변 네칸 청소할데 있는 경우, 반시계방향으로 90도 회전 (<-) 후, 바라보는 방향 기준 앞 칸이 청소되지 않은 칸이면 다시 반복
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int currY = Integer.parseInt(stringTokenizer.nextToken());
        int currX = Integer.parseInt(stringTokenizer.nextToken());
        int currDir = Integer.parseInt(stringTokenizer.nextToken());
        int[][] room = new int[row][col];
        for(int i = 0; i < row; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < col; j++){
                room[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int ans = 0;

        int[] dirX = {0, 1, 0, -1};     //북 동 남 서 0 1 2 3
        int[] dirY = {-1, 0, 1, 0};     //북 동 남 서

        while(true){
            if(room[currY][currX] == 0){
                room[currY][currX] = 2;    //청소
                ans++;
            }

            boolean zeroExist = false;          //주변 네 칸중에 빈칸이 있는지
            int cnt = 0;

            while(cnt < 4){
                --currDir;      //반시계방향으로 회전하면서 탐색
                if(currDir < 0){
                    currDir = 3;
                }

                int nextX = currX + dirX[currDir];
                int nextY = currY + dirY[currDir];


                if((nextX >= 0 && nextX < col) && (nextY >= 0 && nextY < row)){     // 행렬 범위 체크
                    if(room[nextY][nextX] == 0){
                        zeroExist = true;
                        currX = nextX;
                        currY = nextY;          //다음 칸으로 이동
                        break;
                    }
                }

                cnt++;
            }

            if(!zeroExist){                      // 주변에 닦을데 없으면 한칸 후진 -> 바라보는 방향은 바꾸면 안됨. currDir

                currX += dirX[(currDir + 2) % 4];
                currY += dirY[(currDir + 2) % 4];

                if((currX >= 0 && currX < col) && (currY >= 0 && currY < row)){
                    if(room[currY][currX] == 1) {
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }

}