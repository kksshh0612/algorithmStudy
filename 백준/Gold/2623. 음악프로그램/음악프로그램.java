import java.io.*;
import java.util.*;

// 출연 순서 -> 위상정렬. indegree, Queue
// 순서 정하는게 불가능한 경우 -> 사이클이 있는 경우
public class Main {

    public static StringBuilder ans;
    public static int total, cnt;

    public static void sort(List<List<Integer>> graph, int[] indegree){
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0){
                ans.append(i).append("\n");
                cnt++;
                queue.add(i);
            }
        }

        if(queue.isEmpty()){
            ans.append("0");
            return;
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(Integer next : graph.get(curr)){
                indegree[next]--;

                if(indegree[next] == 0){
                    ans.append(next).append("\n");
                    queue.add(next);
                    cnt++;
                }
            }
        }
        if(cnt < total) ans = new StringBuilder("0");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        total = Integer.parseInt(st.nextToken());
        int tCase = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= total; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[total + 1];

        while(tCase-- > 0){
            st = new StringTokenizer(bf.readLine());
            int size = Integer.parseInt(st.nextToken());

            int[] arr = new int[size];
            for(int i = 0; i < size; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < size - 1; i++){
                graph.get(arr[i]).add(arr[i + 1]);
                indegree[arr[i + 1]]++;
            }
        }

        ans = new StringBuilder();
        cnt = 0;
        sort(graph, indegree);

        System.out.println(ans.toString());
    }
}