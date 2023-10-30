import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 투 포인터 문제. 현재 시간, 끝 인덱스를 저장하고 그 사이에 있으면 안움직이고, 크면 큰 쪽으로 조금 움직이고..
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int basketSize = Integer.parseInt(stringTokenizer.nextToken());
        int appleNum = Integer.parseInt(bufferedReader.readLine());
        int[] applePos = new int[appleNum];
        for(int i = 0; i < appleNum; i++){
            applePos[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int distance = 0;
        int left = 0, right = basketSize - 1;
        for(int i = 0; i < applePos.length; i++){
            if(applePos[i] < left){
                int currDistance = left - applePos[i];
                left -= currDistance;
                right -= currDistance;
                distance += currDistance;
            }
            else if (applePos[i] > right){
                int currDistance = applePos[i] - right;
                right += currDistance;
                left += currDistance;
                distance += currDistance;
            }
        }

        System.out.println(distance - 1);
    }
}
