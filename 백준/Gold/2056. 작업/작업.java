import java.util.*;
import java.io.*;
// 선행관계 없는 작업들 동시 수행 가능
// 모든 작업 완료하는데 필요한 최소 시간
// 노드마다 현재 작업 처리 시간, 누적 시간 기록. 누적 시간 젤 큰 것 선택.
public class Main {

    public static class Node{
        int stackedTime, currTime;

        public Node(int s, int c){
            this.stackedTime = s;
            this.currTime = c;
        }
    }

    public static int sort(List<List<Integer>> graph, Node[] nodeArr, int[] indegree){
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < nodeArr.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(Integer next : graph.get(curr)){
                indegree[next]--;
                if(nodeArr[curr].stackedTime + nodeArr[next].currTime > nodeArr[next].stackedTime){
                    nodeArr[next].stackedTime = nodeArr[curr].stackedTime + nodeArr[next].currTime;
                }

                if(indegree[next] == 0) queue.add(next);
            }
        }

        int max = 0;
        for(int i = 1; i < nodeArr.length; i++){
            max = Math.max(max, nodeArr[i].stackedTime);
        }

        return max;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());

        List<List<Integer>> graph = new ArrayList<>();      // 그래프
        Node[] nodeArr = new Node[size + 1];                // 누적 시간, 현재 작업 처리 시간
        int[] indegree = new int[size + 1];                 // 진입 차수

        for(int i = 0; i <= size; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < size; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int time = Integer.parseInt(st.nextToken());
            int preSize = Integer.parseInt(st.nextToken());

            nodeArr[i + 1] = new Node(time, time);

            for(int j = 0; j < preSize; j++){
                int pre = Integer.parseInt(st.nextToken());

                indegree[i + 1]++;
                graph.get(pre).add(i + 1);
            }
        }

        System.out.println(sort(graph, nodeArr, indegree));
    }
}