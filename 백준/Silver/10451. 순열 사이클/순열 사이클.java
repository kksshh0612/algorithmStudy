import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(bf.readLine());
        while(tCase-- > 0){
            int size = Integer.parseInt(bf.readLine());
            int[] arr = new int[size];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i = 0; i < size; i++){
                arr[i] = Integer.parseInt(st.nextToken()) - 1;
            }
            int ans = 0;

            boolean[] check = new boolean[size];
            for(int i = 0; i < size; i++){
                if(check[i]) continue;

                int num = i;
                while(true){
                    check[num] = true;

                    if(check[arr[num]]){
                        ans++;
                        break;
                    }
                    num = arr[num];
                }
            }

            System.out.println(ans);
        }
    }
}