import java.util.*;
import java.io.*;

public class Main {

    public static List<List<Node>> graph = new ArrayList<>();
    public static int nodeSize, start, end;

    public static class Node{
        int dest, val;
        public Node(int d, int v){
            this.dest = d;
            this.val = v;
        }
    }

    // minVal 이상인 경로만 탐색해서 start부터 end까지 갈 수 있는지 판단
    public static boolean bfs(int minVal){
        Queue<Node> queue = new LinkedList<>();
        boolean[] check = new boolean[nodeSize + 1];
        queue.add(new Node(start, 0));
        check[start] = true;

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            for(Node next : graph.get(curr.dest)){      //노드에 연결된 노드 탐색
                if(check[next.dest]) continue;
                if(next.val < minVal) continue;

                if(next.dest == end) return true;

                check[next.dest] = true;
                queue.add(next);
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= nodeSize; i++){
            graph.add(new ArrayList<>());
        }

        int min = Integer.MAX_VALUE, max = 0;

        for(int i = 0; i < edgeSize; i++){
            st = new StringTokenizer(bf.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            graph.get(node1).add(new Node(node2, val));
            graph.get(node2).add(new Node(node1, val));

            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());;

        // 이분탐색으로 경로 최솟값 구하고 그 위로만 그래프 탐색하기
        while(min <= max){
            int mid = (min + max) / 2;

            boolean possiblePah = bfs(mid);

            if(possiblePah){
                min = mid + 1;
            }
            else{
                max = mid - 1;
            }
        }
        System.out.println(max);
    }
}