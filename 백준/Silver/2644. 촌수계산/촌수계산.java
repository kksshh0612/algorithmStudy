import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 부모-자식 : 1촌 , 주어진 두 사람의 촌 수 계산
// 그래프 구현해서 DFS로 깊이 구하기 -> 단뱡향 두개면 양방향임 
//public class Boj2644 {
public class Main {
    static int depth;

    public static void DFS(boolean[] isVisited, int curr, int goal, int currDepth, List<List<Integer>> graph){
        if(curr == goal){
            depth = currDepth;
        }
        else{
            if(!isVisited[curr]){
                isVisited[curr] = true;
                for(Integer node : graph.get(curr)){
                    DFS(isVisited, node, goal, currDepth + 1, graph);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(bufferedReader.readLine());       //총 사람 수
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int person1 = Integer.parseInt(stringTokenizer.nextToken());
        int person2 = Integer.parseInt(stringTokenizer.nextToken());    //촌 수 계산해야 하는 사람 번호
        int num = Integer.parseInt(bufferedReader.readLine());

        List<List<Integer>> graph = new ArrayList<>();                  //양방향
        for(int i = 0; i <= people; i++){                               //0~n번 사람 리스트 추가
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < num; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int parent = Integer.parseInt(stringTokenizer.nextToken());
            int child = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }

        boolean[] isVisited = new boolean[people + 1];
        depth = -1;
        DFS(isVisited, person1, person2, 0, graph);

        System.out.println(depth);
    }
}