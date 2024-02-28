import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 건우 위치를 꼭 포함시키는 경우의 최단거리와 최종 최단거리를 비교해서 같으면 true
// 각 노드마다 본인이 이전 노드 저장하기
public class Main {

    public static class Node{               //그래프 연결 노드
        int dest, val;

        public Node(int dest, int val){
            this.dest = dest;
            this.val = val;
        }
    }

    public static class DijkstraNode{       //다익스트라에 사용될 노드
        int dest, val;

        public DijkstraNode(int dest, int val){
            this.dest = dest;
            this.val = val;
        }
    }

    public static class ShortestNodeInfo{   //dp 배열에 사용될 노드
        List<Integer> prevNode;         //현재까지 오는데 최소비용이 가능한 이전 노드들
        int val;                        //현재 노드까지 오는데 드는 최소 비용

        public ShortestNodeInfo(int val){
            this.val = val;
            prevNode = new ArrayList<>();
        }

        public void addPrevNode(int prevNode){
            this.prevNode.add(prevNode);
        }

        public void remove(){
            this.prevNode.clear();
        }
    }

    public static void dijkstra(List<List<Node>> graph, ShortestNodeInfo[] dp){

        boolean[] check = new boolean[dp.length];

        PriorityQueue<DijkstraNode> priorityQueue = new PriorityQueue<>(new Comparator<DijkstraNode>() {
            @Override
            public int compare(DijkstraNode o1, DijkstraNode o2) {
                return o1.val - o2.val;
            }
        });

        priorityQueue.add(new DijkstraNode(1, 0));      //1부터 시작
        dp[1].val = 0;
        dp[1].addPrevNode(0);

        while(!priorityQueue.isEmpty()){

            DijkstraNode curr = priorityQueue.poll();

            if(check[curr.dest]) continue;
            check[curr.dest] = true;

            for(Node nextNode : graph.get(curr.dest)){

                if(dp[curr.dest].val + nextNode.val < dp[nextNode.dest].val){
                    dp[nextNode.dest].val = dp[curr.dest].val + nextNode.val;
                    dp[nextNode.dest].remove();
                    dp[nextNode.dest].addPrevNode(curr.dest);
                    priorityQueue.add(new DijkstraNode(nextNode.dest, dp[nextNode.dest].val));
                }
                else if(dp[curr.dest].val + nextNode.val == dp[nextNode.dest].val){
                    dp[nextNode.dest].val = dp[curr.dest].val + nextNode.val;
                    dp[nextNode.dest].addPrevNode(curr.dest);
                    priorityQueue.add(new DijkstraNode(nextNode.dest, dp[nextNode.dest].val));
                }
            }
        }
    }

    public static boolean isPossible;

    public static void backTracking(ShortestNodeInfo[] dp, int geunwoo, int curr){

        if(curr == 1) return;

        ShortestNodeInfo nodeInfo = dp[curr];

        for(Integer nodeNum : nodeInfo.prevNode){

            if(nodeNum == geunwoo){
                isPossible = true;
                return;
            }

            backTracking(dp, geunwoo, nodeNum);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int edgeNum = Integer.parseInt(stringTokenizer.nextToken());
        int geunwoo = Integer.parseInt(stringTokenizer.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        ShortestNodeInfo[] dp = new ShortestNodeInfo[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i] = new ShortestNodeInfo(Integer.MAX_VALUE);
        }

        for(int i = 0; i < edgeNum; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());
            int val = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(node1).add(new Node(node2, val));
            graph.get(node2).add(new Node(node1, val));
        }

        dijkstra(graph, dp);

        isPossible = false;

        backTracking(dp, geunwoo, n);

//        for(int i = 0; i <= n; i++){
//            System.out.println("여기는 : " + i + " " + dp[i].val);
//            System.out.println("이전 노드들 ");
//            for(Integer prev : dp[i].prevNode){
//                System.out.print(prev + " ");
//            }
//            System.out.println();
//        }

        if(isPossible) System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");
    }
}