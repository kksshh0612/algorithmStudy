import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// Interval Partitioning 문제. 수업이 빨리 끝나는 순으로 정렬 / 우선순위 큐에 종료 시간 저장
//public class Boj11000 {
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] courseList = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            courseList[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            courseList[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(courseList, Comparator.comparingInt((int[] o) -> o[0]));        // 시작 시간 기준 오름차순 정렬

        priorityQueue.add(courseList[0][1]);        //첫번째 수업 넣음.

        for(int i = 1; i < n; i++){

            if(priorityQueue.peek() <= courseList[i][0]){
                priorityQueue.poll();       //빼고
            }
            priorityQueue.add(courseList[i][1]);        //종료시간 넣음
        }

        System.out.println(priorityQueue.size());
    }
}