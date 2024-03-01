import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 마을을 두 마을로 분할하는데, 간선의 비용을 최소로 하도록 하기 -> MST
// MST를 구하고 간선의 합을 구한 다음, 가장 비용이 높은 간선을 하나 빼면 정답임
public class Main {

    public static class Road{
        int node1, node2, val;

        public Road(int node1, int node2, int val){
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
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int nodeSize = Integer.parseInt(stringTokenizer.nextToken());
        int edgeSize = Integer.parseInt(stringTokenizer.nextToken());

        List<Road> roadList = new ArrayList<>();
        for(int i = 0; i < edgeSize; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());
            int val = Integer.parseInt(stringTokenizer.nextToken());
            roadList.add(new Road(node1, node2, val));
        }

        int[] parent = new int[nodeSize + 1];
        for(int i = 0; i <= nodeSize; i++){
            parent[i] = i;
        }

        Collections.sort(roadList, new Comparator<Road>() {
            @Override
            public int compare(Road o1, Road o2) {
                return o1.val - o2.val;
            }
        });

        List<Integer> connectedVal = new ArrayList<>();
        for(Road road : roadList){

            if(find(parent, road.node1) == find(parent, road.node2)) continue;      //이미 연결된 것임.

            union(parent, road.node1, road.node2);
            connectedVal.add(road.val);
        }
        Collections.sort(connectedVal, Comparator.reverseOrder());

        int ans = 0;
        for(int i = 1; i < connectedVal.size(); i++){
            ans += connectedVal.get(i);
        }

        System.out.println(ans);
    }
}