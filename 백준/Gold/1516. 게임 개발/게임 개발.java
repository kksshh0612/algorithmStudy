import java.util.*;
import java.io.*;

// 작업의 순서 -> 위상정렬. indegree, 우선순위 큐
// 최소 시간 -> 우선순위 큐 정렬 기준 : 시간
public class Main {

    public static class Job{
        int num, time;
        public Job(int num, int time){
            this.num = num;
            this.time = time;
        }
    }

    public static void sort(List<List<Integer>> graph, int[] jobTime, int[] indegree){
       int size = indegree.length;

        PriorityQueue<Job> pq = new PriorityQueue<>(new Comparator<Job>(){
            @Override
            public int compare(Job o1, Job o2){
                return o1.time - o2.time;
            }
        });

        for(int i = 0; i < size; i++){
            if(indegree[i] == 0){
                pq.add(new Job(i, jobTime[i]));
            }
        }

        while(!pq.isEmpty()){
            Job currJob = pq.poll();

//            System.out.println("여기 " + currJob.num + " " + currJob.time);

            for(Integer nextJob : graph.get(currJob.num)){

//                System.out.println("탐색 " + nextJob);



                indegree[nextJob]--;
                if(indegree[nextJob] == 0){
                    jobTime[nextJob] += currJob.time;
                    pq.add(new Job(nextJob, jobTime[nextJob]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < size; i++){
            graph.add(new ArrayList<>());
        }
        int[] jobTime = new int[size];          // 작업 처리 시간
        int[] indegree = new int[size];         // 진입차수

        for(int i = 0; i < size; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int time = Integer.parseInt(st.nextToken());       // 시간
            jobTime[i] = time;

            while(true){
                int node = Integer.parseInt(st.nextToken());

                if(node == -1) break;

                graph.get(node - 1).add(i);         // 단방향 그래프 연결
                indegree[i]++;
            }
        }

//        for(int i = 0; i < size; i++){
//            System.out.print(indegree[i] + " ");
//        }

        sort(graph, jobTime, indegree);

        for(int i = 0; i < size; i++){
            System.out.println(jobTime[i]);
        }

    }
}