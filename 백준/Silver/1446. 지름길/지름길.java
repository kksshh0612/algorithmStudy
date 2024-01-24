import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 배열 세팅하면서, 한번 지름길 탐색 할 때, 도착지 값을 갱신해줌.
// (최종 지점 - 지름길 종료 지점) + dp[지름길 종료 지점]
//public class Boj1446 {
public class Main {
    public static class Road{
        int start, end, value;

        public Road(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int roadSize = Integer.parseInt(stringTokenizer.nextToken());
        int total = Integer.parseInt(stringTokenizer.nextToken());
        List<Road> list = new ArrayList<>();
        for(int i = 0; i < roadSize; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());

            list.add(new Road(s, e, v));
        }

        Collections.sort(list, new Comparator<Road>() {
            @Override
            public int compare(Road o1, Road o2) {
                return o1.end - o2.end;
            }
        });

        int[] dp = new int[total + 1];
        for(int i = 1; i <= total; i++){
            dp[i] = i;
        }

        for(Road road : list){

            if(road.end > total) continue;

            dp[road.end] = Math.min(dp[road.end], dp[road.start] + road.value);

            // 지름길로 dp 갱신 이후, 지름길 뒤에 길의 비용 갱신
            int dis = 1;
            for(int i = road.end + 1; i <= total; i++){
                dp[i] = Math.min(dp[i], dp[road.end] + dis++);
            }
        }

        System.out.println(dp[total]);
    }
}