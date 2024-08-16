import java.io.*;
import java.util.*;

// 후보들 중, 최단거리 경로에 g-h를 지나는 후보 출력
public class Main {

    public static class Node{
        int dest, val;
        public Node(int d, int v){
            this.dest = d;
            this.val = v;
        }
    }

    public static int dijkstra(int start, int end, List<List<Node>> graph, int nodeSize){
        boolean[] check = new boolean[nodeSize + 1];
        int[] dp = new int[nodeSize + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node o1, Node o2){
                return o1.val - o2.val;
            }
        });

        pq.add(new Node(start, 0));
        dp[start] = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(check[curr.dest]) continue;
            check[curr.dest] = true;

            for(Node next : graph.get(curr.dest)){

                if(check[next.dest]) continue;

                if(dp[curr.dest] + next.val < dp[next.dest]){
                    dp[next.dest] = dp[curr.dest] + next.val;
                    pq.add(new Node(next.dest, dp[next.dest]));
                }
            }
        }

        return dp[end];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(bf.readLine());

        StringBuilder ansBuilder = new StringBuilder();

        while(tCase-- > 0) {
            List<List<Node>> graph = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int nodeSize = Integer.parseInt(st.nextToken());
            int edgeSize = Integer.parseInt(st.nextToken());
            int targetSize = Integer.parseInt(st.nextToken());      //목적지 후보 갯수

            int[] targetArr = new int[targetSize];

            for (int i = 0; i <= nodeSize; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int needToGoNode1 = Integer.parseInt(st.nextToken());
            int needToGoNode2 = Integer.parseInt(st.nextToken());

            for (int i = 0; i < edgeSize; i++) {
                st = new StringTokenizer(bf.readLine());

                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());

                graph.get(node1).add(new Node(node2, val));
                graph.get(node2).add(new Node(node1, val));
            }

            for(int i = 0; i < targetSize; i++){
                targetArr[i] = Integer.parseInt(bf.readLine());
            }

            List<Integer> ansList = new ArrayList<>();

            // 다익스트라 시작
            for(int end : targetArr){
                // start -> needToGoNode1 -> needToGoNode2 -> end
                long return1 =  dijkstra(start, needToGoNode1, graph, nodeSize)
                        + dijkstra(needToGoNode1, needToGoNode2, graph, nodeSize)
                        + dijkstra(needToGoNode2, end, graph, nodeSize);
                // start -> needToGoNode2 -> needToGoNode1 -> end
                long return2 =  dijkstra(start, needToGoNode2, graph, nodeSize)
                        + dijkstra(needToGoNode2, needToGoNode1, graph, nodeSize)
                        + dijkstra(needToGoNode1, end, graph, nodeSize);
                // start -> end
                long startToEnd =  dijkstra(start, end, graph, nodeSize);

                // 무조건 거친 것(return1, return2) 중에 최단거리와
                // 그냥 start 부터 end까지 최단거리가 같으면 정답임.
                if(Math.min(return1, return2) == startToEnd){
                    ansList.add(end);
                }
            }
            Collections.sort(ansList);

            for(Integer ans : ansList){
                ansBuilder.append(ans).append(" ");
            }
            ansBuilder.append("\n");
        }

        System.out.println(ansBuilder.toString());
    }
}