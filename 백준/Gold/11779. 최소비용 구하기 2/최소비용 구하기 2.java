import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 방향그래프에서 최단거리 구하기. (음수 없음) -> 다익스트라
// 경로에 포함된 도시 출력해야 하니까, dp에 현재까지의 최단거리가 저장될 때, 이전 도시 정보도 저장하도록 함.
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

    public static class ShortestPathInfo{
        int val, prev;      //현재까지의 최소비용과 이전 노드

        public ShortestPathInfo(int val){
            this.val = val;
            this.prev = 0;
        }
    }

    public static void dijkstra(List<List<Node>> graph, ShortestPathInfo[] dp, int start){

        boolean[] check = new boolean[dp.length];
        PriorityQueue<DijkstraNode> priorityQueue = new PriorityQueue<>(new Comparator<DijkstraNode>() {
            @Override
            public int compare(DijkstraNode o1, DijkstraNode o2) {
                return o1.val - o2.val;
            }
        });

        priorityQueue.add(new DijkstraNode(start, 0));
        dp[start].val = 0;

        while(!priorityQueue.isEmpty()){
            DijkstraNode currNode = priorityQueue.poll();

            if(check[currNode.node]) continue;
            check[currNode.node] = true;

            for(Node nextNode : graph.get(currNode.node)){
                if(dp[currNode.node].val + nextNode.val < dp[nextNode.dest].val){
                    dp[nextNode.dest].val = dp[currNode.node].val + nextNode.val;
                    dp[nextNode.dest].prev = currNode.node;
                    priorityQueue.add(new DijkstraNode(nextNode.dest, dp[nextNode.dest].val));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int nodeSize = Integer.parseInt(bufferedReader.readLine());
        int edgeSize = Integer.parseInt(bufferedReader.readLine());

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= nodeSize; i++){
            graph.add(new ArrayList<>());
        }
        ShortestPathInfo[] dp = new ShortestPathInfo[nodeSize + 1];
        for(int i = 0; i <= nodeSize; i++){
            dp[i] = new ShortestPathInfo(Integer.MAX_VALUE);
        }

        for(int i = 0; i < edgeSize; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());
            int val = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(node1).add(new Node(node2, val));
        }
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int start = Integer.parseInt(stringTokenizer.nextToken());
        int end = Integer.parseInt(stringTokenizer.nextToken());

        dijkstra(graph, dp, start);

        Stack<Integer> pathStack = new Stack<>();
        int curr = end;
        while(curr != 0){
            pathStack.push(curr);
            curr = dp[curr].prev;
        }

//        for(int i = 0; i <= nodeSize; i++){
//            System.out.print(dp[i].val + " ");
//        }

        StringBuilder ans = new StringBuilder();
        ans.append(dp[end].val).append("\n");
        ans.append(pathStack.size()).append("\n");
        while(!pathStack.isEmpty()){
            ans.append(pathStack.pop()).append(" ");
        }

        System.out.println(ans.toString());
    }
}