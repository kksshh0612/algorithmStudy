import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Pool{
        int start;
        int end;

        Pool(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int poolNum = Integer.parseInt(stringTokenizer.nextToken());
        int plankSize = Integer.parseInt(stringTokenizer.nextToken());

        List<Pool> poolList = new ArrayList<>();
        for(int i = 0; i < poolNum; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            poolList.add(new Pool(start, end));
        }

        Collections.sort(poolList, ((o1, o2) -> o1.start - o2.start));

        int currEndPos = 0, cnt = 0;     //현재 널빤지 놓여져있는 끝나는 위치

        for(int i = 0; i < poolList.size(); i++){
            Pool curr = poolList.get(i);
            int currPlankCnt = 0;

            // 현재 웅덩이가 이전 널빤지로 다 덮이는 경우
            if(currEndPos >= curr.end){
                continue;
            }
            else if(curr.start < currEndPos){ //널빤지로 덮고 웅덩이 좀 남을 때
                currPlankCnt = (int)Math.ceil((double)(curr.end - currEndPos) / (double)plankSize);
                currEndPos += currPlankCnt * plankSize;
            }
            else{       //현재 웅덩이 시작점이 이전 널빤지 위치보다 뒤에 있을 때
                currPlankCnt = (int)Math.ceil((double)(curr.end - curr.start) / (double)plankSize);
                currEndPos = curr.start + currPlankCnt * plankSize;
            }
            cnt += currPlankCnt;
        }

        System.out.println(cnt);
    }
}
