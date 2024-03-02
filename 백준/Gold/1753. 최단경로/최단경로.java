import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 시작 정점에서 각 정점으로 가는 최소 비용 -> 다익스트라
// 간선 여러개일 수 있음
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

    public static void dijkstra(List<List<Node>> graph, int[] dp, int start){

        boolean[] check = new boolean[dp.length];

        PriorityQueue<DijkstraNode> priorityQueue = new PriorityQueue<>(new Comparator<DijkstraNode>() {
            @Override
            public int compare(DijkstraNode o1, DijkstraNode o2) {
                return o1.val - o2.val;
            }
        });

        priorityQueue.add(new DijkstraNode(start, 0));
        dp[start] = 0;

        while(!priorityQueue.isEmpty()){

            DijkstraNode curr = priorityQueue.poll();

            if(check[curr.node]) continue;
            check[curr.node] = true;

            for(Node nextNode : graph.get(curr.node)){
                if(dp[curr.node] + nextNode.val < dp[nextNode.dest]){
                    dp[nextNode.dest] = dp[curr.node] + nextNode.val;
                    priorityQueue.add(new DijkstraNode(nextNode.dest, dp[nextNode.dest]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int nodeSize = Integer.parseInt(stringTokenizer.nextToken());
        int edgeSize = Integer.parseInt(stringTokenizer.nextToken());
        int start = Integer.parseInt(bufferedReader.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= nodeSize; i++){
            graph.add(new ArrayList<>());
        }

        int[] dp = new int[nodeSize + 1];
        for(int i = 0; i <= nodeSize; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < edgeSize; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());
            int val = Integer.parseInt(stringTokenizer.nextToken());

            boolean alreadyIn = false;
//            for(Node node : graph.get(node1)){
//                if(node2 == node.dest){
//                    alreadyIn = true;
//                    if(val < node.val){         //현재 노드가 더 작으면 교체
//                        graph.get(node1).remove(node);
//                        graph.get(node1).add(new Node(node2, val));
//                    }
//                    break;
//                }
//            }
            if(!alreadyIn) graph.get(node1).add(new Node(node2, val));
        }

        dijkstra(graph, dp, start);

        StringBuilder ans = new StringBuilder();
        for(int i = 1; i <= nodeSize; i++){
            if(dp[i] == Integer.MAX_VALUE) ans.append("INF\n");
            else ans.append(dp[i]).append("\n");
        }

        System.out.println(ans.toString());
    }
}