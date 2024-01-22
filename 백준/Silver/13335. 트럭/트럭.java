import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 다리 길이는 w 단위길이. 한 시간에 하나 단위길이만큼 이동 가능.
// 동시에 w대 올라갈 수 있고, 무게 합이 최대 하중인 L보다 작거나 같아야함. (다리에 완전히 올라간 트럭만 무게 포함)
// 순서 못바꿈.
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int truckSize = Integer.parseInt(stringTokenizer.nextToken());
        int length = Integer.parseInt(stringTokenizer.nextToken());
        int maxWeight = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] truck = new int[truckSize];
        for(int i = 0; i < truckSize; i++){
            truck[i] = Integer.parseInt(stringTokenizer.nextToken());       //트럭의 무게
        }

        Queue<Integer> queue = new LinkedList<>();      //무게 저장

        int time = 0, weightSum = 0;

        for(int i = 0; i < truckSize; i++){

            while(true){
                if(queue.size() == length){             //다리가 꽉 차면 하나 내려줌
                    weightSum -= queue.poll();
                }

                if(weightSum + truck[i] <= maxWeight) break;        //트럭이 올라갈 수 있으면 탈출

                queue.add(0);
                time++;
            }

            weightSum += truck[i];
            queue.add(truck[i]);
            time++;
        }

        time += length;         //마지막 트럭

        System.out.println(time);
    }
}