import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] course = new int[n][2];
        PriorityQueue<Integer> room = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            course[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            course[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(course, Comparator.comparingInt((int[] o) -> o[0]));        //시작시간 기준 정렬

        room.add(course[0][1]);     //첫번째 수업의 종료 시간

        for(int i = 1; i < n; i++){
            if(room.peek() <= course[i][0]){
                room.poll();                    //현재 강의 끝나는 시간 빼고 새로운 강의 끝나는 시간 추가
            }
            room.add(course[i][1]);     //가장 빨리 끝나는 강의보다도 시작 시간이 빠르면, 어떤 강의실에도 넣을 수 없음. 하나 추가해야함.
        }

        System.out.println(room.size());
    }
}