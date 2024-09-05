import java.util.*;
import java.io.*;

// 팰린드롬이 아닌 부분문자열 구하기
// 최소 한개 모음 두개 자음
// 다 뽑고 자음 모음 몇갠지 세기
public class Main {

    public static int targetSize, totalSize;
    public static char[] arr;
    public static StringBuilder ans;

    public static void dfs(int size, int idx, boolean[] check){
        if(size == targetSize){
            StringBuilder curr = new StringBuilder();
            int mom = 0, son = 0;
            for(int i = 0; i < check.length; i++){
                if(check[i]){       // 현재 조합에 포함된 문자이면
                    curr.append(arr[i]);
                    char c = arr[i];
                    if(c == 'a' || c == 'e' || c == 'i' || c =='o' || c == 'u'){
                        mom++;
                    }
                    else{
                        son++;
                    }
                }
            }

            if(mom >= 1 && son >= 2) ans.append(curr).append("\n");
        }
        else{
            for(int i = idx; i < totalSize; i++){
                check[i] = true;
                dfs(size + 1, i + 1, check);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        targetSize = Integer.parseInt(st.nextToken());
        totalSize = Integer.parseInt(st.nextToken());
        arr = new char[totalSize];

        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < totalSize; i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        ans = new StringBuilder();

        dfs(0, 0, new boolean[totalSize]);

        System.out.println(ans.toString());
    }
}