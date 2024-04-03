import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// M와 W만 연결해서 최소 비용으로 모두 연결하기.    연결 못하면 -1
public class Main {

    public static class PartialGraph{
        int node1, node2, val;

        public PartialGraph(int node1, int node2, int val){
            this.node1 = node1;
            this.node2 = node2;
            this.val = val;
        }
    }

    public static int find(int[] parent, int x){
        if(x == parent[x]) return x;
        else return find(parent, parent[x]);
    }

    public static void union(int[] parent, int x, int y){
        x = find(parent, x);
        y = find(parent, y);

        int min = Math.min(x, y);

        parent[x] = min;
        parent[y] = min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int schoolNum = Integer.parseInt(stringTokenizer.nextToken());
        int roadNum = Integer.parseInt(stringTokenizer.nextToken());
        boolean[] genderArr = new boolean[schoolNum];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < schoolNum; i++){
            genderArr[i] = stringTokenizer.nextToken().equals("M") ? true : false;      //남자면 true 여자면 false
        }

        int[] parent = new int[schoolNum];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }

        PriorityQueue<PartialGraph> priorityQueue = new PriorityQueue<>(new Comparator<PartialGraph>() {
            @Override
            public int compare(PartialGraph o1, PartialGraph o2) {
                return o1.val - o2.val;
            }
        });

        for(int i = 0; i < roadNum; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int node1 = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int node2 = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int val = Integer.parseInt(stringTokenizer.nextToken());

            priorityQueue.add(new PartialGraph(node1, node2, val));
        }

        int valSum = 0, cnt = 0;

        while(!priorityQueue.isEmpty()){
            PartialGraph curr = priorityQueue.poll();

            if(genderArr[curr.node1] == genderArr[curr.node2]) continue;            //성별 같으면 pass

            if(find(parent, curr.node1) == find(parent, curr.node2)) continue;      //이미 연결됐으면 pass

            union(parent, curr.node1, curr.node2);
            valSum += curr.val;
            cnt++;

        }

        if(cnt != schoolNum - 1) valSum = -1;
        System.out.println(valSum);
    }
}