import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class Boj1182 {
public class Main {
    public static int ans;

    public static void DFS(int[] arr, int sum, int currIdx, int size, boolean[] check){
        if(currIdx == size){        // 모두 탐색했으면 확인
            int localSum = 0;
            boolean isNull = true;
            for(int i = 0; i < size; i++){
                if(check[i]){
                    localSum += arr[i];
                    isNull = false;         //공집합을 거르기 위함. true가 한번이라도 있으면 공집합이 아님.
                }
            }
            if(localSum == sum && !isNull) {
                ans++;
            }
        }
        else{
            check[currIdx] = true;
            DFS(arr, sum, currIdx + 1, size, check);
            check[currIdx] = false;
            DFS(arr, sum, currIdx + 1, size, check);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int size = Integer.parseInt(stringTokenizer.nextToken());
        int sum = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[size];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        boolean[] check = new boolean[size];
        ans = 0;

        DFS(arr, sum, 0, size, check);

        System.out.println(ans);
    }
}