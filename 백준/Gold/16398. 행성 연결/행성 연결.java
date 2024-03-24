import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최소 비용으로 모든 행성 연결 -> MST
public class Main {

    public static int find(int[] parent, int x){
        if(x == parent[x]) return x;
        else return find(parent, parent[x]);
    }

    public static void union(int[] parent, int x, int y){
        x = find(parent, x);
        y = find(parent, y);

        int min = Math.min(x, y);

        parent[x] = min;
        parent[y] = min;
    }

    public static class PartialGraph{
        int x, y, val;

        PartialGraph(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[size][size];
        for(int i = 0; i < size; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < size; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[] parent = new int[size];
        for(int i = 0; i < size; i++){
            parent[i] = i;
        }
        PriorityQueue<PartialGraph> graph = new PriorityQueue<>(new Comparator<PartialGraph>() {
            @Override
            public int compare(PartialGraph o1, PartialGraph o2) {
                return o1.val - o2.val;
            }
        });

        for(int i = 0; i < size; i++){
            for(int j = i; j < size; j++){
                if(arr[i][j] == 0) continue;

                graph.add(new PartialGraph(i, j, arr[i][j]));
            }
        }

        long ans = 0;

        while(!graph.isEmpty()){
            PartialGraph curr = graph.poll();
            if(find(parent, curr.x) == find(parent, curr.y)) continue;

            union(parent, curr.x, curr.y);
            ans += curr.val;;
        }

        System.out.println(ans);
    }
}