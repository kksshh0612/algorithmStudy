import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder stringBuilder;

    public static void DFS(int[] arr, boolean[] check, int currCnt, int start){
        if(currCnt == 6){

            for(int i = 0; i < arr.length; i++){
                if(check[i]) stringBuilder.append(arr[i]).append(" ");
            }
            stringBuilder.append("\n");
        }
        else{
            for(int i = start; i < arr.length; i++){
                if(check[i]) continue;

                check[i] = true;
                DFS(arr, check, currCnt + 1, i + 1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        stringBuilder = new StringBuilder();

        while(stringTokenizer.countTokens() > 1){
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int[] arr = new int[n];

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            boolean[] check = new boolean[n];

            DFS(arr, check, 0, 0);
            stringBuilder.append("\n");

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        }

        System.out.println(stringBuilder.toString());

    }
}