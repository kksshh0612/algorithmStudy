import java.util.*;
import java.io.*;

// 젤 멀리 있는거 m개 빼고 0 기준 왼쪽, 오른쪽 두개씩 묶기
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int size = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        // 양의정수, 음의정수 절댓값 내림차순 정렬
        PriorityQueue<Integer> positive = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> negative = new PriorityQueue<>((a, b) -> a - b);

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < size; i++){
            int num = Integer.parseInt(st.nextToken());

            if(num > 0) positive.add(num);
            else negative.add(num);
        }

        int ans = 0;
        int positiveMax = positive.isEmpty() ? 0 : positive.peek();
        int negativeMax = negative.isEmpty() ? 0 : negative.peek();

        //양수 -> 하나 빼고 max개 빼고
        while(!positive.isEmpty()){
            int curr = positive.peek();

            for(int i = 0; i < max; i++){
                positive.poll();
                if(positive.isEmpty()) break;
            }
            ans += curr;
        }

        //음수 -> 하나 빼고 max개 빼고
        while(!negative.isEmpty()){
            int curr = negative.peek();

            for(int i = 0; i < max; i++){
                negative.poll();
                if(negative.isEmpty()) break;
            }
            ans -= curr;
        }

        System.out.println(ans * 2 - Math.max(positiveMax, -negativeMax));
    }
}