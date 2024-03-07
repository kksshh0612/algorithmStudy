import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 단방향 그래프, 다익스트라. 모든 정점에서 dest까지 가는 비용 중 max 구하기
public class Main {

    public static class Node{
        int dest, val;

        public Node(int dest, int val){
            this.dest = dest;
            this.val = val;
        }
    }

    public static class DijkstraNode{
        int node, val;

        public DijkstraNode(int node, int val){
            this.node = node;
            this.val = val;
        }
    }

    public static int[] dijkstra(List<List<Node>> graph, int start, int size){

        int[] dp = new int[size + 1];
        boolean[] check = new boolean[size + 1];
        PriorityQueue<DijkstraNode> queue = new PriorityQueue<>(new Comparator<DijkstraNode>() {
            @Override
            public int compare(DijkstraNode o1, DijkstraNode o2) {
                return o1.val - o2.val;
            }
        });

        for(int i = 0; i <= size; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        dp[start] = 0;
        queue.add(new DijkstraNode(start, 0));

        while(!queue.isEmpty()){
            DijkstraNode curr = queue.poll();

            if(check[curr.node]) continue;
            check[curr.node] = true;

            // 이동할 수 있는 경로 탐색
            for(Node nextNode : graph.get(curr.node)){
                if(dp[curr.node] + nextNode.val < dp[nextNode.dest]){
                    dp[nextNode.dest] = dp[curr.node] + nextNode.val;
                    queue.add(new DijkstraNode(nextNode.dest, dp[nextNode.dest]));
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int edgeSize = Integer.parseInt(stringTokenizer.nextToken());
        int dest = Integer.parseInt(stringTokenizer.nextToken());

        List<List<Node>> graphGo = new ArrayList<>();
        List<List<Node>> graphBack = new ArrayList<>();
        for(int i = 0; i <= size; i++){
            graphGo.add(new ArrayList<>());
            graphBack.add(new ArrayList<>());
        }
        for(int i = 0; i < edgeSize; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int val = Integer.parseInt(stringTokenizer.nextToken());

            graphGo.get(start).add(new Node(end, val));
            graphBack.get(end).add(new Node(start, val));
        }

        int[] go = dijkstra(graphBack, dest, size);
        int[] back = dijkstra(graphGo, dest, size);
        
        int ans = 0;
        for(int i = 1; i <= size; i++){
            ans = Math.max(go[i] + back[i], ans);
        }

        System.out.println(ans);
    }
}