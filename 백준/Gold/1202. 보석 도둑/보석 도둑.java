import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Jewel{
        int weight;
        int value;

        public Jewel(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int jewelInfo = Integer.parseInt(stringTokenizer.nextToken());
        int bagInfo = Integer.parseInt(stringTokenizer.nextToken());
        List<Jewel> jewelList = new ArrayList<>();
        for(int i = 0; i < jewelInfo; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int weight = Integer.parseInt(stringTokenizer.nextToken());
            int value = Integer.parseInt(stringTokenizer.nextToken());
            jewelList.add(new Jewel(weight, value));
        }
        int[] bag = new int[bagInfo];
        for(int i = 0; i < bagInfo; i++){
            bag[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(bag);       //가방 오름차순 정렬
        Collections.sort(jewelList, (o1, o2) -> o1.weight - o2.weight);     //보석 무게 기준 오름차순 정렬

        // 보석 가치 내림차순 정렬
        PriorityQueue<Jewel> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        long ans = 0;

        int jewelIdx = 0;
        for(int i = 0; i < bagInfo; i++){
            while(jewelIdx < jewelInfo && jewelList.get(jewelIdx).weight <= bag[i]){
//                Jewel currJewel = jewelList.get(jewelIdx++);
//                priorityQueue.add(new Jewel(currJewel.weight, currJewel.value));
           
                priorityQueue.add(jewelList.get(jewelIdx++));
            }
            if(!priorityQueue.isEmpty()){
                ans += priorityQueue.poll().value;
            }
        }

        System.out.println(ans);
    }
}

