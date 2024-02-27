import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 크루스컬 -> 간선을 오름차순 정렬
public class Main {

    public static class Graph{
        int vtx1, vtx2, val;

        public Graph(int vtx1, int vtx2, int val){
            this.vtx1 = vtx1;
            this.vtx2 = vtx2;
            this.val = val;
        }
    }

    public static int find(int[] parent, int num){
        if(parent[num] == num) return num;
        else return find(parent, parent[num]);
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
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int vtxSize = Integer.parseInt(stringTokenizer.nextToken());
        int edgeSize = Integer.parseInt(stringTokenizer.nextToken());

        List<Graph> partialGraph = new ArrayList<>();
        int[] parent = new int[vtxSize + 1];
        for(int i = 0; i <= vtxSize; i++){
            parent[i] = i;
        }

        for(int i = 0; i < edgeSize; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int vtx1 = Integer.parseInt(stringTokenizer.nextToken());
            int vtx2 = Integer.parseInt(stringTokenizer.nextToken());
            int val = Integer.parseInt(stringTokenizer.nextToken());

            partialGraph.add(new Graph(vtx1, vtx2, val));
        }
        
        // 가중치 (val) 기준으로 오름차순 정렬
        Collections.sort(partialGraph, new Comparator<Graph>() {
            @Override
            public int compare(Graph o1, Graph o2){
                return o1.val - o2.val;
            }
        });

        int valSum = 0;
        for(Graph graph : partialGraph){

            // 이미 트리에 연결돼있으면 pass
            if(find(parent, graph.vtx1) == find(parent, graph.vtx2)) continue;

            union(parent, graph.vtx1, graph.vtx2);
            valSum += graph.val;
        }

        System.out.println(valSum);
    }
}