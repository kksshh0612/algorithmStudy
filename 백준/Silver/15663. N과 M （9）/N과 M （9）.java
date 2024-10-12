import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    public static int n, m;
    public static int[] arr;
    public static StringBuilder ans = new StringBuilder();

    // 현재 같은 depth에 이 숫자가 들어갔냐..
    public static void dfs(int depth, boolean[] check, int[] currArr){
        if(depth == m){
            for(int num : currArr){
                ans.append(num).append(" ");
            }
            ans.append("\n");
        }
        else{
            int before = 0;                 // 현재 턴에서 직전에 나온 숫자 저장
            for(int i = 0; i < n; i++){
                if(check[i] || before == arr[i]) continue;

                currArr[depth] = arr[i];
                before = arr[i];
                check[i] = true;
                dfs(depth + 1, check, currArr);
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

        dfs(0, new boolean[n], new int[m]);

        System.out.println(ans.toString());
    }
}