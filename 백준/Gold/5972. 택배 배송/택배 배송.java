import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다익스트라. 간선의 비용 합이 최소가 되도록 1부터 n까지 가기
//public class Boj5972 {
public class Main {
    public static class Pos{
        int target, val;

        public Pos(int target, int val){
            this.target = target;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int edge = Integer.parseInt(stringTokenizer.nextToken());
        List<List<Pos>> list = new ArrayList<>();
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < edge; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int val = Integer.parseInt(stringTokenizer.nextToken());

            list.get(start).add(new Pos(end, val));     //그래프 연결
            list.get(end).add(new Pos(start, val));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dp[1] = 0;

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(Pos nextPos : list.get(curr)){
                if(dp[curr] + nextPos.val < dp[nextPos.target]){
                    dp[nextPos.target] = dp[curr] + nextPos.val;
                    queue.add(nextPos.target);
                }
            }
        }
//
//        for(int i = 0; i <= n; i++){
//            System.out.println(dp[i]);
//        }

        System.out.println(dp[n]);
    }
}
