import java.util.*;
import java.io.*;

public class Main {

    public static int[] arr;
    public static int n, m;
    public static StringBuilder ans = new StringBuilder();

    public static void dfs(int size, int currIdx, int[] currArr, boolean[] check){
        if(size == m){
            for(int i = 0; i < currArr.length; i++){
                ans.append(currArr[i]).append(" ");
            }
            ans.append("\n");
        }
        else{
            for(int i = 0; i < n; i++){
                if(check[i]) continue;
                currArr[currIdx] = arr[i];
                check[i] = true;
                dfs(size + 1, currIdx + 1, currArr, check);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0, new int[m], new boolean[n]);

        System.out.println(ans);
    }
}