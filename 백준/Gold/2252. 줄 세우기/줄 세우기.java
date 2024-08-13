import java.util.*;
import java.io.*;
// 작업의 순서 주어지고 전체 작업의 순서 정하기 / 사이클 없음-> 위상정렬
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int size = Integer.parseInt(st.nextToken());
        int relation = Integer.parseInt(st.nextToken());

        int[] indegree = new int[size];         // 진입 차수
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < relation; i++){
            st = new StringTokenizer(bf.readLine());
            int pre = Integer.parseInt(st.nextToken()) - 1;
            int post = Integer.parseInt(st.nextToken()) - 1;

            list.get(pre).add(post);
            indegree[post]++;
        }

        // 위상정렬

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < size; i++){
            if(indegree[i] == 0) queue.add(i);
        }

        StringBuilder ans = new StringBuilder();

        while(!queue.isEmpty()){
            int curr = queue.poll();

            ans.append(curr + 1).append(" ");

            for(Integer next : list.get(curr)){
                indegree[next]--;
                if(indegree[next] == 0) queue.add(next);
            }
        }

        System.out.println(ans.toString());

    }
}