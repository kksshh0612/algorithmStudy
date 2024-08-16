import java.io.*;
import java.util.*;

// 번호가 다른 번호의 접두어이면 안됨.
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();

        while(tCase-- > 0){
            int size = Integer.parseInt(br.readLine());

            String[] arr = new String[size];
            for(int i = 0; i < size; i++){
                arr[i] = br.readLine();
            }
            // 길이 오름차순 정렬
            Arrays.sort(arr);           //문자 기준 정렬. 빠른 순으로 정렬됨.

            boolean check = true;
            for(int i = 0; i < size - 1; i++){
                if(arr[i + 1].startsWith(arr[i])) {
                    check = false;
                    break;
                }
            }
         
            ans.append(check ? "YES" : "NO").append("\n");
        }
        System.out.println(ans.toString());
    }
}