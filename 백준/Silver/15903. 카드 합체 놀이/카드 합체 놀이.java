import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 서로 다른 두 개의 카드를 더하고 덮어씀.
// 그리디 -> 가장 작은 두개 뽑아서 더하고 우선순위 큐에 넣기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int sumNum = Integer.parseInt(stringTokenizer.nextToken());

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < size; i++){
            long num = Integer.parseInt(stringTokenizer.nextToken());
            priorityQueue.add(num);
        }

        for(int i = 0; i < sumNum; i++){
            long num1 = priorityQueue.poll();
            long num2 = priorityQueue.poll();

            priorityQueue.add(num1 + num2);
            priorityQueue.add(num1 + num2);
        }

        long ans = 0;
        while(!priorityQueue.isEmpty()){
            ans += priorityQueue.poll();

        }

        System.out.println(ans);
    }
}