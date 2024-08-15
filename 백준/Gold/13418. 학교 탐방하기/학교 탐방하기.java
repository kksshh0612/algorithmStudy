import java.util.*;
import java.io.*;

// 0은 오르막길, 1은 내리막길.
// 최선과 최악의 피로도 차이.    피로도 == 오르막길 수의 제곱
// 최선 : 내리막길들 먼저 고려해서 간선 추가   최악 : 오르막길 먼저 고려해서 간선 추가
public class Main {

    public static class Partial{
        int node1, node2, road;
        public Partial(int n1, int n2, int road){
            this.node1 = n1;
            this.node2 = n2;
            this.road = road;
        }
    }

    public static int find(int[] parent, int num){
        if(parent[num] == num) return num;
        else return find(parent, parent[num]);
    }

    public static void union(int[] parent, int num1, int num2){
//        num1 = find(parent, num1);
//        num2 = find(parent, num2);

        int min = Math.min(num1, num2);

        parent[num1] = min;
        parent[num2] = min;
    }

    public static long solution(int[] parent, List<Partial> graph){
        long cnt = 0;

        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }

        for(Partial partial : graph){
            int num1 = find(parent, partial.node1);
            int num2 = find(parent, partial.node2);
            if(num1 == num2) continue;

            union(parent, num1, num2);
            if(partial.road == 0) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int size = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());

        int[] parent = new int[size + 1];
        List<Partial> graph = new ArrayList<>();
        for(int i = 0; i <= edge; i++){
            st = new StringTokenizer(bf.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());
            graph.add(new Partial(node1, node2, road));
        }

        // 최악
        Collections.sort(graph, new Comparator<Partial>(){
            @Override
            public int compare(Partial o1, Partial o2){
                return o1.road - o2.road;
            }
        });
        long worst = solution(parent, graph);
        // 최선
        Collections.sort(graph, new Comparator<Partial>(){
            @Override
            public int compare(Partial o1, Partial o2){
                return o2.road - o1.road;
            }
        });
        long best = solution(parent, graph);

        System.out.println(worst * worst - best * best);
    }
}