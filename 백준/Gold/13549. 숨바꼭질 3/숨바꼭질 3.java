import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// -1, +1로 움직일 때는 1초 걸림. 2배로 움직일 때는 0초 걸림.
// BFS로 풀기. 근데 이제 2배 움직일 때는 깊이 수 안셈.
//public class Boj13549 {
public class Main {
    public static void BFS(int start, int end, int[] dp){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dp[start] = 0;

        while(!queue.isEmpty()){
            int curr = queue.poll();

            if(curr - 1 >= 0 && dp[curr] + 1 < dp[curr - 1]){
                dp[curr - 1] = dp[curr] + 1;
                queue.add(curr - 1);

            }
            if(curr + 1 <= end && dp[curr] + 1 < dp[curr + 1]){
                dp[curr + 1] = dp[curr] + 1;
                queue.add(curr + 1);
            }
            if(curr * 2 < dp.length && dp[curr] < dp[curr * 2]){
                dp[curr * 2] = dp[curr];
                queue.add(curr * 2);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int[] dp = new int[Math.max(start, end) * 2];

        for(int i = 0; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        BFS(start, end, dp);

        System.out.println(dp[end]);
    }
}
