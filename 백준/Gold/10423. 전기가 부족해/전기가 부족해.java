import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Graph{
        int vtx1, vtx2, val;

        public Graph(int vtx1, int vtx2, int val) {
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

    public static void powerOn(int[] parent, boolean[] isPowerConnected, int num){
        isPowerConnected[num] = true;
        if(parent[num] == num) return;
        else powerOn(parent, isPowerConnected, parent[num]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int vtxNum = Integer.parseInt(stringTokenizer.nextToken());
        int edgeNum = Integer.parseInt(stringTokenizer.nextToken());
        int powerSupplyNum = Integer.parseInt(stringTokenizer.nextToken());     //발전소 수

        List<Integer> powerList = new ArrayList<>();        // 발전소 리스트

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < powerSupplyNum; i++){
            powerList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        List<Graph> partialGraphList = new ArrayList<>();
        for(int i = 0; i < edgeNum; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int vtx1 = Integer.parseInt(stringTokenizer.nextToken());
            int vtx2 = Integer.parseInt(stringTokenizer.nextToken());
            int edge = Integer.parseInt(stringTokenizer.nextToken());
            partialGraphList.add(new Graph(vtx1, vtx2, edge));
        }

        // 간선 가중치 기준 오름차순 정렬
        Collections.sort(partialGraphList, new Comparator<Graph>() {
            @Override
            public int compare(Graph o1, Graph o2) {
                return o1.val - o2.val;
            }
        });

        // MST에서 정점의 각 부모를 저장하는 배열
        int[] parent = new int[vtxNum + 1];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }

        for(int i = 1; i < powerList.size(); i++){
            union(parent, powerList.get(i - 1), powerList.get(i));
        }

        int ans = 0;
//        boolean[] isPowerConnected = new boolean[vtxNum + 1];  // 정점이 발전소에 연결되었는지 확인
//        for(Integer power : powerList){
//            isPowerConnected[power] = true;     // 발전소 정점은 이미 발전소에 연결된 것과 같음
//        }

        /**
         * 모든 점이 발전소와 연결되기만 하면 됨.
         * 간선이 둘다 발전소에 연결되었으면 간선 연결 X
         * 간선 둘 중 하나 연결 안되었으면 연결.
         * 간선 둘 다 연결 안되었으면 일단 연결하고, 연결 안된 부분 그래프 power on
         */
        for(Graph graph : partialGraphList){
            if(find(parent, graph.vtx1) == find(parent, graph.vtx2)) continue;

//            // 둘 다 발전소에 연결되어 있으면 연결할 필요 없음
//            if(isPowerConnected[graph.vtx1] && isPowerConnected[graph.vtx2]) continue;

            // 두 정점의 부분그래프를 연결함
            union(parent, graph.vtx1, graph.vtx2);
            ans += graph.val;

//            // 둘 중 파워가 연결된 정점이 있다면, 파워가 연결되지 않은 부분그래프에 파워를 연결해줌
//            if(isPowerConnected[graph.vtx1]) powerOn(parent, isPowerConnected, graph.vtx2);
//            if(isPowerConnected[graph.vtx2]) powerOn(parent, isPowerConnected, graph.vtx1);
        }

        System.out.println(ans);
    }
}