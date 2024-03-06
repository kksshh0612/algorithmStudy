import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 두 점 이을 때마다 거리만큼 비용 -> 최소 비용 구하기
public class Main {

    public static class Pos{
        double x, y;

        public Pos(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    public static class PartialGraph{
        int node1, node2;
        double val;

        public PartialGraph(int node1, int node2, double val){
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
        int size = Integer.parseInt(bufferedReader.readLine());
        Pos[] arr = new Pos[size];
        for(int i = 0; i < size; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            double x = Double.parseDouble(stringTokenizer.nextToken());
            double y = Double.parseDouble(stringTokenizer.nextToken());
            arr[i] = new Pos(x, y);
        }

        // 간선 비용 기준 오름차순 정렬
        PriorityQueue<PartialGraph> priorityQueue = new PriorityQueue<>(new Comparator<PartialGraph>() {
            @Override
            public int compare(PartialGraph o1, PartialGraph o2) {
                if(o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });

        int[] parent = new int[size];
        for(int i = 0; i < size; i++){
            parent[i] = i;
        }

        // 모든 간선 생성
        for(int i = 0; i < size - 1; i++){
            for(int j = i + 1; j < size; j++){
                double val = Math.sqrt(Math.pow(arr[i].x - arr[j].x, 2) + Math.pow(arr[i].y - arr[j].y, 2));
                priorityQueue.add(new PartialGraph(i, j, val));
            }
        }

        double ans = 0;
        while(!priorityQueue.isEmpty()){
            PartialGraph partialGraph = priorityQueue.poll();

            // 이미 연결돼있으면 패스
            if(find(parent, partialGraph.node1) == find(parent, partialGraph.node2)) continue;

            ans += partialGraph.val;
            union(parent, partialGraph.node1, partialGraph.node2);
        }

        System.out.printf("%.2f", ans);
    }
}