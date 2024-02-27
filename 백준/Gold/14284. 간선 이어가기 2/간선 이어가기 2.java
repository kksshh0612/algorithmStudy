import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

            DijkstraNode currNode = priorityQueue.poll();

            if(check[currNode.node]) continue;

            check[currNode.node] = true;

            for(Node nextNode : graph.get(currNode.node)){
                if(dp[currNode.node] + nextNode.val < dp[nextNode.dest]){
                    dp[nextNode.dest] = dp[currNode.node] + nextNode.val;
                    priorityQueue.add(new DijkstraNode(nextNode.dest, dp[nextNode.dest]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int edgeNum = Integer.parseInt(stringTokenizer.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < edgeNum; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());
            int val = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(node1).add(new Node(node2, val));
            graph.get(node2).add(new Node(node1, val));
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int start = Integer.parseInt(stringTokenizer.nextToken());
        int end = Integer.parseInt(stringTokenizer.nextToken());

        dijkstra(graph, dp, start);

        System.out.println(dp[end]);
    }
}