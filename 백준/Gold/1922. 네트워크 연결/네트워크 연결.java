import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Graph{
        int node1, node2, val;

        public Graph(int node1, int node2, int val){
            this.node1 = node1;
            this.node2 = node2;
            this.val = val;
        }
    }

    public static int find(int[] parent, int x){
        if(parent[x] == x) return x;
        else return find(parent, parent[x]);
    }

    public static void union(int[] parent, int x, int y){
        x = find(parent, x);
        y = find(parent, y);

        int min = Math.min(x, y);
        parent[x] = min;
        parent[y] = min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int nodeSize = Integer.parseInt(bufferedReader.readLine());
        int edgeSize = Integer.parseInt(bufferedReader.readLine());

        List<Graph> partialGraph = new ArrayList<>();
        int[] parent = new int[nodeSize + 1];
        for(int i = 0; i <= nodeSize; i++){
            parent[i] = i;
        }

        for(int i = 0; i < edgeSize; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());
            int val = Integer.parseInt(stringTokenizer.nextToken());

            partialGraph.add(new Graph(node1, node2, val));
        }

        Collections.sort(partialGraph, new Comparator<Graph>() {
            @Override
            public int compare(Graph o1, Graph o2) {
                return o1.val - o2.val;
            }
        });

        int valSum = 0;
        for(Graph graph : partialGraph){

            // 이미 연결됨
            if(find(parent, graph.node1) == find(parent, graph.node2)) continue;

            union(parent, graph.node1, graph.node2);
            valSum += graph.val;
        }

        System.out.println(valSum);
    }
}