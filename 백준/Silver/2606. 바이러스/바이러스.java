import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유니온 파인드
public class Main {

    public static int[] parent;

    public static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static void union(int num1, int num2){
        num1 = find(num1);
        num2 = find(num2);

        int integRoot = Math.min(num1, num2);

        parent[num1] = integRoot;
        parent[num2] = integRoot;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int size = Integer.parseInt(bufferedReader.readLine());

        parent = new int[n + 1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < size; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int num1 = Integer.parseInt(stringTokenizer.nextToken());
            int num2 = Integer.parseInt(stringTokenizer.nextToken());
            union(num1, num2);
        }

        int cnt = 0;

//        System.out.print(parent[1] + " ");

        for(int i = 2; i <= n; i++){
            if(find(i) == 1) cnt++;
//            System.out.print(parent[i] + " ");
        }
//        System.out.println();

        System.out.println(cnt);
    }
}
/*
7
6
2 3
5 2
5 6
4 7
1 2
1 5

이 경우 부모 못찾아가는 문제. 그니까 부모 갱신이 안됨.
 */