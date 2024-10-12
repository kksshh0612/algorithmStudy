import java.util.*;
import java.io.*;

// n개 퀸이 서로 공격 못하게 놓는 방법 수
public class Main {

    public static int subSize, caseSize;
    public static List<List<Integer>> graph;
    public static int[] ans;

    // 진입차수 0인 것들 큐에 넣고 탐색
    public static void search(int[] indegree){
        Queue<Integer> queue = new LinkedList<>();      // 진입차수 0인 것들

        for(int i = 1; i <= subSize; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int semester = 1;
        while(!queue.isEmpty()){
            int currTurnSize = queue.size();

            while(currTurnSize-- > 0){
                int curr = queue.poll();        // 여기서 빠졌다는 것은 진입차수 없다느 것.

                ans[curr] = semester;
                for(int next : graph.get(curr)){
                    if(--indegree[next] == 0){      // 선수과목 다 들었으면 추가
                        queue.add(next);
                    }
                }
            }
            semester++;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        subSize = Integer.parseInt(st.nextToken());
        caseSize = Integer.parseInt(st.nextToken());

        int[] indegree = new int[subSize + 1];
        ans = new int[subSize + 1];

        graph = new ArrayList<>();
        for(int i = 0; i <= subSize; i++){
            graph.add(new ArrayList<>());
        }

        // 초기 세팅
        for(int i = 0; i < caseSize; i++){
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            indegree[end]++;
        }

        // 탐색
        search(indegree);

        StringBuilder ansBuilder = new StringBuilder();
        for(int i = 1; i <= subSize; i++){
            ansBuilder.append(ans[i]).append(" ");
        }

        System.out.println(ansBuilder.toString());
    }
}