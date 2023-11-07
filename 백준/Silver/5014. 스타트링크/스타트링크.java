import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 총 층수 : F / 목표층 : G / 현재 층 : S / 위 버튼 : U / 아래 버튼 : D
// 위, 아래 버튼을 최소 몇번 눌러야 하는지. 갈 수 없으면 use the stairs
//public class Boj5014 {
public class Main {
    public static int ans;

    public static void BFS(int goal, int limit, int upFloor, int downFloor, Queue<Integer> queue){

        int cnt = 0;
        //이미 방문했는지 확인 -> 이전 턴에 이미 방문했으면 방문할 필요 없음. 이번에 또 방문하면 이 곳을 거쳐온 층 수만 많아지기 때문
        boolean[] check = new boolean[1000001];

        while(!queue.isEmpty()){

            int currTurnQueueSize = queue.size();       //이번 턴 큐 사이즈

            while(currTurnQueueSize--> 0){
                int currFloor = queue.poll();

                if(currFloor == goal){
                    ans = cnt;
                    return;
                }

                if(upFloor != 0 && currFloor + upFloor <= limit && !check[currFloor + upFloor]){

                    check[currFloor + upFloor] = true;
                    queue.add(currFloor + upFloor);
                }
                if(downFloor != 0 && currFloor + downFloor >= 1 && !check[currFloor + downFloor]){
                    check[currFloor + downFloor] = true;
                    queue.add(currFloor + downFloor);
                }

            }
            cnt++;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int totalFloor = Integer.parseInt(stringTokenizer.nextToken());
        int startFloor = Integer.parseInt(stringTokenizer.nextToken());
        int endFloor = Integer.parseInt(stringTokenizer.nextToken());
        int upFloor = Integer.parseInt(stringTokenizer.nextToken());
        int downFloor = Integer.parseInt(stringTokenizer.nextToken()) * (-1);

        ans = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startFloor);

        BFS(endFloor, totalFloor, upFloor, downFloor, queue);

        if(ans == -1){
            System.out.println("use the stairs");
        }
        else{
            System.out.println(ans);
        }

    }
}
