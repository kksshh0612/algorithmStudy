import java.util.*;
import java.io.*;

public class Main {

    public static List<Edge> graph = new ArrayList<>();
    public static int nodeSize, start, end;

    public static class Edge{
        int node1, node2, val;
        public Edge(int node1, int node2, int val){
            this.node1 = node1;
            this.node2 = node2;
            this.val = val;
        }
    }

    public static int find(int[] parent, int x){
        if(parent[x] == x) return x;
        else return find(parent, parent[x]);
    }

    public static void union(int[] parent, int num1, int num2){
        int min = Math.min(num1, num2);

        parent[num1] = min;
        parent[num2] = min;
    }

    // minVal 이상인 경로 연결하고 최종으로 start와 end가 연결되었는지 리턴
    public static boolean makeMst(int minVal){
        int[] parent = new int[nodeSize + 1];
        for(int i = 1; i <= nodeSize; i++){
            parent[i] = i;
        }

        for(Edge edge : graph){
            if(edge.val < minVal) continue;

            int node1Find = find(parent, edge.node1);
            int node2Find = find(parent, edge.node2);

            // 연결되어있지 않으면 연결
            if(node1Find != node2Find){
                union(parent, node1Find, node2Find);
            }
        }

        if(find(parent, start) == find(parent, end)){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE, max = 0;

        for(int i = 0; i < edgeSize; i++){
            st = new StringTokenizer(bf.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            graph.add(new Edge(node1, node2, val));

            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());;

        // 이분탐색으로 경로 최솟값 구하고 그 위로만 그래프 탐색하기
        while(min <= max){
            int mid = (min + max) / 2;

            boolean possiblePah = makeMst(mid);

            if(possiblePah){
                min = mid + 1;
            }
            else{
                max = mid - 1;
            }
        }
        System.out.println(max);
    }
}