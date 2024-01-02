import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int ans;
    public static int count;

    public static void BFS(int end, Queue<Integer> queue, boolean[] check){

        boolean isComplete = false;
        int level = 0;

        while(!queue.isEmpty()){

            int currTurnSize = queue.size();

            while(currTurnSize-- > 0){
                int currPos = queue.poll();

                check[currPos] = true;

                if(currPos == end) {
                    ans = level;
                    count++;
                    isComplete = true;
                    continue;
                }

                if(currPos - 1 >= 0 && !check[currPos - 1]){
                    queue.add(currPos - 1);
                }
                if(currPos + 1 <= end && !check[currPos + 1]){
                    queue.add(currPos + 1);
                }
                if(currPos * 2 <= 100000 && !check[currPos * 2]){
                    queue.add(currPos * 2);
                }
            }

            if(isComplete) return;

            level++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        boolean[] check = new boolean[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        count = 0;

        BFS(end, queue, check);

        System.out.println(ans + "\n" + count);
    }
}