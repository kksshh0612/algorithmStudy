import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class Boj2503 {
public class Main {
    public static int cnt;

    public static void DFS(int[][] arr, int currNumSize, int currNum, boolean[] isUsed){
        if(currNumSize == 3){
//            System.out.println(currNum);
            boolean isRightCase = true;
            for(int i = 0; i < arr.length; i++){
                int num = arr[i][0];
                int strike = arr[i][1], currStrike = 0;
                int ball = arr[i][2], currBall = 0;

                int currNumCopy = currNum;             //DFS로 만들어진 수
                // 일의자리부터 탐색
                for(int j = 0; j < 3; j++){
                    int curr = currNumCopy % 10;
                    int numCopy = num;          //민혁이 말했던 수
                    for(int t = 0; t < 3; t++){
                        int currCompareNum = numCopy % 10;
                        if(curr == currCompareNum && j == t){   //숫자도 같고 자릿수도 같으면
                            currStrike++;
                            break;
                        }
                        else if(curr == currCompareNum && j != t){        //숫자는 같은데 자릿수는 다르면
                            currBall++;
                            break;
                        }
                        numCopy /= 10;
                    }
                    currNumCopy /= 10;
                }
//                System.out.println(strike + " " + currStrike + " " + ball + " " + currBall);
                if(strike != currStrike || ball != currBall) {
                    isRightCase = false;
                    break;
                }
            }
            if(isRightCase) cnt++;
        }
        else{
            for(int i = 1; i <= 9; i++){
                if(!isUsed[i]){
                    isUsed[i] = true;
                    DFS(arr,  currNumSize + 1, currNum * 10 + i, isUsed);
                    isUsed[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            arr[i][0] = Integer.parseInt(stringTokenizer.nextToken());          //숫자
            arr[i][1] = Integer.parseInt(stringTokenizer.nextToken());          //strike
            arr[i][2] = Integer.parseInt(stringTokenizer.nextToken());          //ball
        }
        boolean[] isUsed = new boolean[10];
        cnt = 0;
        DFS(arr, 0, 0, isUsed);

        System.out.println(cnt);
    }
}
