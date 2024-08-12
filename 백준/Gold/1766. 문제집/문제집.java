import java.util.*;
import java.io.*;

// 먼저 푸는게 좋은 문제 먼저. 쉬운 문제 순
public class Main {

    public static StringBuilder ans;

    public static void solve(List<List<Integer>> list, int[] indegree){

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1 - o2;             // 수 낮은 순 정렬
            }
        });

        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0) pq.add(i);
        }

        while(!pq.isEmpty()){
            int num = pq.poll();

            ans.append(num).append(" ");

            for(Integer next : list.get(num)){
                indegree[next]--;
                if(indegree[next] == 0) pq.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int problem = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= problem; i++){
            list.add(new ArrayList<>());
        }
        int[] indegree = new int[problem + 1];              // 자신을 가리키는 간선 수

        for(int i = 0; i < size; i++){
            st = new StringTokenizer(bf.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int post = Integer.parseInt(st.nextToken());

            list.get(pre).add(post);
            indegree[post]++;
        }
        ans = new StringBuilder();

        solve(list, indegree);

        System.out.println(ans.toString());
    }
}