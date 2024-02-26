import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0 -> union / 1 -> find
public class Main {

    public static int find(int[] parent, int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent, parent[x]);
    }

    public static void union(int[] parent, int a, int b){
        a = find(parent, a);
        b = find(parent, b);

        int min = Math.min(a, b);

        parent[a] = min;
        parent[b] = min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int size = Integer.parseInt(stringTokenizer.nextToken());

        int[] parent = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

//        for(int i = 0; i <= n; i++){
//            System.out.print(parent[i] + " ");
//        }
//        System.out.println();

        for(int i = 0; i < size; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int command = Integer.parseInt(stringTokenizer.nextToken());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            if(command == 0){
                union(parent, a, b);
//                System.out.println("유니온 : " + a + " " + b);
//                for(int j = 0; j <= n; j++){
//                    System.out.print(parent[j] + " ");
//                }
//                System.out.println();
            }
            else{
                if(find(parent, a) == find(parent, b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
//        for(int i = 0; i <= n; i++){
//            System.out.print(parent[i] + " ");
//        }
    }
}