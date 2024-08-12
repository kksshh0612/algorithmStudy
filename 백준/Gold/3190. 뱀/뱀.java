import java.util.*;
import java.io.*;

// 처음에 오른쪽 향함.
// 자기자신 or 벽 만나면 끝
// 머리를 1 늘려 이동하고 사과 있으면 꼬리 그대로. 없으면 꼬리 이동
public class Main {

    public static class ChangeInfo{
        int time;
        String dir;

        public ChangeInfo(int time, String dir){
            this.time = time;
            this.dir = dir;
        }
    }

    public static class Tail{
        int row, col;

        public Tail(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());
        int appleCnt = Integer.parseInt(bf.readLine());
        int[][] arr = new int[size][size];          // 1 : 뱀 / -1 : 사과
        for(int i = 0; i < appleCnt; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            arr[row][col] = -1;
        }
        arr[0][0] = 1;

        int changeDirCnt = Integer.parseInt(bf.readLine());
        ChangeInfo[] changeInfoArr = new ChangeInfo[changeDirCnt];
        for(int i = 0; i < changeDirCnt; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            changeInfoArr[i] = new ChangeInfo(time, dir);
        }

        int[] dirRow = {0, -1, 0, 1};
        int[] dirCol = {1, 0, -1, 0};

        // 시작
        int currTime = 0, idx = 0, dir = 0;
        int currRow = 0, currCol = 0;
        Queue<Tail> tailQueue = new LinkedList<>();        //뱀 몸통에서 코너 꺾이는 부분 정보
        tailQueue.add(new Tail(0, 0));

        while(true){

            // 방향 바꿀 시점이면 방향 바꿈
            if(idx < changeDirCnt && currTime == changeInfoArr[idx].time){
                if(changeInfoArr[idx].dir.equals("L")){
                    dir = (dir + 1) % 4;
                }
                else{
                    dir = (dir - 1 == -1) ? 3 : dir - 1;
                }
                idx++;
            }
            currRow += dirRow[dir];
            currCol += dirCol[dir];

            // 벽에 닿거나 자기 자신에 닿으면
            if((currRow < 0 || currRow >= size) || (currCol < 0 || currCol >= size)
                    || (arr[currRow][currCol] == 1)) break;


            if(arr[currRow][currCol] != -1){        // 사과 없으면 꼬리 이동
                Tail tail = tailQueue.poll();
                arr[tail.row][tail.col] = 0;        // 꼬리 없앰
            }

            tailQueue.add(new Tail(currRow, currCol));
            arr[currRow][currCol] = 1;

            currTime++;
        }

        System.out.println(currTime + 1);
    }
}