import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 가운데 있는 수 말하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> min = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        while(size-- > 0){
            int num = Integer.parseInt(bufferedReader.readLine());

            if(max.size() == min.size()) max.add(num);
            else min.add(num);

            if(!max.isEmpty() && !min.isEmpty()){
                if(min.peek() < max.peek()){
                    int minTmp = min.poll();
                    int maxTmp = max.poll();

                    max.add(minTmp);
                    min.add(maxTmp);
                }
            }

            stringBuilder.append(max.peek()).append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}