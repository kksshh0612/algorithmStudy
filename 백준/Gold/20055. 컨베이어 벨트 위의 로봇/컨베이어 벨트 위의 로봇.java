import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 먼저 올라간 로봇부터 회전 방향으로 한 칸 회전.
// 이동하려 할 때는 내구도 1 이상, 로봇 없어야 함.
// 내구도 0이 k 이상이면 종료. 몇단계 진행중이었는지 출력
//public class Boj20055 {
public class Main {
    public static class Belt{
        boolean robotExist;
        int num;                //내구도

        public Belt(boolean robotExist, int num){
            this.robotExist = robotExist;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int zeroNum = Integer.parseInt(stringTokenizer.nextToken());        //내구도 0인 칸의 갯수
        Belt[] arr = new Belt[size * 2];      //인덱스 0에서 올리고 인덱스 n-1에서 내림

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < size * 2; i++){
            int num = Integer.parseInt(stringTokenizer.nextToken());
            arr[i] = new Belt(false, num);
            if(num == 0){
                zeroNum--;
            }
        }

        int ans = 0;

        int upPos = 0, downPos = size - 1;        //올리는 위치, 내리는 위치
        int firstRobotPos = -1;
        while(zeroNum > 0){

            ans++;

            // 회전
            if(--upPos < 0) upPos = 2 * size - 1;
            if(--downPos < 0) downPos = 2 * size - 1;

            // 회전 후 로봇 내림
            if(arr[downPos].robotExist) arr[downPos].robotExist = false;

            // 로봇 이동
            int idx = downPos - 1;
            if(idx < 0) idx = 2 * size - 1;

            while(idx != downPos){
                if(arr[idx].robotExist) {
                    firstRobotPos = idx;
                    break;
                }

                if(--idx < 0) idx = 2 * size - 1;
            }

            if(firstRobotPos != -1){
                int currPos = firstRobotPos;
                int nextPos = currPos + 1;
                if(nextPos >= 2 * size) nextPos = 0;
                boolean prevRobotExist = arr[nextPos].robotExist;       // 현재 올려진 로봇 중 첫번째로 올려진 로봇이 이동할 위치에 로봇이 있었는지 없었는지
                for(int i = 0; i < size * 2; i++){
                    if(currPos + 1 >= 2 * size) nextPos = 0;
                    else nextPos = currPos + 1;
                    
                    if(i == size * 2 - 1 && !prevRobotExist){
                        continue;
                    }

                    if(arr[currPos].robotExist && (!arr[nextPos].robotExist && arr[nextPos].num > 0)){
                        arr[nextPos].robotExist = true;
                        arr[nextPos].num--;
                        arr[currPos].robotExist = false;

                        if(arr[nextPos].num == 0) zeroNum--;
                    }

                    if(--currPos < 0) currPos = 2 * size - 1;
                }
            }

            // 로봇 이동 후 로봇 내림
            if(arr[downPos].robotExist) arr[downPos].robotExist = false;

            // 로봇 올림
            if(arr[upPos].num > 0 && !arr[upPos].robotExist){
                arr[upPos].num--;
                arr[upPos].robotExist = true;

                if(arr[upPos].num == 0) zeroNum--;
            }
        }

        System.out.println(ans);
    }
}