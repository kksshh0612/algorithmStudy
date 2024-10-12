import java.util.*;
import java.io.*;

// n개 퀸이 서로 공격 못하게 놓는 방법 수
public class Main {

    public static int size;
    public static List<List<Node>> graph;

    public static class Node{
        int dest, val;

        public Node(int d, int v){
            this.dest = d;
            this.val = v;
        }
    }

    public static class DijkstraNode{
        int num, val;

        public DijkstraNode(int n, int v){
            this.num = n;
            this.val = v;
        }
    }

    public static int dijkstra(int start, int end){
        int[] dp = new int[size + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        boolean[] check = new boolean[size + 1];

        PriorityQueue<DijkstraNode> pq = new PriorityQueue<>(new Comparator<DijkstraNode>(){
            @Override
            public int compare(DijkstraNode o1, DijkstraNode o2){
                return o1.val - o2.val;
            }
        });

        pq.add(new DijkstraNode(start, 0));
        dp[start] = 0;

        while(!pq.isEmpty()){
            DijkstraNode currNode = pq.poll();

            check[currNode.num] = true;             // 방문 처리

            // 현재 탐색중인 노드에 연결된 노드 탐색
            for(Node nextNode : graph.get(currNode.num)){
                if(dp[currNode.num] + nextNode.val < dp[nextNode.dest]){
                    dp[nextNode.dest] = dp[currNode.num] + nextNode.val;
                    pq.add(new DijkstraNode(nextNode.dest, dp[nextNode.dest]));
                }
            }

            if(currNode.num == end) break;
        }

        return dp[end];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        size = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i <= size; i++){
            graph.add(new ArrayList<>());
        }

        //그래프 입력
        for(int i = 0 ; i < edgeSize; i++){
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, val));
            graph.get(end).add(new Node(start, val));
        }

        st = new StringTokenizer(bf.readLine());
        int needNode1 = Integer.parseInt(st.nextToken());
        int needNode2 = Integer.parseInt(st.nextToken());

        // 1 - needNode1 - needNode2 - size
        int ans1 = 0;
        if(dijkstra(1, needNode1) == Integer.MAX_VALUE
                || dijkstra(needNode1, needNode2) == Integer.MAX_VALUE
                || dijkstra(needNode2, size) == Integer.MAX_VALUE){
            ans1 = Integer.MAX_VALUE;
        }
        else{
            ans1 = dijkstra(1, needNode1) + dijkstra(needNode1, needNode2) + dijkstra(needNode2, size);
        }

        int ans2 = 0;
        if(dijkstra(1, needNode2) == Integer.MAX_VALUE
                || dijkstra(needNode2, needNode1) == Integer.MAX_VALUE
                || dijkstra(needNode1, size) == Integer.MAX_VALUE){
            ans2 = Integer.MAX_VALUE;
        }
        else{
            ans2 = dijkstra(1, needNode2) + dijkstra(needNode2, needNode1) + dijkstra(needNode1, size);
        }


        int ans = Math.min(ans1, ans2);
        if(ans == Integer.MAX_VALUE){
            ans = -1;
        }
        
        System.out.println(ans);
    }
}