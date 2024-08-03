import java.util.*;
import java.io.*;

public class Main{

    public static int find(int[] parent, int num){
        if(parent[num] == num) return num;
        else return find(parent, parent[num]);
    }

    public static void union(int[] parent, int num1, int num2){
//        num1 = find(parent, num1);
//        num2 = find(parent, num2);

        int min = Math.min(num1, num2);

        parent[num1] = min;
        parent[num2] = min;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());

        int[] parent = new int[nodeNum];
        for(int i = 0; i < nodeNum; i++){
            parent[i] = i;
        }

        int ans = 0;

        for(int i = 0; i < edgeNum; i++){
            st = new StringTokenizer(bf.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            int node1Parent = find(parent, node1);
            int node2Parent = find(parent, node2);

            if(node1Parent == node2Parent){
                ans = i + 1;
                break;
            }
            else{
                union(parent, node1Parent, node2Parent);
            }
        }
        System.out.println(ans);
    }
}