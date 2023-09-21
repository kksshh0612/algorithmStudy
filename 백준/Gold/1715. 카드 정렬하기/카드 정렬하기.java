import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


// 각 묶음을 더할 때, 최소가 돼야 한다. local optimal == global optimal
// 만약 네 장(a, b, c, d) 묶음이 있다면 최종 비교는 (a + b) + ((a + b) + c) +  (((a + b) + c) + d) = 3a + 3b + 2c + 1d
// 오름차순 정렬 후 해결하기 인줄 알았는데, 아니었다.
// 만약 20 30 30 40 이라면 50(20+30) + 80(50+30) + 120(80+40) = 250 보다 50(20+30) + 70(30+40) + 120(50+70) = 240 이 더 작다.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int n = Integer.parseInt(bufferedReader.readLine());
        int a = 0, b = 0;
        long ans = 0;
        for(int i = 0;  i < n; i++){
            priorityQueue.add(Integer.parseInt(bufferedReader.readLine()));
        }

        while(priorityQueue.size() > 1){
            a = priorityQueue.poll();
            b = priorityQueue.poll();
            priorityQueue.add(a + b);

            ans += a + b;
        }

        System.out.println(ans);
    }
}