import java.util.*;
import java.io.*;

// 사이클 찾기 -> DFS
// 사이클까지의 거리 찾기
public class Main{

    public static int[] distance;
    public static Queue<Integer> cycleQueue;

    public static void dfs(List<List<Integer>> graph, boolean[] check,
                           int curr, int start, int cnt){

        check[curr] = true;

        for(Integer next : graph.get(curr)){
            if(check[next]){        //이미 방문했으면
                if(next == start && cnt >= 3){
                    distance[next] = 0;
                    cycleQueue.add(next);
                    return;
                }
            }
            else{
                dfs(graph, check, next, start, cnt + 1);
            }
        }
    }

    public static void bfs(List<List<Integer>> graph){

        while(!cycleQueue.isEmpty()){
            int curr = cycleQueue.poll();

            for(Integer next : graph.get(curr)){
                if(distance[next] == -1){
                    distance[next] = distance[curr] + 1;
                    cycleQueue.add(next);
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
        for(int i = 0; i < size; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        distance = new int[size];
        Arrays.fill(distance, -1);
        cycleQueue = new LinkedList<>();

        for(int i = 0; i < size; i++){
            boolean[] check = new boolean[size];

            dfs(graph, check, i, i, 1);     // 각 위치가 사이클에 포함된 위치인지 확인.
        }

        bfs(graph);

        for(int i = 0; i < size; i++){
            System.out.print(distance[i] + " ");
        }
    }
}